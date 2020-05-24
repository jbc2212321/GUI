package Socket;
import java.io.IOException;
import java.net.*;
public class Rec {
    public String RecMessage(int port) throws SocketException {
        try (DatagramSocket socket = new DatagramSocket(port)) {
            String s = null;
            byte[] buf = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            socket.receive(packet);
            s = new String(buf, 0, packet.getLength());
            socket.close();
            return s;
        } catch (IOException e) {
            return "接收异常!";
        }

    }
    public static void main(String[] args) throws IOException {
        new Thread(){
            public void run(){
                System.out.println(4);
                try (DatagramSocket socket = new DatagramSocket(2020)) {
                    byte[] buf = new byte[1024];
                    DatagramPacket packet = new DatagramPacket(buf, buf.length);
                    socket.receive(packet);
                    System.out.println(new String(buf, 0, packet.getLength()));
                } catch (IOException ignored) { }
            }
        }.start();
        System.out.println(5);

    }
}
