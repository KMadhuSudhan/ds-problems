package ds.problems.test;

import java.io.Serializable;

public class Singleton implements Cloneable,Serializable {
    private static Singleton obj = new Singleton();

    private Singleton() {}

    public static Singleton getInstance()
    {
        return obj;
    }

    public Object clone() throws
            CloneNotSupportedException
    {
        return super.clone();
    }
}
