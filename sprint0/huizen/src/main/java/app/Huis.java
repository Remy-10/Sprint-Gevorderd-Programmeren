package app;

public class Huis {
    private String naam;
    private int huisnr;
    private int positie;
    private int breedte;

    public Huis(String naam, int huisnr, int positie, int breedte) {
        this.naam = naam;
        this.huisnr = huisnr;
        this.positie = positie;
        this.breedte = breedte;
    }

    public String getNaam() {
        return naam;
    }

    public int getHuisnr() {
        return huisnr;
    }

    public int getPositie() {
        return positie;
    }

    public int getBreedte() {
        return breedte;
    }
}
