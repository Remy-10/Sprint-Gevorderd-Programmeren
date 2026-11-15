package be.ugent.rushhour.model;

public class DPoint {
    public int x;
    public int y;

    public DPoint(int x, int y){
        this.x = x;
        this.y = y;
    }

    public DPoint sumWith(DPoint other){
        return new DPoint(x+other.x, y+other.y);
    }

    @Override
    public String toString(){
        return "("+x+","+y+")";
    }
}



































