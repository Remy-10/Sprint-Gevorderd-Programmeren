package be.ugent.pixels.model;

import java.io.FileNotFoundException;

public class PixelGrid{


    public PixelGrid(String filename) throws FileNotFoundException {

    }

    public int getWidth(){
        return 8;
    }
    public int getHeight(){
        return 8;
    }
    public char getCellContent(int x, int y){
        if((x+y)%2 == 0){
            return 'X';
        }
        else{
            return '.';
        }
    }

    public String toString(){
        return "X.X.X.X.\n.X.X.X.X\nX.X.X.X.\n.X.X.X.X\nX.X.X.X.\n.X.X.X.X\nX.X.X.X.\n.X.X.X.X\n";
    }

}
