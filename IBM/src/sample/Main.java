package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static TicTacToe tictac = new TicTacToe();

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("TicTacToeWin.fxml"));
        Parent root = loader.load();
        //Sets some attributes of window (title,resising,style,...)
        primaryStage.setTitle("TicTacToe Game !");
        primaryStage.setResizable(false);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        TicTacToeController cntrl = loader.getController();
        //call controller to set default values to combobox
        //shows main window
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
