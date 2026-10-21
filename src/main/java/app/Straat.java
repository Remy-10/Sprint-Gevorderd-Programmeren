package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Straat {
    // plekjes[i] = het huis dat op locatie i ligt, of null als daar niets staat
    private Huis[] plekjes;
    private int lengteStraat;

    public Straat(String bestandsnaam) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(bestandsnaam));
        sc.nextLine();
        lengteStraat = sc.nextInt();
        sc.nextLine(); // overschot van 2e lijn in bestand, na inlezen van getal
        sc.nextLine(); // 3e lijn in bestand

        plekjes = new Huis[lengteStraat];

        while(sc.hasNext()){
            String lijn = sc.nextLine();
            Scanner scLijn = new Scanner(lijn);
            scLijn.useDelimiter(",");
            String naam = scLijn.next();
            int huisnr = scLijn.nextInt();
            int pos = scLijn.nextInt();
            int breedte = scLijn.nextInt();
            Huis huis = new Huis(naam,huisnr,pos,breedte);
            plaatsHuis(huis);
        }
    }

    // elk huis zet zichzelf één keer op al zijn plekjes: O(breedte) per huis
    private void plaatsHuis(Huis huis){
        int begin = huis.getPositie();
        int einde = huis.getPositie() + huis.getBreedte();
        for(int i=begin; i<einde; i++){
            // bij overlap wint het eerst ingelezen huis, net zoals vroeger
            if(plekjes[i] == null){
                plekjes[i] = huis;
            }
        }
    }

    public Huis huisOpLocatie(int i){
        return plekjes[i];
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        for(int i=0; i<lengteStraat; i++){
            builder.append("\n").append(i);
            Huis huis = plekjes[i];
            if(huis != null) {
                builder.append("  nr ").append(huis.getHuisnr())
                        .append(" ").append(huis.getNaam());
            }
        }
        return builder.toString();
    }

}
