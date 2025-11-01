import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.net.InetSocketAddress;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.lang.reflect.Method;

public class Contenedor {

    public static void procesar(Object object)  {
        Class<?> clazz = object.getClass();

        if (!clazz.isAnnotationPresent(Servidor.class)) {
            System.out.println("La clase no está anotada con @Servidor");
            return;
        }

        Servidor servidor = clazz.getAnnotation(Servidor.class);
        if (servidor != null) {
            String direccion = servidor.direccion();
            int puerto = servidor.puerto();
            String archivo = servidor.archivo();
            List<Method> metodos = obtenerMetodos(clazz);

            try {
                iniciarServidor(direccion, puerto, archivo, metodos, object);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static List<Method> obtenerMetodos(Class<?> clazz) {
        List<Method> metodos = new ArrayList<>();
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Invocar.class)) {
                metodos.add(method);
            }
        }
        return metodos;
    }

    private static void iniciarServidor(String direccion, int puerto, String archivo,
                                        List<Method> metodos, Object object)
            throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(direccion, puerto), 0);
        server.createContext("/", new Manejador(archivo, metodos, object));
        server.createContext("/favicon.ico", new HttpHandler() {
            @Override
            public void handle(HttpExchange exchange) throws IOException {
                exchange.sendResponseHeaders(204, -1);
                exchange.close();
            }
        });
        server.setExecutor(null);
        server.start();
        System.out.println("Servidor Iniciado en http://" + direccion + ":" + puerto);
    }

    private static class Manejador implements HttpHandler {
        private String archivo;
        private List<Method> metodos;
        private Object object;

        public Manejador(String archivo, List<Method> metodos, Object object) {
            this.archivo = archivo;
            this.metodos = metodos;
            this.object = object;
        }

        @Override
        public void handle(HttpExchange request) throws IOException {
            System.out.println("Manejador recibido: " + request.getRequestURI());
            this.invocar();
            this.logear(request);
            this.enviarRespuesta(request);
        }

        private void invocar() {
            for (Method metodo : metodos) {
                try {
                    metodo.invoke(object);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }

        private void logear(HttpExchange request) throws IOException {
            String IP = request.getRemoteAddress().getAddress().getHostAddress();
            String fechaHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            try (FileWriter fw = new FileWriter(archivo, true)) {
                fw.write(fechaHora + " " + IP + "\n");
            }
        }

        private void enviarRespuesta(HttpExchange request) throws IOException {
            System.out.println("Manejador recibido: " + request.getRequestURI());
            String response = "<html><body><h1>Servidor funcionando!</h1></body></html>";
            request.getResponseHeaders().set("Content-Type", "text/html");
            request.sendResponseHeaders(200, response.getBytes().length);
            try (OutputStream os = request.getResponseBody()) {
                os.write(response.getBytes());
            }
        }
    }

    public static void main(String[] args) {

        Cualquiera clase = new Cualquiera();

        try {
            procesar(clase);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
