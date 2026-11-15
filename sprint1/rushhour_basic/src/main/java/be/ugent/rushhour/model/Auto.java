package be.ugent.rushhour.model;
import java.util.ArrayList;

public class Auto {
    private String kleur;
    private boolean horizontaal;
    private int lengte;
    private int x, y;

    public String getKleur() {
        return kleur;
    }

    public void setKleur(String kleur) {
        this.kleur = kleur;
    }

    public boolean isHorizontaal() {
        return horizontaal;
    }

    public void setHorizontaal(boolean horizontaal) {
        this.horizontaal = horizontaal;
    }

    public int getLengte() {
        return lengte;
    }

    public void setLengte(int lengte) {
        this.lengte = lengte;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Auto(String kleur, boolean horizontaal, int lengte, int x, int y) {
        this.kleur = kleur;
        this.horizontaal = horizontaal;
        this.lengte = lengte;
        this.x = x;
        this.y = y;
    }
}
