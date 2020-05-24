package Socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UTIL {
    public static void Send(String message,int port) throws SocketException {
        DatagramSocket datagramSocket = new DatagramSocket();
        try {
            DatagramPacket datagramPacket = new DatagramPacket(message.getBytes(), message.getBytes().length, InetAddress.getByName("localhost"), port);
            datagramSocket.send(datagramPacket);
        } catch (IOException e) {
        } finally {
            datagramSocket.close();
        }
    }

    public static String Rec(int port) throws SocketException {
        DatagramSocket socket = new DatagramSocket(port);
        byte[] buf = new byte[1024];
        try {
            DatagramPacket packet =new DatagramPacket(buf,buf.length);
            socket.receive(packet);
            return new String(buf,0,packet.getLength());
        }catch (IOException e){
            return "接受异常!";
        }finally {
            socket.close();
        }

    }

    public static void main(String[] args) throws SocketException {
        String s = Rec(2020);
        Send("message",2020);
        System.out.println(s);
    }
}
