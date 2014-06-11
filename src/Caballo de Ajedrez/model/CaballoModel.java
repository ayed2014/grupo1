package model;

import com.intellij.util.containers.Stack;

import java.util.ArrayList;
/**
 * Created by Nash on 04/06/14.
 */
public class CaballoModel {
    Board myBoard;
    Horse myHorse;
    Stack<Coordinate>[] myStacks;
    ArrayList<Position> visitedPositions;
    int currentStack;
    Coordinate[] actualCoordiantes;
    private  ArrayList<OnTurnChange> observers = new ArrayList<OnTurnChange>();


    public CaballoModel() {
        this.myBoard = new Board();
        this.myHorse = new Horse();
        this.myStacks = new Stack[4];
        for (int i = 0; i < myStacks.length; i++) {
            myStacks[i] = new Stack<Coordinate>();
        }
        visitedPositions = new ArrayList<Position>();
        currentStack = 0;
        actualCoordiantes = new Coordinate[4];
    }
    public void simulate(Coordinate coordinate) {
        myBoard.putHorse(coordinate);
        myHorse.setActualCoordinate(coordinate);
        updateActualCoordiantes();
        notifyTurnChange();
        visitedPositions.add(myBoard.getPositions()[coordinate.getiCoordiante()][coordinate.getjCoordinate()]);
        myBoard.getPositions()[coordinate.getiCoordiante()][coordinate.getjCoordinate()].setOccupied(true);
        myStacks[currentStack].add(coordinate);
        currentStack++;
        addPossibles(myStacks[currentStack], myHorse.getActualCoordinate());

    }
    private void addPossibles(Stack stack, Coordinate coordinate) {
        ArrayList<Coordinate> possibleMoves = possibleMoves(coordinate);
        for (Coordinate possibleMove : possibleMoves) {
            if (isDisponible(possibleMove)) {
                stack.push(possibleMove);
            }
        }
    }
    public boolean isDisponible(Coordinate coordinate) {
        return !myBoard.getPositions()[coordinate.getiCoordiante()][coordinate.getjCoordinate()].isOccupied();
    }
    private ArrayList<Coordinate> possibleMoves(Coordinate coordinate) {
        ArrayList<Coordinate> possiblesCoordiantes = new ArrayList<Coordinate>();
        Coordinate coordinateToCheck = new Coordinate(coordinate.getiCoordiante() + 2, coordinate.getjCoordinate() + 1);
        if (isAValidCoordinate(coordinateToCheck)) {
            possiblesCoordiantes.add(coordinateToCheck);
        }
        coordinateToCheck = new Coordinate(coordinate.getiCoordiante() + 1, coordinate.getjCoordinate() + 2);
        if (isAValidCoordinate(coordinateToCheck)) {
            possiblesCoordiantes.add(coordinateToCheck);
        }
        coordinateToCheck = new Coordinate(coordinate.getiCoordiante() - 2, coordinate.getjCoordinate() - 1);
        if (isAValidCoordinate(coordinateToCheck)) {
            possiblesCoordiantes.add(coordinateToCheck);
        }
        coordinateToCheck = new Coordinate(coordinate.getiCoordiante() - 1, coordinate.getjCoordinate() - 2);
        if (isAValidCoordinate(coordinateToCheck)) {
            possiblesCoordiantes.add(coordinateToCheck);
        }
        coordinateToCheck = new Coordinate(coordinate.getiCoordiante() + 1, coordinate.getjCoordinate() - 2);
        if (isAValidCoordinate(coordinateToCheck)) {
            possiblesCoordiantes.add(coordinateToCheck);
        }
        coordinateToCheck = new Coordinate(coordinate.getiCoordiante() + 2, coordinate.getjCoordinate() - 1);
        if (isAValidCoordinate(coordinateToCheck)) {
            possiblesCoordiantes.add(coordinateToCheck);
        }
        coordinateToCheck = new Coordinate(coordinate.getiCoordiante() - 1, coordinate.getjCoordinate() + 2);
        if (isAValidCoordinate(coordinateToCheck)) {
            possiblesCoordiantes.add(coordinateToCheck);
        }
        coordinateToCheck = new Coordinate(coordinate.getiCoordiante() - 2, coordinate.getjCoordinate() + 1);
        if (isAValidCoordinate(coordinateToCheck)) {
            possiblesCoordiantes.add(coordinateToCheck);
        }
        return possiblesCoordiantes;
    }
    private boolean isAValidCoordinate(Coordinate coordinate){
        return coordinate.getiCoordiante()>= 0 && coordinate.getiCoordiante()<=7 && coordinate.getjCoordinate()>= 0 && coordinate.getjCoordinate()<=7;
    }
    public void nextUno() {
        Coordinate coordinate = myStacks[currentStack].peek();
        myBoard.putHorse(coordinate);
        myHorse.setActualCoordinate(coordinate);
        updateActualCoordiantes();
        notifyTurnChange();
        myStacks[currentStack].pop();
        myBoard.getPositions()[coordinate.getiCoordiante()][coordinate.getjCoordinate()].setOccupied(true);
        currentStack++;
        if (currentStack<4) {
            addPossibles(myStacks[currentStack], myHorse.getActualCoordinate());
        }
    }
    public void nextDos() throws FinishException {
        Position[][] myBoardPositions = myBoard.getPositions();
        if (myStacks[currentStack].size() == 0) {
            currentStack--;
            if (myStacks[currentStack].size() == 0) {
                currentStack--;
                if (myStacks[currentStack].size() == 0) {
                    throw new FinishException();
                }
                limpiarPositions();
                nextUno();
            }
            limpiarPositions();
            nextUno();
        }
        Coordinate coordinate = getCurrentStack().peek();
        if (coordinate != null) {
            myBoard.putHorse(coordinate);
            myHorse.setActualCoordinate(coordinate);
            updateActualCoordiantes();
            notifyTurnChange();
            getCurrentStack().pop();
            myBoardPositions[coordinate.getiCoordiante()][coordinate.getjCoordinate()].setOccupied(true);
        }
        else {
            nextDos();
        }
    }
    public Stack<Coordinate> getCurrentStack() {
        return myStacks[currentStack];
    }
    public Coordinate[] getActualCoordiantes() {
        return actualCoordiantes;
    }
    public void updateActualCoordiantes(){
        actualCoordiantes[currentStack] = myHorse.getActualCoordinate();
        for (int i = currentStack+1; i < 4; i++) {
            actualCoordiantes[i] = null;
        }
    }
    public void limpiarPositions(){
        Position[][] positions = myBoard.getPositions();
        for (int i = 0; i < positions.length; i++) {
            for (int j = 0; j < positions.length; j++) {
                positions[i][j].setOccupied(false);
            }
        }
        for (int i = 0; i < actualCoordiantes.length; i++) {
            if (actualCoordiantes[i] != null){
                positions[actualCoordiantes[i].getiCoordiante()][actualCoordiantes[i].getjCoordinate()].setOccupied(true);
            }
        }
    }
    public void notifyTurnChange(){
        for (OnTurnChange a : observers){
            a.turnChange(myStacks,actualCoordiantes,currentStack);
        }
    }
    public void registerTurnChange(OnTurnChange changeObserver){
        observers.add(changeObserver);
    }
}