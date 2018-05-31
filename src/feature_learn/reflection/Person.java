package feature_learn.reflection;


public class Person extends Animal implements China {

    private String name;
    private int age;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(int age) {
        this.age = age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public void sleeps() {
        System.out.println("i am sleeping");
    }

    @Override
    public void talk(String peopleName, String content) {
        System.out.println("i am talking to " + peopleName + " about " + content + "~");
    }
}


