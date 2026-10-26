package be.ugent.rushhour.model;

import java.util.List;

public interface IRushHourGame {

    int getRowCount();

    int getColumnCount();

    String getColorOfVehicleAt(DPoint location);

    boolean[] getRoundedCornersAt(DPoint location);

    // will only move if direction is orthogonal (right, left, up, down) and over 1 step, in mathematical language:
    // will only move if direction.x * direction.y == 0 en abs(direction.x + direction.y) == 1
    boolean moveVehicleAt(DPoint location, DPoint direction);

    boolean isSolved();

}