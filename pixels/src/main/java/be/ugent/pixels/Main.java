package be.ugent.pixels;

import be.ugent.pixels.model.*;
import be.ugent.pixels.view.PixelView;

import java.io.FileNotFoundException;

public class Main {

    private static String pathToTextFiles = System.getProperty("user.dir") + "/src/main/resources/be/ugent/pixels/files/";
    //private static String FILE = "smallOne.txt";
    private static String FILE = "bigOne.txt";


    public static void main(String[] args) {
        showOnConsole();
        showOnGraphicalUserInterface();
    }

    public static void showOnConsole() {
        try {
            PixelGrid grid = new PixelGrid(pathToTextFiles+FILE);
            System.out.println(grid);
        } catch (FileNotFoundException e) {
            System.out.println("File not found! "+pathToTextFiles+FILE);
        }
    }

    public static void showOnGraphicalUserInterface() {
        try {
            PixelGrid grid = new PixelGrid(pathToTextFiles + FILE);
            PixelView view = new PixelView(grid);
            view.setVisible(true);
        } catch (FileNotFoundException e) {
            System.out.println("bestand niet gevonden" + e.getMessage());
        }
    }


}

























