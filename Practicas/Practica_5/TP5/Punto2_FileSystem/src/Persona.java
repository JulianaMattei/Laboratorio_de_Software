@File(name = "persona.txt")
public class Persona {
    @StoreAttribute
    private String name;

    @StoreAttribute
    private int age;

    private String ignoredField;

    public Persona(String name, int age, String ignoredField) {
        this.name = name;
        this.age = age;
        this.ignoredField = ignoredField;
    }
}
