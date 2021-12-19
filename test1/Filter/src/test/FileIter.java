package test;

import org.junit.Test;

import java.io.File;

/**
 * @Author Administrator
 * @Date 2021/12/10 18:14
 * @Version 1.0
 */
public class FileIter {

    public void showFileName(File fileDir) {
        if (fileDir.isDirectory()) {
            File[] files = fileDir.listFiles();
            for (File f : files) {
                //判断是否是文件对象
                if (f.isFile()) {
                    System.out.println(f.getName());
                } else if (f.isDirectory()) {
                    //是一个目录对象
                    showFileName(f);
                    System.out.println(f.getPath());
                }
            }

        }

    }

    public boolean deleteFileName(File fileDir) {
        if (fileDir.isDirectory()) {
            File[] files = fileDir.listFiles();
            for (File f : files) {
                //判断是否是文件对象
                if (f.isFile()) {
                    f.delete();
                } else if (f.isDirectory()) {
                    //是一个目录对象
                    deleteFileName(f);
                }
            }
        }
        return fileDir.delete();

    }

    @Test
    public void test() {
        new FileIter().showFileName(new File("C:\\Users\\Administrator\\Desktop\\a"));

    }
}
