/*
package com.classloader;

import java.io.*;

public class MyClassLoader extends ClassLoader {

    private String classPath;

    public MyClassLoader(String classPath) {
        this.classPath = classPath;
    }

    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            String fileName = classPath + "/" + name + ".class";
            byte[] classData = loadClassData(fileName);
            return defineClass(name, classData, 0, classData.length);
        } catch (IOException e) {
            throw new ClassNotFoundException("Could not load class: " + name);
        }
    }

    private byte[] loadClassData(String filePath) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int ch;
        while ((ch = fis.read()) != -1) {
            baos.write(ch);
        }
        return baos.toByteArray();
    }
}
*/
