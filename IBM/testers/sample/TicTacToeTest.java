package sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

//Used for testing TicTacToe class

@RunWith(Parameterized.class)
public class TicTacToeTest {
    private int expected;
    private int values[];
    private TicTacToe tictac = new TicTacToe();

    public TicTacToeTest(int res, int vals[]) {
        this.expected = res;
        this.values = vals;
    }

    @Parameterized.Parameters
    public static Collection input() {
        return Arrays.asList(new Object[][]{
                {1, new int[]{1, 0, 0, 1, 0, 0, 1, 0, 0}},   //Player X wins in 1st lane vertically
                {2, new int[]{2, 0, 0, 2, 0, 0, 2, 0, 0}},    //Player Y wins in 1st lane vertically
                //now we know that program makes differ Player X and Player Y and can determinate win
                //also now we know that program can determinate when win is on column
                {1, new int[]{1, 1, 1, 2, 0, 0, 2, 0, 0}},   //Player X wins in 1st lane horizontally
                {-1, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0}},  //Game is not over yet - can determinate if game continues
                {-1, new int[]{1, 2, 1, 2, 1, 1, 0, 0, 0}},  //can determinate that game continues in the middle of the game
                {-1, new int[]{2, 0, 1, 1, 1, 0, 2, 0, 0}},   //There are 3x1 in a row but its neither same lane vertically nor
                                                             ///horizontally, therefore game continues
                {1, new int[]{1, 2, 2, 0, 1, 0, 0, 0, 1}},  //Player X win by crossing from top left to down right
                {1, new int[]{2 ,2 ,1 ,0 ,1 ,0, 1, 0, 0}},  //Player X win by crossing from top right to down left
                                                            //now we know program can find crossing winning positions
                {0, new int[]{2, 1, 2, 2, 1, 1, 1, 2, 1}}  //It's a draw - program can determinate when game ends with no winner

                //If every of these tests passes, then this method works
        });
    }

    @Test   //tests if finishVal method works
    public void finishVal() {
        tictac.setDeck(values);
        assertEquals(expected, tictac.finishVal());
    }



}
