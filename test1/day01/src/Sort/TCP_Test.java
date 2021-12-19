package Sort;

import org.junit.Test;

import java.io.*;
import java.net.*;

/**
 * @Author Administrator
 * @Date 2021/9/10 1:24
 * @Version 1.0
 */
public class TCP_Test {
    void client() {

        Socket s = null;
        OutputStream os = null;
        InputStream is = null;
        ByteArrayOutputStream bos = null;
        try {
            s = new Socket(InetAddress.getByName("127.0.0.1"), 8899);
            os = s.getOutputStream();
            os.write("哈啊哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈".getBytes());
            is = s.getInputStream();
            bos = new ByteArrayOutputStream();
            s.shutdownOutput();
            byte[] b = new byte[5];
            int len;
            while ((len = is.read(b)) != -1) {
                bos.write(b, 0, len);
            }
            System.out.println(s.getInetAddress() + bos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (s != null)
                    s.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (os != null)
                    os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    void server() {
        Socket s = null;
        InputStream is = null;
        OutputStream os = null;
        ServerSocket ss = null;
        ByteArrayOutputStream bos = null;


        try {
            ss = new ServerSocket(8899);
            s = ss.accept();
            os = s.getOutputStream();
            is = s.getInputStream();
            bos = new ByteArrayOutputStream();
            int len;
            byte[] b = new byte[5];
            while ((len = is.read(b)) != -1) {
                // System.out.println(b);
                bos.write(b, 0, len);
            }

            System.out.println(s.getInetAddress() + bos.toString());
            os.write("我已收到".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (s != null)
                    s.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (is != null)
                    is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (ss != null)
                    ss.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bos != null)
                    bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testServer() {
        //  server();
        try (DatagramSocket ds = new DatagramSocket(8890)) {
            byte[] b = new byte[100];
            DatagramPacket dp = new DatagramPacket(b, 0, b.length);
            dp.setPort(8890);
            ds.receive(dp);
            System.out.println(new String(dp.getData(), 0, dp.getLength()));
            dp.setData("哈个毛".getBytes());
            ds.send(dp);
            //     System.out.println(new String(dp.getData(), 0, dp.getLength()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testClient() {
        //  client();
        DatagramSocket ds = null;
        try {
            ObjectInputStream i = new ObjectInputStream(new FileInputStream("person.dat"));
            Person p = (Person) i.readObject();
            ds = new DatagramSocket();
            byte[] b = "哈哈哈".getBytes();
            DatagramPacket dp = new DatagramPacket(p.toString().getBytes(), 0, p.toString().getBytes().length, InetAddress.getByName("127.0.0.1"), 8890);
            ds.send(dp);
            ds.receive(dp);
            System.out.println(new String(dp.getData(), 0, dp.getLength()));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ds != null) {
                ds.close();
            }
        }
    }
}
