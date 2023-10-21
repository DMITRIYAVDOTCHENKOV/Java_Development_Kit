package seminar3;

import java.io.DataInput;
import java.io.InputStream;

public class MyClass<T extends Comparable<T>, V extends InputStream & DataInput, K extends Number> {
    T t;
    V v;
    K k;

    public MyClass(T t, V v, K k) {
        this.t = t;
        this.v = v;
        this.k = k;
    }

    public T getT() {
        return t;
    }

    public V getV() {
        return v;
    }

    public K getK() {
        return k;
    }

    public void print(){
        System.out.println("T: " + t.getClass().getName());
        System.out.println("K: " + k.getClass().getName());
        System.out.println("V: " + v.getClass().getName());
    }
}