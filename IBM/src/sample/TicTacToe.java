package sample;
import java.util.Random;

public class TicTacToe {
    //every element of array should be assigned to 0
    int deck[] = new int[9];
    int available = 9;


    //This setter is used only for testing
    public void setDeck(int... vals){
        int i = 0;
        for (int val:vals) {
            this.deck[i] = val;
            i++;
        }
    }

    public void resetDeck(){
        for(int i = 0; i < 9; i++) this.deck[i] = 0;
        available = 9;
    }

    public int botMove(int val){
        if(available == 0) return -1;
        Random rand = new Random();
        int n = rand.nextInt(available);
        for(int i = 0; i <= 8; i++){
            if(deck[i] != 0 && i <= n) n++;
        }
        insert(n,val);
        return n;
    }

    //inserts value in position
    public int insert(int pos, int val){
        this.deck[pos] = val;
        available--;
        return finishVal();
    }

    //Controls if game is finished, return int value based on result:
    /*  -1  -> not finished yet
        0   -> it's draw
        1   -> player X wins
        2   -> player O wins
     */
    public int finishVal(){
        //Checking columns first
        int x = 1;
        for(int i = 0; i<3; i++){
            if((deck[i] == deck[i+3])&&(deck[i]== deck[i+6])&&(deck[i]!=0)) return deck[i];
        }
        //Checking rows after
        for(int i = 0; i<=6; i+=3){
            if((deck[i] == deck[i+1])&&(deck[i]==deck[i+2])&&(deck[i]!=0)) return deck[i];
        }
        //Checking if there are winning cross
        if((deck[0]== deck[4])&&(deck[0]==deck[8]&&(deck[0]!=0))) return deck[0];
        if((deck[2]== deck[4])&&(deck[2]==deck[6])&&(deck[2]!=0)) return deck[2];
        //Checking if game game is draw
        for(int i = 0; i<9; i++){
            if(deck[i] == 0) break;
            if(i == 8) return 0;
        }
        //if none of previous, then game continues
        return -1;
    }

}
