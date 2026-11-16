package app;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.function.Function;
import java.util.Random.*;


public class Catalogus {
    private List<Plant> planten;
    private Map<String,Set<Plant>> overzicht;



    // schrijf hier de constructor

    public Catalogus(List<Plant> planten, Map<String, Set<Plant>> overzicht, String bestand) throws FileNotFoundException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Scanner sc = new Scanner(new File(bestand));

        while(sc.hasNextLine()) {
            String[] delen =  sc.nextLine().split(";");
            Plant p = (Plant) Class.forName("app." + delen[0]).getConstructor(String.class, int.class, String.class).newInstance(delen[1], Integer.parseInt(delen[2]), delen[3]);
        }
        this.planten = planten;
        this.overzicht = overzicht;
    }

    public Plant getRandomPlantVanMinimaleHoogte(int hoogte) {
        Random rand = new Random();
        return null; // vervang
    }

    public int aantalStruikenMetBladsoort(String bladsoort) {

        return 0; // vervang
    }

    public Set<Plant> plantenGeordend() {

        return null; // vervang
    }

    public String plantenInKleur(String kleur, int minhoogte, int maxhoogte) {

        return ""; // vervang
    }


}
