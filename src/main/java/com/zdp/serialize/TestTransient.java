package com.zdp.serialize;

import java.io.*;

/**
 * Created by dapeng.zhou on 2017/5/3.
 */
public class TestTransient implements Serializable{
    transient String name;

    public TestTransient(String name) {
        this.name = name;
    }

    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.writeObject(name);
    }

    private void readObject(ObjectInputStream stream) throws IOException,
            ClassNotFoundException {
        this.name = (String) stream.readObject();
    }

    @Override
    public String toString() {
        return "TestTransient{" +
                "name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) throws IOException,
            ClassNotFoundException {
        TestTransient tt = new TestTransient("Test1");
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        ObjectOutputStream o = new ObjectOutputStream(buf);
        o.writeObject(tt);
        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(
                buf.toByteArray()));
        TestTransient tt2 = (TestTransient) in.readObject();
        System.out.println("After:\n" + tt2);
    }
}
