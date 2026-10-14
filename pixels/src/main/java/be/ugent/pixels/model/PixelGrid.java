package be.ugent.pixels.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PixelGrid { // Ik heb alles private gezet maar niet zeker als het moet
    private int width;
    private int height;


    public PixelGrid(String filename) throws FileNotFoundException { // Eerste lijn van txt → width, height; Tweede lijn → beginPos
        Scanner scanner = new Scanner(new File(filename)); // TODO: error file niet gevonden
        width = scanner.nextInt();
        height = scanner.nextInt();
        char[][] grid = new char[height][width];
        DPoint pos = new DPoint(0, 0);
        pos.x = scanner.nextInt();
        pos.y = scanner.nextInt();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                grid[y][x] = getCellContent(x, y); // Voor een of andere reden komt de rij y eerst bij grid in Java
            }
        }

        while (scanner.hasNext()) { // Resterende lijnen → richting, character
            String richting = scanner.next();
            DPoint delta = DPoint.translationTo(richting);
            char character = scanner.next().charAt(0);

            grid[pos.x][pos.y] = character;
            pos = pos.sumWith(delta);   // In pdf gebruiken ze nieuwe variable r? Ik herschrijf de oude pos variabele
        }
        scanner.close();

    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public char getCellContent(int x, int y) {   // Even is "X", oneven is "."
        if ((x + y) % 2 == 0) {
            return 'X';
        } else {
            return '.';
        }
    }

    public String toString() {  // TODO: Methode dynamisch maken
        return "X.X.X.X.\n.X.X.X.X\nX.X.X.X.\n.X.X.X.X\nX.X.X.X.\n.X.X.X.X\nX.X.X.X.\n.X.X.X.X\n";
    }

}
