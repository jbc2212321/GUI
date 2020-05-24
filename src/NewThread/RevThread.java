package NewThread;

import Socket.Rec;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.net.SocketException;

public class RevThread extends Thread {
    private int port;
    private String s;

    public RevThread(int port) {
        this.port = port;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public void run(){
        Rec rec =new Rec();
        try {
            s=rec.RecMessage(port);
            System.out.println(getProcessID());
        } catch (SocketException e) {
            e.printStackTrace();
        }

    }
    public static final int getProcessID() {
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        System.out.println(((RuntimeMXBean) runtimeMXBean).getName());
        return Integer.parseInt(runtimeMXBean.getName().split("@")[0]);
    }

}
