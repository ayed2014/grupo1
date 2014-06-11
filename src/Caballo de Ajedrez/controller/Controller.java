package controller;

import model.CaballoModel;
import model.Coordinate;
import model.FinishException;
import view.BoardButton;
import view.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Nash on 04/06/14.
 */
public class Controller {
    Game myGameView;
    CaballoModel myCaballoModel;
    int move;

    public Controller() {
        myCaballoModel = new CaballoModel();
        myGameView = new Game();
        myGameView.setVisible(true);
        myGameView.getNext().addActionListener(new NextButtonListener());
        myGameView.getNext().setEnabled(false);
        addBoardButtonListeners();
        myCaballoModel.registerTurnChange(myGameView);
    }
    private void addBoardButtonListeners(){
        for (int i = 0; i < myGameView.getMyBoard().length; i++) {
            for (int j = 0; j < myGameView.getMyBoard().length; j++) {
                myGameView.getMyBoard()[i][j].addActionListener(new BoardButtonListener());
            }
        }
    }
    private void pintar(){
        for (int j = 0; j < myGameView.getMyBoard().length; j++) {       // Restablecer
            for (int k = 0; k < myGameView.getMyBoard().length; k++) {
                myGameView.getMyBoard()[j][k].setBackground((j+k)%2==0? Color.BLACK : Color.WHITE);
            }
        }
        for (int i = 0; i < 4; i++) {
            if (myCaballoModel.getActualCoordiantes()[i] != null) {
                myGameView.getMyBoard()[myCaballoModel.getActualCoordiantes()[i].getiCoordiante()][myCaballoModel.getActualCoordiantes()[i].getjCoordinate()].setBackground(Color.ORANGE);
            }
        }
    }
    class NextButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (move<2){
                myCaballoModel.nextUno();
                pintar();
                move++;
            } else {
                try {
                    myCaballoModel.nextDos();
                    pintar();
                } catch (FinishException e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(myGameView, "Again?","Si quiere puede probar de nuevo.\n Si no, presiona la cruz superior derecha del tablero para salir.",JOptionPane.OK_OPTION);

                }
            }
        }
    }
    class BoardButtonListener implements ActionListener {
       @Override
       public void actionPerformed(ActionEvent e) {
           BoardButton button = (BoardButton) e.getSource();
           myCaballoModel.simulate(button.getCoordinate());
           myGameView.getMyStacks()[1][0].setText(button.getCoordinate().toString());
           myGameView.getNext().setEnabled(true);
           pintar();
           for (int i = 0; i < myGameView.getMyBoard().length; i++) {
               for (int j = 0; j < myGameView.getMyBoard().length; j++) {
                   myGameView.getMyBoard()[i][j].setEnabled(false);
               }
           }
       }
    }
}
