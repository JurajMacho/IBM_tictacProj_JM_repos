package sample;

import java.util.concurrent.TimeUnit;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.paint.Color;

public class TicTacToeController{
    @FXML
    private Button tab1_1;
    @FXML
    private Button tab1_2;
    @FXML
    private Button tab1_3;
    @FXML
    private Button tab2_1;
    @FXML
    private Button tab2_2;
    @FXML
    private Button tab2_3;
    @FXML
    private Button tab3_1;
    @FXML
    private Button tab3_2;
    @FXML
    private Button tab3_3;
    @FXML
    private Label info_lab;

    int player = 1;
    boolean bot;

    private void changePlayer(){
        if (player == 1) player = 2;
        else player = 1;
    }

    private void reset(){
        //unblock tabs
        Main.tictac.resetDeck();
        info_lab.setText("");
        player = 1;
        clean();
        able();

    }

    public void PvPButControl(ActionEvent event){
        reset();
        bot = false;
    }

    public void PvBButControl(ActionEvent event){
        bot = true;
        reset();
    }

    public void tabControl(ActionEvent event){
        Button button = (Button) event.getSource();
        button.setDisable(true);
        if(player == 1) {
            button.setText("X");
            button.setTextFill(Color.web("red"));
        }
        else{
            button.setText("O");
            button.setTextFill(Color.web("blue"));
        }
        //getting position of tab
        int pos = -1;
        if(button.getId().equals("tab1_1")) pos = 0;
        if(button.getId().equals("tab1_2")) pos = 1;
        if(button.getId().equals("tab1_3")) pos = 2;
        if(button.getId().equals("tab2_1")) pos = 3;
        if(button.getId().equals("tab2_2")) pos = 4;
        if(button.getId().equals("tab2_3")) pos = 5;
        if(button.getId().equals("tab3_1")) pos = 6;
        if(button.getId().equals("tab3_2")) pos = 7;
        if(button.getId().equals("tab3_3")) pos = 8;

        int x = Main.tictac.insert(pos,player);
        step_finalizer(x);
        if(x == -1 && bot){
            try{
                TimeUnit.SECONDS.sleep(2);
            }
            catch(Exception e){};
            int y = Main.tictac.botMove(player);
            choose(y,player);
            step_finalizer(Main.tictac.finishVal());
        }
    }

    //checks answer from model and take action based on it
    private void step_finalizer(int x) {
        if (x > -1) {
            disable();
            if(x==0){
                info_lab.setText("Game ended in draw !");
                info_lab.setTextFill(Color.web("yellow"));
            }
            if(x==1){
                info_lab.setText("Player X won !");
                info_lab.setTextFill(Color.web("red"));
            }
            if(x==2){
                info_lab.setText("Player Y won !");
                info_lab.setTextFill(Color.web("blue"));
            }
        }
        else changePlayer();
    }
    private void disable(){
        tab1_1.setDisable(true);
        tab1_2.setDisable(true);
        tab1_3.setDisable(true);
        tab2_1.setDisable(true);
        tab2_2.setDisable(true);
        tab2_3.setDisable(true);
        tab3_1.setDisable(true);
        tab3_2.setDisable(true);
        tab3_3.setDisable(true);
    }
    private void able(){
        tab1_1.setDisable(false);
        tab1_2.setDisable(false);
        tab1_3.setDisable(false);
        tab2_1.setDisable(false);
        tab2_2.setDisable(false);
        tab2_3.setDisable(false);
        tab3_1.setDisable(false);
        tab3_2.setDisable(false);
        tab3_3.setDisable(false);
    }
    private void clean(){
        tab1_1.setText("");
        tab1_2.setText("");
        tab1_3.setText("");
        tab2_1.setText("");
        tab2_2.setText("");
        tab2_3.setText("");
        tab3_1.setText("");
        tab3_2.setText("");
        tab3_3.setText("");
    }
    private void choose(int pos, int val){
        Button but = new Button();
        if(pos == 0)but = tab1_1;
        if(pos == 1)but = tab1_2;
        if(pos == 2)but = tab1_3;
        if(pos == 3)but = tab2_1;
        if(pos == 4)but = tab2_2;
        if(pos == 5)but = tab2_3;
        if(pos == 6)but = tab3_1;
        if(pos == 7)but = tab3_2;
        if(pos == 8)but = tab3_3;

        if(val == 1){
            but.setText("X");
            but.setTextFill(Color.web("red"));
        }
        else{
            but.setText("O");
            but.setTextFill(Color.web("blue"));
        }
        but.setDisable(true);
    }
}
