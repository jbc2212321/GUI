package Socket;

import java.io.IOException;
import java.net.*;

public class Send {
    public void SendMessage(String message,int port) throws SocketException {
        try (DatagramSocket datagramSocket = new DatagramSocket()) {
            DatagramPacket datagramPacket = new DatagramPacket(message.getBytes(), message.getBytes().length, InetAddress.getByName("localhost"), port);
            datagramSocket.send(datagramPacket);
        } catch (IOException ignored) {
        }
    }


    public static void main(String[] args) throws IOException {
        try (DatagramSocket datagramSocket = new DatagramSocket()) {
            String s = "What everything that make me whole";
            DatagramPacket datagramPacket = new DatagramPacket(s.getBytes(), s.getBytes().length, InetAddress.getByName("localhost"), 2020);
            datagramSocket.send(datagramPacket);
        } catch (IOException ignored) {
        }


    }
}
