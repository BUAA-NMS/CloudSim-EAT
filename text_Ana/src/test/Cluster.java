package test;

import java.util.ArrayList;
public class Cluster {
    double error=0.0;//聚类内部误差
    int center;//聚类中心point的id
    ArrayList<Point> ofCluster = new ArrayList<Point>();//属于这个聚类的点的集合
    public double getError() {
        return error;
    }
    public void setError(double error) {
        this.error = this.error+ error;
    }
    public int getCenter() {
        return center;
    }
    public void setCenter(int center) {
        this.center = center;
    }
    public ArrayList<Point> getOfCluster() {
        return ofCluster;
    }
    public void setOfCluster(ArrayList<Point> ofCluster) {
        this.ofCluster = ofCluster;
    }
    public void addPoints(Point point){
        if(!(this.ofCluster.contains(point)))
        this.ofCluster.add(point);
    }
}

