package be.ugent.pixels.model;

public class DPoint {
    public int x;
    public int y;

    public DPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static DPoint translationTo(String direction) {
        if (direction.equals("right")) {
            return new DPoint(1, 0);
        }
        if (direction.equals("left")) {
            return new DPoint(-1, 0);
        }
        if (direction.equals("up")) {
            return new DPoint(0, -1);
        }
        if (direction.equals("down")) {
            return new DPoint(0, 1);
        }
        return null;
    }

    public DPoint sumWith(DPoint delta) {
        int nieuwe_x = this.x + delta.x;
        int nieuwe_y = this.y + delta.y;
        return new DPoint(nieuwe_x, nieuwe_y);
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
