package be.ugent.pixels.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PixelGrid { // Ik heb alles private gezet maar niet zeker als het moet
    private int width;
    private int height;
    private char[][] grid; //dit moest een attribuut zijn zodat alle methodes eraan konden. Niet alleen in de constructor


    public PixelGrid(String filename) throws FileNotFoundException { // Eerste lijn van txt → width, height; Tweede lijn → beginPos
        Scanner scanner = new Scanner(new File(filename));
        width = scanner.nextInt();
        height = scanner.nextInt();
        this.grid = new char[width][height];
        DPoint pos = new DPoint(0, 0);
        pos.x = scanner.nextInt();
        pos.y = scanner.nextInt();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                grid[x][y] = ' '; // Voor een of andere reden komt de rij y eerst bij grid in Java
            }
        }

        while (scanner.hasNext()) { // Resterende lijnen → richting, character
            String richting = scanner.next();
            DPoint delta = DPoint.translationTo(richting);

            char character = scanner.next().charAt(0);
            pos = pos.sumWith(delta);   // In pdf gebruiken ze nieuwe variable r? Ik herschrijf de oude pos variabele
            this.grid[pos.x][pos.y] = character; //eerst moet pos worden aangepast anders krijg je een verkeerde output

        }
        scanner.close();

    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public char getCellContent(int x, int y) {
        return grid[x][y];
    }

    public String toString() {  //Deze methode leest gewoon elk coordinaat en zet het in een string
        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < height; y++){
            for (int x = 0; x < width; x++){
                sb.append(grid[x][y]);
            }
            sb.append('\n');
        }
        return sb.toString();
    }

}
