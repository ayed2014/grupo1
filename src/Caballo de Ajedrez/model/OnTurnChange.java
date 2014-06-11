package model;

import com.intellij.util.containers.Stack;

/**
 * Created by Nash on 28/03/14.
 */
public interface OnTurnChange {
    public void turnChange(Stack<Coordinate>[] stacks, Coordinate[] coordinates, int currestStack);
}
