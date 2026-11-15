package be.ugent.rushhour.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RushHourGame implements IRushHourGame {
    private Board bord;
    private Auto rodeAuto;

    // De exceptie hoort bij het openen van een bestand met Scanner;
    // Main vangt ze al op (zie ook de constructor van DummyRushHourGame).
    public RushHourGame(String bestandsnaam) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(bestandsnaam));

        // eerste lijn: eerst de breedte (kolommen), dan de hoogte (rijen)
        int kolommen = sc.nextInt();
        int rijen = sc.nextInt();
        bord = new Board(kolommen, rijen);

        // hasNext() en niet hasNextLine(): zo geven lege regels op het einde geen probleem
        while (sc.hasNext()) {
            String kleur = sc.next();
            String richting = sc.next();
            int lengte = sc.nextInt();
            int kolom = sc.nextInt();
            int rij = sc.nextInt();

            Auto auto = new Auto(kleur, richting, lengte, kolom, rij);
            bord.plaats(auto);
            if (auto.isRood()) {
                rodeAuto = auto;
            }
        }
        sc.close();
    }

    @Override
    public int getRowCount() {
        return bord.getRijen();
    }

    @Override
    public int getColumnCount() {
        return bord.getKolommen();
    }

    @Override
    public String getColorOfVehicleAt(DPoint location) {
        Auto auto = bord.getAuto(location.x, location.y);
        if (auto == null) {
            return "empty";
        }
        return auto.getKleur();
    }

    // Volgorde zoals CellView.setRoundedCorners ze uitleest:
    // [linksboven, rechtsboven, linksonder, rechtsonder]
    @Override
    public boolean[] getRoundedCornersAt(DPoint location) {
        boolean[] hoeken = new boolean[4];
        Auto auto = bord.getAuto(location.x, location.y);
        if (auto == null) {
            return hoeken;
        }

        if (auto.isHorizontaal()) {
            boolean eerste = location.x == auto.getKolom();
            boolean laatste = location.x == auto.getKolom() + auto.getLengte() - 1;
            hoeken[0] = eerste;
            hoeken[2] = eerste;
            hoeken[1] = laatste;
            hoeken[3] = laatste;
        } else {
            boolean eerste = location.y == auto.getRij();
            boolean laatste = location.y == auto.getRij() + auto.getLengte() - 1;
            hoeken[0] = eerste;
            hoeken[1] = eerste;
            hoeken[2] = laatste;
            hoeken[3] = laatste;
        }
        return hoeken;
    }

    @Override
    public boolean moveVehicleAt(DPoint location, DPoint direction) {
        Auto auto = bord.getAuto(location.x, location.y);
        if (auto == null) {
            return false;
        }

        // een auto rijdt enkel in zijn eigen richting, en maar 1 vakje per keer
        int stap;
        if (auto.isHorizontaal()) {
            if (direction.y != 0) {
                return false;
            }
            stap = direction.x;
        } else {
            if (direction.x != 0) {
                return false;
            }
            stap = direction.y;
        }
        if (stap != 1 && stap != -1) {
            return false;
        }

        // het vakje waar de auto naartoe schuift: net voorbij het laatste deel
        // (stap +1) of net voor het eerste deel (stap -1)
        int deel;
        if (stap == 1) {
            deel = auto.getLengte();
        } else {
            deel = -1;
        }
        if (!bord.isVrij(auto.getKolomVanDeel(deel), auto.getRijVanDeel(deel))) {
            return false;
        }

        bord.verwijder(auto);
        auto.schuifOp(stap);
        bord.plaats(auto);
        return true;
    }

    // opgelost als de rode auto met zijn neus tegen de rechterrand staat
    @Override
    public boolean isSolved() {
        if (rodeAuto == null) {
            return false;
        }
        return rodeAuto.getKolom() + rodeAuto.getLengte() == bord.getKolommen();
    }

    @Override
    public String toString() {
        return bord.toString();
    }
}
