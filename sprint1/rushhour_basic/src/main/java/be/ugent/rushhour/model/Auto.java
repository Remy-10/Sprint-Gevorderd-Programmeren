package be.ugent.rushhour.model;

public class Auto {
    private String kleur;
    private boolean horizontaal;
    private int lengte;
    // kolom en rij van het meest linkse (horizontaal) of bovenste (verticaal) vakje
    private int kolom;
    private int rij;

    public Auto(String kleur, String richting, int lengte, int kolom, int rij) {
        this.kleur = kleur;
        this.horizontaal = richting.equals("HORIZONTAL");
        this.lengte = lengte;
        this.kolom = kolom;
        this.rij = rij;
    }

    public String getKleur() {
        return kleur;
    }

    public boolean isHorizontaal() {
        return horizontaal;
    }

    public int getLengte() {
        return lengte;
    }

    public int getKolom() {
        return kolom;
    }

    public int getRij() {
        return rij;
    }

    public boolean isRood() {
        return kleur.equals("red") || kleur.equals("rood");
    }

    // kolom van het i-de vakje van de auto (i = 0 is het eerste vakje)
    public int getKolomVanDeel(int i) {
        if (horizontaal) {
            return kolom + i;
        }
        return kolom;
    }

    // rij van het i-de vakje van de auto (i = 0 is het eerste vakje)
    public int getRijVanDeel(int i) {
        if (horizontaal) {
            return rij;
        }
        return rij + i;
    }

    // schuift de auto 1 vakje op; stap is +1 (rechts/onder) of -1 (links/boven)
    public void schuifOp(int stap) {
        if (horizontaal) {
            kolom += stap;
        } else {
            rij += stap;
        }
    }
}
