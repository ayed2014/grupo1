package model;

/**
 * Created by Nash on 04/06/14.
 */
public class Coordinate {
    private final int iCoordiante;
    private final int jCoordinate;

    public Coordinate(int iCoordiante, int jCoordinate) {
        this.iCoordiante = iCoordiante;
        this.jCoordinate = jCoordinate;
    }
    public int getiCoordiante() {
        return iCoordiante;
    }
    public int getjCoordinate() {
        return jCoordinate;
    }
    @Override
    public String toString() {
        String[] words = {"A","B","C","D","E","F","G","H"};
        int[] numbers = {1,2,3,4,5,6,7,8};
        return iCoordiante>=0? words[iCoordiante] + numbers[jCoordinate] : "";
    }
}
