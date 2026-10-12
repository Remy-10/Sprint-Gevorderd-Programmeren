package be.ugent.pixels.model;

public class DPoint {
    public int x;
    public int y;

    public DPoint(int x, int y){
        this.x = x;
        this.y = y;
    }

    public static DPoint translationTo(String direction){
        if(direction.equals("right")){
            return new DPoint(1,0);
        }
        if(direction.equals("left")){
            return new DPoint(-1,0);
        }
        if(direction.equals("up")){
            return new DPoint(0,-1);
        }
        if(direction.equals("down")){
            return new DPoint(0,1);
        }
        return null;
    }

    @Override
    public String toString(){
        return "("+x+","+y+")";
    }
}
