package be.ugent.rushhour;

import be.ugent.rushhour.model.*;
import be.ugent.rushhour.view.RushHourView;

import java.io.FileNotFoundException;

public class Main {

    private static String pathToTextFiles = System.getProperty("user.dir") + "/src/main/resources/be/ugent/rushhour/games/";
    private static String GAMEFILE = "carsA.txt";
    //private static String GAMEFILE = "carsMossyHollow_level05.txt";

    public static void main(String[] args) {

        try {

            IRushHourGame game = new DummyRushHourGame();

            smallTests();
            showGameOnConsole(game);
            gui(game);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

    // EIGEN KLEINE TESTJES, aan te vullen naar believen
    public static void smallTests() {
        DPoint a = new DPoint(2, 3);
        System.out.println(a);
    }

    // SPEL OP CONSOLE UITSCHRIJVEN
    public static void showGameOnConsole(IRushHourGame game) {
        System.out.println(game.toString());
    }

    // GUI
    public static void gui(IRushHourGame game) {
        RushHourView view = new RushHourView(game);
        view.setVisible(true);
    }

}
