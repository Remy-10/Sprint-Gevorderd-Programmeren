package be.ugent.rushhour.model;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class DummyRushHourGame implements IRushHourGame {

    public DummyRushHourGame() throws FileNotFoundException{
        // exceptie wordt opgeworpen om in hoofdprogramma
        // vlot te kunnen switchen
        // tussen DummyRushHourGame en RushHourGame
    }

    @Override
    public int getRowCount() {
        return 4;
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public String getColorOfVehicleAt(DPoint location) {
        if (location.y == 0) {
            if (location.x == 2 || location.x == 3) {
                return "geel";
            }
        }
        if (location.x == 3) {
            if (location.y == 1 || location.y == 2) {
                return "indigo";
            }
        }
        if (location.y == 2) {
            if (location.x == 1 || location.x == 2) {
                return "rood";
            }
        }
        return "empty";
    }

    @Override
    public boolean[] getRoundedCornersAt(DPoint location) {
        return new boolean[4];
    }

    @Override
    public boolean moveVehicleAt(DPoint location, DPoint direction) {
        return false;
    }

    @Override
    public boolean isSolved() {
        return false;
    }

}
