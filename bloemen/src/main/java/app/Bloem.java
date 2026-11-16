package app;

public class Bloem extends Plant {
    private String kleur;


    public Bloem(String naam, int hoogte, String kleur) {
        super(naam,hoogte);
        this.kleur = kleur.toUpperCase();
    }



    @Override
    public String toString() {
        return super.toString() + " " + kleur;
    }
}