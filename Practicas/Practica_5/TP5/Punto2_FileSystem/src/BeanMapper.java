import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;

public class BeanMapper {

    public static  void save(Object bean) throws IOException {
        Class<?> clazz = bean.getClass();

        File fileAnotacion = clazz.getAnnotation(File.class);
        String fileName = (fileAnotacion != null && !fileAnotacion.name().isEmpty())
                ? fileAnotacion.name()
                : clazz.getSimpleName()
                + ".txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("Clase: " + clazz.getName());
            writer.newLine();

            for (Field field : clazz.getDeclaredFields()) {
                if (field.isAnnotationPresent(StoreAttribute.class)) {
                    field.setAccessible(true);
                    Object value = field.get(bean);
                    writer.write(field.getName() + " = " + value);
                    writer.newLine();
                }
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Error al acceder a los atributos del bean", e);
        }
    }

}
