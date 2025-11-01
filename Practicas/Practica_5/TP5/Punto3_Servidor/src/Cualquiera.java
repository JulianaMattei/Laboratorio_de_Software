@Servidor(direccion = "localhost", puerto = 8080, archivo = "testeo.txt")
public class Cualquiera {

    @Invocar
    public void unMetodoInvocado() {
        System.out.println("Invocando unMetodoInvocado");
    }

    public void unMetodoNoInvocado() {
        System.out.println("Invocando unMetodoNoInvocado");
    }
}
