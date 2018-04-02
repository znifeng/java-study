package io;

import java.io.*;

public class FileStreamTest {
    private static  final String TMP_FILE = "test.tmp";
    private static  final String OUTPUT_FILE_NAME = "out.tmp";
    public static void main(String[] args){
//        testWrite();
        testRead();
    }

    private static void testWrite() {
        try {
            // 创建文件“file.txt”对应File对象
            File file = new File(OUTPUT_FILE_NAME);
            System.out.println(file.getAbsolutePath());
            // 创建文件“file.txt”对应的FileOutputStream对象，默认是关闭“追加模式”
            FileOutputStream fileOut1 = new FileOutputStream(file);
            // 创建FileOutputStream对应的PrintStream，方便操作。PrintStream的写入接口更便利
            PrintStream out1 = new PrintStream(fileOut1);
            // 向“文件中”写入26个字母
            out1.println("abcdefghijklmnopqrstuvwxyz");
            out1.close();

             // 创建文件“file.txt”对应的FileOutputStream对象，打开“追加模式”
            FileOutputStream fileOut2 = new FileOutputStream(file, true);
            // 创建FileOutputStream对应的PrintStream，方便操作。PrintStream的写入接口更便利
            PrintStream out2 = new PrintStream(fileOut2);
            // 向“文件中”写入"0123456789"+换行符
            out2.println("0123456789");
            out2.close();
            fileOut2.close();
            } catch(Exception e) {
            e.printStackTrace();
            }
        }

    public static void testRead(){
        try{
            //方法1：新建FileInputStream对象
            //使用文件对应File对象
            File file = new File(TMP_FILE);
            FileInputStream in1 = new FileInputStream(file);

            //方法2：新建FileInputStream对象
            //直接使用文件名
            FileInputStream in2 = new FileInputStream(TMP_FILE);

            //方法3：新建FileInputStream对象
            //使用文件描述符
            FileDescriptor fdin = in2.getFD();
            FileInputStream in3 = new FileInputStream(fdin);
            // 测试read()，从中读取一个字节
            char c1 = (char)in1.read();
            System.out.println("c1="+c1);

            int length;
            byte [] bytes = new byte[1024];
            while ((length=in2.read(bytes)) != -1 ){
                System.out.println(new String(bytes, 0, length));
                System.out.println("========================");
            }

//            // 测试skip(long byteCount)，跳过4个字节
//            in1.skip(25);
//
//            // 测试read(byte[] buffer, int byteOffset, int byteCount)
//            byte[] buf = new byte[10];
//            in1.read(buf, 0, buf.length);
//            System.out.println("buf="+(new String(buf)));
//
//            // 创建“FileInputStream”对象对应的BufferedInputStream
//            BufferedInputStream bufIn = new BufferedInputStream(in3);
//            // 读取一个字节
//            char c2 = (char)bufIn.read();
//            System.out.println("c2="+c2);

            in1.close();
            in2.close();
            in3.close();


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
