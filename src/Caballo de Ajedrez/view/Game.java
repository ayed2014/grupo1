package view;

import com.intellij.util.containers.Stack;
import model.Coordinate;
import model.OnTurnChange;

import javax.swing.*;
import java.awt.*;


/**
 * Created by Nash on 04/06/14.
 */
public class Game extends JFrame implements OnTurnChange {
    BoardButton[][] myBoard;;
    JLabel[][] myStacks;
    JButton next;
    JLabel actualMovement;


    public Game() {
        super("Game");
        myBoard = new BoardButton[8][8];
        myStacks = new JLabel[9][4];
        next = new JButton("Next");
        actualMovement = new JLabel();


        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Container contentPane = getContentPane();
        JPanel centerPanel = new JPanel();
        JPanel southPanel = new JPanel();
        JPanel westPanel = new JPanel();
        BorderLayout layout = new BorderLayout();

        contentPane.setLayout(layout);

        westPanel.setLayout(new GridLayout(9,4,5,5));
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == 0){
                    myStacks[i][j] = new JLabel( (j+1) + "move");
                }
                else {
                    myStacks[i][j] = new JLabel("    ");
                }
                westPanel.add(myStacks[i][j]);
            }
        }
        contentPane.add(westPanel,BorderLayout.WEST);

        centerPanel.setLayout(new GridLayout(8,8));
        for (int i = 0; i < myBoard.length; i++) {
            for (int j = 0; j < myBoard.length; j++) {
                myBoard[i][j] = new BoardButton(i,j);
                if ((i+j)%2 == 0){
                    myBoard[i][j].setBackground(Color.BLACK);
                }
                else {
                    myBoard[i][j].setBackground(Color.WHITE);
                }
                centerPanel.add(myBoard[i][j]);
            }
        }
        contentPane.add(centerPanel,BorderLayout.CENTER);

        southPanel.setLayout(new GridLayout(0,2));
        southPanel.add(actualMovement);
        southPanel.add(next);
        contentPane.add(southPanel,BorderLayout.SOUTH);



        pack();


    }
    @Override
    public void turnChange(Stack<Coordinate>[] stacks, Coordinate[] actualCoordinates, int currentStack) {
        for (int i = 1; i < 9; i++) {
            for (int j = currentStack; j < 4; j++) {
                    myStacks[i][j].setText("");
            }
        }
        for (int j = currentStack; j < stacks.length; j++) {
            int i= 1;
            for (Coordinate coordinate : stacks[j] ) {
                if (coordinate.equals(actualCoordinates[0])||coordinate.equals(actualCoordinates[1])||coordinate.equals(actualCoordinates[2])||coordinate.equals(actualCoordinates[3])){
                    myStacks[i][j].setText(coordinate.toString());
                    myStacks[i][j].setForeground(Color.RED);
                }
                else {
                    myStacks[i][j].setText(coordinate.toString());
                    myStacks[i][j].setForeground(Color.BLACK);
                }

                i+=1;
            }
        }
        String actualCoordintaes = "Actual movement: " + actualCoordinates[0].toString();
        for (int i = 1; i < 4; i++) {
            if (actualCoordinates[i] == null){
                i = 5;
            }
            else {
                actualCoordintaes+= "-" + actualCoordinates[i].toString();
            }
        }
        actualMovement.setText(actualCoordintaes);
    }
    public BoardButton[][] getMyBoard() {
        return myBoard;
    }
    public JButton getNext() {
        return next;
    }
    public JLabel[][] getMyStacks() {
        return myStacks;
    }
}
