package NewThread;

import Socket.Rec;
import javafx.application.Platform;
import sample.Controller;
import sample.Main;

import java.net.SocketException;

public class MyThread extends Thread{
    private int id;
    private int port=2020+id;
    private int who;
    private String s;
    public MyThread(int id,int who) {
        this.id = id;
        this.who=who;
    }
    public MyThread(int id) {
        this.id = id;
    }

    public int getWho() {
        return who;
    }

    public void setWho(int who) {
        this.who = who;
    }

    @Override
    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public void run() {
        super.run();
        RevThread revThread =new RevThread(port);
        revThread.run();
        s=revThread.getS();
        System.out.println(s);
        Platform.runLater(()->{
            Main another = new Main();
            try {
                Controller controller =another.showWindow(this.id);
                controller.private_Area.appendText(s);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
    public String RecFromUser() throws SocketException {
        Rec rec =new Rec();
        return  rec.RecMessage(this.id);
    }
}
//
//        try {
//                this.s = rec();
//                System.out.println(1);
//                } catch (SocketException e) {
//                e.printStackTrace();
//                }