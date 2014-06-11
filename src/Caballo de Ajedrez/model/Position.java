package model;

/**
 * Created by Nash on 04/06/14.
 */
public class Position {
    Coordinate coordinate;
    boolean occupied;
    public Position(int i, int j) {
        this.coordinate = new Coordinate(i,j);
    }
    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }
    public boolean isOccupied() {
        return occupied;
    }

}
