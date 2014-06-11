package model;

/**
 * Created by Nash on 04/06/14.
 */
public class Board {
    Position[][] positions;

    public Board() {
        this.positions = new Position[8][8];
        for (int i = 0; i < positions.length; i++) {
            for (int j = 0; j < positions.length; j++) {
                positions[i][j] = new Position(i,j);
            }
        }
    }
    public void putHorse(Coordinate coordinate){
        positions[coordinate.getiCoordiante()][coordinate.getjCoordinate()].setOccupied(true);

    }
    public Position[][] getPositions() {
        return positions;
    }


}
