package com.feature.learn.classloader;

import java.io.*;

/**
 * @author vector
 * @date: 2019/10/9 0009 11:47
 */
public class MyClassLoader extends ClassLoader {

    private String classPath;

    public MyClassLoader(String classPath) {
        this.classPath = classPath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte[] classBinaryData = getClassBinaryData(name);
            if (classBinaryData == null) {

            } else {
                return defineClass(name, classBinaryData, 0, classBinaryData.length);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.findClass(name);
    }

    private byte[] getClassBinaryData(String name) throws IOException {
        InputStream in = null;
        ByteArrayOutputStream out = null;
        String path = classPath + File.separatorChar + name.replace('.', File.separatorChar) + ".class";
        try {
            in = new FileInputStream(path);
            out = new ByteArrayOutputStream();
            byte[] buffer = new byte[2048];
            int len = 0;
            while ((len = in.read(buffer)) != -1) {
                out.write(buffer, 0, len);
            }
            return out.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            in.close();
            out.close();
        }
        return null;
    }
}
