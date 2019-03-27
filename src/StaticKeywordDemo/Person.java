package StaticKeywordDemo;

public class Person {

    public static int instanceCount;
    public int localCount;

     Person()
    {
        instanceCount++;
        localCount++;
    }

    public static void main(String []args)
    {
        Person p1 = new Person();
        Person p2 = new Person();
        Person p3 = new Person();
        Person p4 = new Person();

        System.out.println("Ins count -->"+Person.instanceCount+" Loc Count -->"+p4.localCount);
    }
}
