package sample;

import Socket.UTIL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        URL location = getClass().getResource("sample.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(location);
        fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());
        Parent root = fxmlLoader.load();
        primaryStage.setTitle("Chat Display ClientA");
        Scene scene = new Scene(root, 500, 600);
        //加载css样式
        //scene.getStylesheets().add(getClass().getResource("style1.css").toExternalForm());
        primaryStage.setScene(scene);
        Controller controller = fxmlLoader.getController();   //获取Controller的实例对象
        //Controller中写的初始化方法
//        controller.init();

        primaryStage.show();
//        UTIL.Rec(2020);
//        UTIL.Rec(2021);
//        UTIL.Rec(2022);


//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
//        primaryStage.setTitle("Chat Display ClientA");
//        primaryStage.setScene(new Scene(root, 500, 600));
//        primaryStage.show();
    }

    Stage stage=new Stage();
    public static void main(String[] args) {

        launch(args);
    }
    public Controller  showWindow(int i) throws Exception {
        return start(stage,i);
    }

    public Controller start(Stage primaryStage,int i) throws IOException {
        URL location = getClass().getResource("sample.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(location);
        fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());
        Parent root = fxmlLoader.load();
        primaryStage.setTitle("Chat Display ClientA");
        Scene scene = new Scene(root, 500, 600);
        //加载css样式
        //scene.getStylesheets().add(getClass().getResource("style1.css").toExternalForm());
        primaryStage.setScene(scene);
        Controller controller = fxmlLoader.getController();   //获取Controller的实例对象
        //Controller中写的初始化方法
        controller.init(i);

        primaryStage.show();
        return controller;
    }
}
