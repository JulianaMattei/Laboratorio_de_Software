import java.io.IOException;

public class TestBeanMapper {

    public static void main(String[] args) throws IOException {
        Persona p = new Persona("Juan", 25, "Ignorado");
        BeanMapper.save(p);
    }

}
