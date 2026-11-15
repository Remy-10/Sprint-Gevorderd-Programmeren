package be.ugent.rushhour.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class RushHourGame implements IRushHourGame {
    private ArrayList<Auto> autos;
    private int width, height;
    private Vakje[][] raster;

    public RushHourGame(String filename) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(filename));
        width = sc.nextInt();
        height = sc.nextInt();
        autos = new ArrayList<>();
        while (sc.hasNext()) {
            String kleur = sc.next();
            boolean horizontaal = sc.next().equals("HORIZONTAL");
            int lengte = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            autos.add(new Auto(kleur, horizontaal, lengte, x, y));
        }
        sc.close();

        raster = new Vakje[height][width];
        for (int r = 0; r < height; r++) {
            for (int k = 0; k < width; k++) {
                raster[r][k] = new Vakje();
            }
        }

        for (Auto a : autos) {
            for (int i = 0; i < a.getLengte(); i++) {
                int k = a.isHorizontaal() ? a.getX() + i : a.getX();
                int r = a.isHorizontaal() ? a.getY() : a.getY() + i;
                raster[r][k].setAuto(a);
            }
        }
    }

    @Override
    public int getRowCount() {
        return height;
    }

    @Override
    public int getColumnCount() {
        return width;
    }

    @Override
    public String getColorOfVehicleAt(DPoint location) {
        Auto a = raster[location.y][location.x].getAuto();
        return a == null ? "empty" : a.getKleur();
    }

    @Override
    public boolean[] getRoundedCornersAt(DPoint location) {
        return new boolean[4];
    }

    @Override
    public boolean moveVehicleAt(DPoint location, DPoint direction) {
        // TODO: auto verschuiven
        return false;
    }

    @Override
    public boolean isSolved() {
        // TODO
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < height; r++) {
            for (int k = 0; k < width; k++) {
                Auto a = raster[r][k].getAuto();
                sb.append(a == null ? '.' : a.getKleur().charAt(0));
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
