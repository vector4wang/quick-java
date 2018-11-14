package feature_learn.generic.paradigm;

public class MulitReps {
    public static void main(String[] args) {
        Student s=new Student("小明","清华大学");
        Teacher t=new Teacher("cxyapi", "Java编程");
        CalTest<Student, Teacher> studentTeacherCalTest = new CalTest<>(s, t);
        System.out.println(studentTeacherCalTest);
    }
}
