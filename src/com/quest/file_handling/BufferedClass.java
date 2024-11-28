package com.quest.file_handling;

import java.io.*;

public class BufferedClass {
    public static void main(String[] args) {
        String s1 = "this is string one with data";
        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream("file1.txt"));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("file2.txt"));
            byte[] buf = new byte[1024];
            int c;
            while ((c=bis.read(buf))!=-1){
//                System.out.println((char)c);
                bos.write(buf,0,c);
                System.out.println((char)c);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
