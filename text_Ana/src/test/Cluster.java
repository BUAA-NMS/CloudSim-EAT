package test;

import java.util.ArrayList;
public class Cluster {
    double error=0.0;//�����ڲ����
    int center;//��������point��id
    ArrayList<Point> ofCluster = new ArrayList<Point>();//�����������ĵ�ļ���
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

