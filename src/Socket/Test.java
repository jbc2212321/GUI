package Socket;

import java.net.SocketException;

public class Test {
    public static void main(String[] args) throws SocketException {
        Send send = new Send();
        Rec rec =new Rec();
        String s = rec.RecMessage(2020);
        send.SendMessage("111",2020);
        System.out.println(s);
    }
}
