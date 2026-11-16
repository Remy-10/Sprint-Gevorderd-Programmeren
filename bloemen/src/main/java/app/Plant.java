package app;

public /*abstract*/ class Plant  {

    private String naam;
    private int hoogte;

    //schrijf hier de constructor; naam en hoogte worden meegegeven

    public Plant(String naam, int hoogte) {
        this.naam = naam;
        this.hoogte = hoogte;
    }


    //schrijf hier de getter voor de hoogte

    public int getHoogte() {
        return hoogte;
    }

    public String getNaam() {
        return naam;
    }
    //schrijf hieronder de overige methodes

    public String getKleur() {
        return "onbekend";
    }

    @Override
    public String toString() {
        return naam + " (" +  hoogte + " cm)" ;
    }

}

