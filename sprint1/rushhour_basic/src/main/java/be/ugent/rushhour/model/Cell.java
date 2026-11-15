package be.ugent.rushhour.model;

// Eén vakje van het spelbord. Het vakje onthoudt welke auto erop staat
// (null als het vakje leeg is).
public class Cell {
    private Auto auto;

    public Cell() {
        auto = null;
    }

    public Auto getAuto() {
        return auto;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }

    public boolean isLeeg() {
        return auto == null;
    }
}
