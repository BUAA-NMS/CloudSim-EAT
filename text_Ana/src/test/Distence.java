package test;

public class Distence {
    int dest;
    int source;
    double dist;
    public int getDest() {
        return dest;
    }
    public void setDest(int dest) {
        this.dest = dest;
    }
    public int getSource() {
        return source;
    }
    public void setSource(int source) {
        this.source = source;
    }
    public double getDist() {
        return dist;
    }
    public void setDist(double dist) {
        this.dist = dist;
    }
    public Distence(int dest, int source, double dist) {
        super();
        this.dest = dest;
        this.source = source;
        this.dist = dist;
    }
    public Distence() {
    }
    @Override
    public boolean equals(Object obj) {
        if(obj!=null){
            Distence d = (Distence)obj;
        if(this.dest==d.dest&&this.source==d.source&&this.dist==d.dist){
            return true;
        }
        else{
            return false;
        }
        }
        return false;
    }    
}

