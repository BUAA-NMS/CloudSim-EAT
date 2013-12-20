package org.cloudbus.cloudsim.examples.fm;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

//��������ͼ����һ��Ч������ʵ����һ����ȶ�ֻ�����ݼ������˱仯�����������仯
public class BarChart1 {
	ChartPanel frame1;
	private static int a[]= new int [288];
	private static int flag = 0;
	private static int barcount=0;
	public  BarChart1(){
		delAllFile("d:/test/C1/");
		delAllFile("d:/test/C2/");
		//delAllFile("d:/test/C3/");

		getFile("D://test//C1");
		CategoryDataset dataset = getDataSet();
        JFreeChart chart = ChartFactory.createBarChart3D(
        		 "�ܺ�Ч��", // ͼ�����
                 "ģ�����", // Ŀ¼�����ʾ��ǩ
                 "�ĵ���", // ��ֵ�����ʾ��ǩ
                            dataset, // ���ݼ�
                            PlotOrientation.VERTICAL, // ͼ����ˮƽ����ֱ
                            true,           // �Ƿ���ʾͼ��(���ڼ򵥵���״ͼ������false)
                            false,          // �Ƿ����ɹ���
                            false           // �Ƿ�����URL����
                            );
        
        //�����￪ʼ
        CategoryPlot plot=chart.getCategoryPlot();//��ȡͼ���������
        CategoryAxis domainAxis=plot.getDomainAxis();         //ˮƽ�ײ��б�
         domainAxis.setLabelFont(new Font("����",Font.BOLD,14));         //ˮƽ�ײ�����
         domainAxis.setTickLabelFont(new Font("����",Font.BOLD,12));  //��ֱ����
         ValueAxis rangeAxis=plot.getRangeAxis();//��ȡ��״
         rangeAxis.setLabelFont(new Font("����",Font.BOLD,15));
          chart.getLegend().setItemFont(new Font("����", Font.BOLD, 15));
          chart.getTitle().setFont(new Font("����",Font.BOLD,20));//���ñ�������
          
          //�������������Ȼ�����е�࣬��ֻΪһ��Ŀ�ģ����������������
          
         frame1=new ChartPanel(chart,true);        //����Ҳ������chartFrame,����ֱ������һ��������Frame
         
	}
	   private static CategoryDataset getDataSet() {
           DefaultCategoryDataset dataset = new DefaultCategoryDataset();
           for(int i=0;i<barcount;i++)
           {
        	   System.out.println(a[i]);
           dataset.addValue(a[i],Integer.toString(i+1)+"ģ��" , Integer.toString(i+1)+"ģ��");
           }
           //dataset.addValue(200, "2ģ��", "2ģ��");
           //dataset.addValue(170, "3ģ��", "3ģ��");
           //dataset.addValue(400, "�㽶", "�㽶");
           //dataset.addValue(500, "��֦", "��֦");
           return dataset;
}

public ChartPanel getChartPanel(){
	return frame1;
	
}
public static int getbarcount(){
	return barcount;
}



private static void getFile(String path){    
    // get file list where the path has    
    File file = new File(path);    
    // get the folder list    
    File[] array = file.listFiles();
   // flag = array.length;
       
    for(int i=0;i<array.length;i++){    
        if(array[i].isFile()){    
            // only take file name    
            //System.out.println("^^^^^" + array[i].getName());    
            // take file path and name    
            //System.out.println("#####" + array[i]);    
            // take file path and name    
            System.out.println("*****" + array[i].getPath());    
			calculate_Ave(array[i].getPath());
    } 
    }
} 

private static void calculate_Ave(String filepath)
{
	int count=1,sum = 0;
	File file = new File(filepath);
	Reader reader = null;
	int tem = 0;
	
	FileReader fr = null;
	try {
		fr = new FileReader(file);
	} catch (FileNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
    BufferedReader br = new BufferedReader(fr);
        String data = "0";
        String[] temp = null;
        
        try {
			while ((data = br.readLine()) != null) {
				tem = Integer.parseInt(data);
				a[flag]=tem;
				System.out.println(a[flag]);
				flag++;
			}
			barcount++;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

}

public static void delFolder(String folderPath) {
try {
   delAllFile(folderPath); //ɾ����������������
   String filePath = folderPath;
   filePath = filePath.toString();
   java.io.File myFilePath = new java.io.File(filePath);
   myFilePath.delete(); //ɾ�����ļ���
} catch (Exception e) {
  e.printStackTrace(); 
}
}

//ɾ��ָ���ļ����������ļ�
//param path �ļ�����������·��
public static boolean delAllFile(String path) {
  boolean flag = false;
  File file = new File(path);
  if (!file.exists()) {
    return flag;
  }
  if (!file.isDirectory()) {
    return flag;
  }
  String[] tempList = file.list();
  File temp = null;
  for (int i = 0; i < tempList.length; i++) {
     if (path.endsWith(File.separator)) {
        temp = new File(path + tempList[i]);
     } else {
         temp = new File(path + File.separator + tempList[i]);
     }
     if (temp.isFile()) {
        temp.delete();
     }
     if (temp.isDirectory()) {
        delAllFile(path + "/" + tempList[i]);//��ɾ���ļ���������ļ�
        delFolder(path + "/" + tempList[i]);//��ɾ�����ļ���
        flag = true;
     }
  }
  return flag;
}

}

