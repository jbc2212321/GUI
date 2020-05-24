package sample;

import NewThread.MyThread;
import Socket.Rec;
import Socket.UTIL;
import javafx.application.Platform;
import javafx.stage.Stage;
import customer.User;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.net.SocketException;


public class Controller {
    @FXML
    public ScrollPane public_scroll;
    @FXML
    public ScrollPane private_scroll;
    @FXML
    public TextField Message;
    @FXML
    public TextField private_text;
    @FXML
    public TextField public_text;
    @FXML
    public TextArea public_Area;
    @FXML
    public TextArea private_Area;
    @FXML
    public ChoiceBox<User> cb;
    public ChoiceBox<String> cb2;


    @FXML
    private Button private_button;
    @FXML
    private Button Send;
    private boolean public_s = true;
    private boolean private_s = false;


    @FXML
    public void initialize() throws SocketException {
        User user0 = new User(0, "jbc", "111111", "78", "138");
        User user1 = new User(1, "user1", "111111", "78", "138");
        User user2 = new User(2, "user2", "111111", "78", "138");
        cb.getItems().addAll(user0,user1, user2);
        cb.setConverter(new StringConverter<User>() {
            @Override
            public String toString(User object) {
                return object.getUsername();
            }

            @Override
            public User fromString(String string) {
                return null;
            }
        });
        cb.getSelectionModel().select(0);

    }

    @FXML
    public void init(int i) {
        User user0 = new User(0, "jbc", "111111", "78", "138");
        User user1 = new User(1, "jbc", "111111", "78", "138");
        User user2 = new User(2, "why", "111111", "78", "138");
        cb.getItems().addAll(user0,user1, user2);
        cb.setConverter(new StringConverter<User>() {
            @Override
            public String toString(User object) {
                return object.getUsername();
            }

            @Override
            public User fromString(String string) {
                return null;
            }
        });
        cb.getSelectionModel().select(i);
    }

    @FXML
    protected void ToPublic(ActionEvent event) {
        public_Area.setVisible(true);
        public_s = true;
        private_Area.setVisible(false);
        private_s = false;
    }

    @FXML
    protected void ToPrivate(ActionEvent event) {
        public_Area.setVisible(false);
        public_s = false;
        private_s = true;
        private_Area.setVisible(true);
    }

    @FXML
    protected void SendMessage(ActionEvent event) throws SocketException, InterruptedException {
        String s = Message.getText();
        String user = String.valueOf(cb.getValue().getUsername());
        int port = 2020;
        if (public_s) {
            public_Area.appendText("我对所有人说:\n" + s + '\n');
        } else {
//            MyThread myThread = new MyThread(cb.getValue().getId());
//            myThread.setPriority(1);
//            myThread.start();
//            UTIL.Send("jbc对" + user + "说:\n" + s + '\n',port+cb.getValue().getId());
            private_Area.appendText("我对" + user + "说:\n" + s + '\n');
        }
        Message.clear();
    }
    public void RecMessage(int port) throws SocketException {
        Rec rec = new Rec();
        String s =rec.RecMessage(port);
        System.out.println(s);
        private_Area.appendText("对我说:\n" + s + '\n');
    }

}
