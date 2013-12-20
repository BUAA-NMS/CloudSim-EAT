package test;

import java.io.*;
import java.util.*;
public class Kmeans {

    int K; //����������۳ɼ����ࡣ
    int Generation=100;//��������������������֮һ��
    double E=7.1;//���������������������֮һ��
    static ArrayList<Point> allPoints = new ArrayList<Point>();//�����������е�
    int totalNumber = 0;//����ĵ�ĸ���

    //��ʼ������
    //data.txt
    //2
    //1 1
    //2 2
    //4 4
    //5 5
    //8 8
    public void prepare() throws IOException {
        File file = new File("D:\\test\\data.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String data = "0";
        int x = 0;
        int y = 0;
        String[] temp = null;
        Point p = null;
        K = Integer.parseInt(br.readLine());
        while ((data = br.readLine()) != null) {
            temp = data.split(" ");
            x = Integer.parseInt(temp[0]);
            y = 0;
            p = new Point(totalNumber++, x, y);
            allPoints.add(p);
        }
    }

    // ��һ�����ѡȡ��������
    public Set<Integer> firstChoose() {
        Set<Integer> center = new HashSet<Integer>();//�������ĵĵ��id,����set��֤�������ظ�id
        Random ran = new Random();
        int roll = ran.nextInt(totalNumber);
        while (center.size() < K) {
            roll = ran.nextInt(totalNumber);
            center.add(roll);
        }
        return center;
    }
    
    //���ݾ������ĳ�ʼ��������Ϣ
    public ArrayList<Cluster> beforCP(Set<Integer> center) {
        ArrayList<Cluster> cluster = new ArrayList<Cluster>();//��ż��������Ϣ
        Iterator<Integer> it = center.iterator();
        while (it.hasNext()) {
            Cluster c = new Cluster();//����һ������
            c.setCenter(it.next());
            cluster.add(c);
        }
        return cluster;
    }

    //��һ�ξ���
    public ArrayList<Cluster> clusterProcess(ArrayList<Cluster> cluster,
            Set<Integer> center) {
        ArrayList<Distence> distence = new ArrayList<Distence>();//��ž�����Ϣ
        Point source = null;
        Point dest = null;
        int id = 0;
        int id2 = 0;
        Object[] p = center.toArray();
        boolean flag = false;
        for (int i = 0; i < totalNumber; i++) {
            distence.clear();
            for (int j = 0; j < center.size(); j++) {
                if (!(center.contains(i))) {
                    flag = true;
                    // �������
                    source = allPoints.get(i);
                    dest = allPoints.get((Integer) p[j]);
                    distence.add(new Distence((Integer) p[j], i, (Double) Math
                            .sqrt(StrictMath
                                    .pow(source.getX() - dest.getX(), 2)
                                    + StrictMath.pow(source.getY()
                                            - dest.getY(), 2))));
                } else {
                    flag = false;
                }
            }
            if (flag == true) {
                // ����Ƚ�һ���㵽�������ĵľ���Ĵ�С
                double min = distence.get(0).getDist();
                for (int k = 1; k < distence.size(); k++) {
                    if (min > distence.get(k).getDist()) {
                        min = distence.get(k).getDist();
                        id = distence.get(k).getDest();
                        id2 = distence.get(k).getSource();
                    } else {
                        id = distence.get(0).getDest();
                        id2 = distence.get(0).getSource();
                    }
                }
                for (int n = 0; n < cluster.size(); n++) {
                    if (cluster.get(n).getCenter() == id) {
                        cluster.get(n).setError(min);
                        cluster.get(n).addPoints(allPoints.get(id2));
                    }
                }
            }
        }
        return cluster;
    }

    // ���¾�������
    public ArrayList<Cluster> stack(ArrayList<Cluster> cluster) {
        double te = 0;
        for (int m = 0; m < Generation; m++) {
            te = 0;
            Set<Integer> center = new HashSet<Integer>();
            // ���¼����������
            // ���������ھ����У����վ������¼����������
            Point source = null;
            Point dest = null;
            int id = 0;
            ArrayList<Distence> distence = new ArrayList<Distence>();
            for (int j = 0; j < K; j++) {
                distence.clear();
                ArrayList<Point> ps = cluster.get(j).getOfCluster();
                ps.add(allPoints.get(cluster.get(j).getCenter()));
                int size = ps.size();
                if (size > 2) {//һ������ֻ��1����2����Ͳ����¸��¾�������
                    // �������
                    for (int k1 = 0; k1 < size; k1++) {
                        for (int k2 = 0; k2 < size; k2++) {
                            if (k1 != k2) {
                                source = ps.get(k1);
                                dest = ps.get(k2);
                                distence.add(new Distence(dest.getId(), source
                                        .getId(), (Double) Math.sqrt(StrictMath
                                        .pow(source.getX() - dest.getX(), 2)
                                        + StrictMath.pow(source.getY()
                                                - dest.getY(), 2))));
                            }
                        }
                    }
                    // �Ƚϴ�С
                    double min = distence.get(0).getDist();
                    for (int k = 1; k < distence.size(); k++) {
                        if (min > distence.get(k).getDist()) {
                            min = distence.get(k).getDist();
                            id = distence.get(k).getSource();
                        } else {
                            id = distence.get(0).getSource();
                        }
                    }
                    center.add(id);
                } else {
                    center.add(cluster.get(j).getCenter());
                }
            }
            // ����һ��������������µľ�������
            // center = firstChoose();
            // ���¾���
            cluster = clusterProcess(beforCP(center), center);
            for (int nz = 0; nz < K; nz++) {
                te = te + cluster.get(nz).getError();//�������
            }
            if (te < E)
                break;
        }
        return cluster;
    }

    //���������Ϣ
    public static void print(ArrayList<Cluster> cs) {
        double e = 0;
        for (int i = 0; i < cs.size(); i++) {
            e = e + cs.get(i).getError();
        }
        System.out.print("---e ");
        System.out.printf("%8.6f", e);
        System.out.println("-------------");
        for (int i = 0; i < cs.size(); i++) {
            Cluster c = cs.get(i);
            System.out.println("center: " +allPoints.get(c.center) + " error: " + c.getError());
            ArrayList<Point> p = c.getOfCluster();
            for (int j = 0; j < p.size(); j++) {
                System.out.print(p.get(j));
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) throws IOException {
        Kmeans kmeans = new Kmeans();
        kmeans.prepare();
        Set<Integer> center = kmeans.firstChoose();
        ArrayList<Cluster> cs = kmeans.clusterProcess(kmeans.beforCP(center),center);
        print(cs);
        ArrayList<Cluster> cs2 = kmeans.stack(cs);
        print(cs2);
    }
}

