package app;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args){

        try {
            Straat straat = new Straat("huizen.txt");
            System.out.println(straat);
        } catch (FileNotFoundException e) {
            System.out.println("Bestand niet gevonden: "+e.getMessage());
        }
    }

}