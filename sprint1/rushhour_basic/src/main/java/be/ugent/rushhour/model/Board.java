package be.ugent.rushhour.model;

// Het spelbord: een rooster van vakjes. Via kolom en rij kom je
// rechtstreeks bij het juiste vakje, zonder alle auto's te overlopen.
public class Board {
    private int kolommen;
    private int rijen;
    private Cell[][] vakjes; // vakjes[kolom][rij]

    public Board(int kolommen, int rijen) {
        this.kolommen = kolommen;
        this.rijen = rijen;
        vakjes = new Cell[kolommen][rijen];
        for (int kolom = 0; kolom < kolommen; kolom++) {
            for (int rij = 0; rij < rijen; rij++) {
                vakjes[kolom][rij] = new Cell();
            }
        }
    }

    public int getKolommen() {
        return kolommen;
    }

    public int getRijen() {
        return rijen;
    }

    public boolean ligtOpBord(int kolom, int rij) {
        return kolom >= 0 && kolom < kolommen && rij >= 0 && rij < rijen;
    }

    // geeft de auto op dit vakje, of null als het vakje leeg is of buiten het bord ligt
    public Auto getAuto(int kolom, int rij) {
        if (!ligtOpBord(kolom, rij)) {
            return null;
        }
        return vakjes[kolom][rij].getAuto();
    }

    public boolean isVrij(int kolom, int rij) {
        return ligtOpBord(kolom, rij) && vakjes[kolom][rij].isLeeg();
    }

    // zet de auto op alle vakjes die hij bedekt
    public void plaats(Auto auto) {
        for (int i = 0; i < auto.getLengte(); i++) {
            vakjes[auto.getKolomVanDeel(i)][auto.getRijVanDeel(i)].setAuto(auto);
        }
    }

    // maakt alle vakjes leeg die de auto bedekt
    public void verwijder(Auto auto) {
        for (int i = 0; i < auto.getLengte(); i++) {
            vakjes[auto.getKolomVanDeel(i)][auto.getRijVanDeel(i)].setAuto(null);
        }
    }

    @Override
    public String toString() {
        String tekst = "";
        for (int rij = 0; rij < rijen; rij++) {
            for (int kolom = 0; kolom < kolommen; kolom++) {
                Auto auto = vakjes[kolom][rij].getAuto();
                if (auto == null) {
                    tekst += ".\t";
                } else {
                    tekst += auto.getKleur() + "\t";
                }
            }
            tekst += "\n";
        }
        return tekst;
    }
}
