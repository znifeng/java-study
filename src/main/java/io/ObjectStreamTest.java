package io;

import java.io.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ObjectStreamTest {
    private static final String TMP_FILE = "object_stream_test.tmp";
    public static void main(String[] args){
//        Person znifeng = new Person("znifeng", 27, "ZJU", "James");
//        System.out.println(znifeng.toString());
        testWrite();
        testRead();
    }

    private static void testRead() {
        try {
            ObjectInputStream in = new ObjectInputStream(
                    new FileInputStream(TMP_FILE));
            System.out.printf("boolean:%b\n" , in.readBoolean());
            System.out.printf("byte:%d\n" , (in.readByte()&0xff));
            System.out.printf("char:%c\n" , in.readChar());
            System.out.printf("int:%d\n" , in.readInt());
            System.out.printf("float:%f\n" , in.readFloat());
            System.out.printf("double:%f\n" , in.readDouble());
            // 读取HashMap对象
            HashMap map = (HashMap) in.readObject();
            Iterator iter = map.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry)iter.next();
                System.out.printf("%-6s -- %s\n" , entry.getKey(), entry.getValue());
            }
            // 读取Box对象，Box实现了Serializable接口
            Person persion = (Person) in.readObject();
            System.out.println("person: " + persion);

            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void testWrite() {
        try {
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream(TMP_FILE));
            out.writeBoolean(true);
            out.writeByte((byte)65);
            out.writeChar('a');
            out.writeInt(20131015);
            out.writeFloat(3.14F);
            out.writeDouble(1.414D);
            // 写入HashMap对象
            HashMap map = new HashMap();
            map.put("one", "red");
            map.put("two", "green");
            map.put("three", "blue");
            out.writeObject(map);
            // 写入自定义的Box对象，Box实现了Serializable接口
            Person dongdong = new Person("dongdong", 1, "BinAn", "father");
            out.writeObject(dongdong);

            out.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
class Person implements Serializable{
    private String name;
    private int age;
    private String college;
    private String idol;
    public Person(String name, int age, String college, String idol){
        this.name = name;
        this.age = age;
        this.college=college;
        this.idol = idol;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        try{
            for (Field field: Person.class.getDeclaredFields()){
                sb.append(field.getName()).append(":").append(field.get(this).toString()).append("\n");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        sb.append("}");
        return sb.toString();
    }
}