package Sort;

import org.junit.Test;

import java.io.*;

/**
 * @Author Administrator
 * @Date 2021/9/8 9:29
 * @Version 1.0
 */
public class DeleteFileDir {
    File f;

    //创建目录
    boolean createFileDir() throws IOException {
        f = new File("File");
        return f.mkdirs();
    }

    //创建文件
    boolean createFile(String source) throws IOException {
        f = new File(f.getAbsolutePath(), source);
        return f.createNewFile();
    }

    //删除文件
    boolean deleteFile(File f) {
        if (f.isDirectory()) {
            File[] fs = f.listFiles();
            for (int i = 0; i < fs.length; i++) {
                deleteFile(fs[i]);
            }
        }
        return f.delete();
    }

    void copyFile(File srcFile, File targetFile) {

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(srcFile));
            bos = new BufferedOutputStream(new FileOutputStream(targetFile));
            byte[] b = new byte[1024];
            int length;
            while ((length = bis.read(b)) != -1) {
                bos.write(b, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    void printFile(File srcFile, File targetFile) {
        BufferedReader bis = null;
        PrintWriter bos = null;
        InputStreamReader isr;

        try {
            isr = new InputStreamReader(new FileInputStream(srcFile), "Shift_JIS");
            bis = new BufferedReader(isr);
            bos = new PrintWriter(new FileWriter(targetFile));
            char[] b = new char[1024];
            int length;
            while ((length = bis.read(b)) != -1) {
                bos.write(b, 0, length);
                for (char c : b)
                    System.out.print(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                bos.close();
            }
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Test
    public void testDelete() {

        printFile(new File("F:\\BaiduNetdiskDownload\\モノノ系彼女(待删)\\モノノ系彼女\\readme.txt"),
                new File("F:\\BaiduNetdiskDownload\\モノノ系彼女(待删)\\モノノ系彼女\\readme1.txt"));
       /* long startTime = System.currentTimeMillis();
        copyFile(new File("E:\\NewBaidu\\idanmu\\@oz\\[@OZ] アリスの森 快楽奴隷人形(スク水)\\[@OZ] アリスの森 快楽奴隷人形(スク水).mp4")
                , new File("E:\\NewBaidu\\idanmu\\@oz\\[@OZ] アリスの森 快楽奴隷人形(スク水)\\1.mp4"));
        long endTime = System.currentTimeMillis();
        long startTime1 = System.currentTimeMillis();
        printFile(new File("E:\\NewBaidu\\idanmu\\@oz\\[@OZ] アリスの森 快楽奴隷人形(スク水)\\[@OZ] アリスの森 快楽奴隷人形(スク水).mp4")
                , new File("E:\\NewBaidu\\idanmu\\@oz\\[@OZ] アリスの森 快楽奴隷人形(スク水)\\2.mp4"));
        long endTime1 = System.currentTimeMillis();
        System.out.println("缓冲流耗时: " + (endTime - startTime) + "   打印流耗时: " + (endTime1 - startTime1));*/
        //  copyFile(new File("C:\\Users\\Administrator\\Desktop\\1.txt"),new File("C:\\Users\\Administrator\\Desktop\\2.txt"));
        /*DeleteFileDir d = new DeleteFileDir();
        d.deleteFile(new File("C:\\Users\\Administrator\\Desktop\\1.txt"));*/

    }
    void objectR(){

        try {
            ObjectOutputStream i=new ObjectOutputStream(new FileOutputStream("person.dat"));
            i.writeObject(new Person("张三",'男',18));

            i.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    void objectG(){
        try {
            ObjectInputStream i=new ObjectInputStream(new FileInputStream("person.dat"));
            try {
               Person p= (Person)i.readObject();
                System.out.println(p.toString());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void test1(){
       objectG();
        // objectR();
    }
}
