package javase.day1111;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;

public class RecursionDemo2 {
    public static File search(File path,String filename){
        File[] files = path.listFiles();
        if (files != null && files.length > 0) {
            for (File f : files) {
                if (f.isDirectory()) {
                    File fileFinal = search(f,filename);
                    if (fileFinal == null){
                        continue;
                    }else {
                        return fileFinal;
                    }
                } else if (f.isFile()) {
                    if (f.getName().contains(filename)) {
                        return f;
                    }
                }
            }
            return null;
        }
        return null;
    }

    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        File launcher = search(new File("C:\\Program Files (x86)\\Tencent"),
                "QQScLauncher.exe");

        try {
            runtime.exec(launcher.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
