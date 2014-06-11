package view;

import model.Coordinate;

import javax.swing.*;

/**
 * Created by Nash on 26/05/14.
 */
public class BoardButton extends JButton {
    Coordinate coordinate;

    public BoardButton(int i, int j) {
        super();
        this.coordinate = new Coordinate(i,j);
    }
    public Coordinate getCoordinate() {
        return coordinate;
    }
}
