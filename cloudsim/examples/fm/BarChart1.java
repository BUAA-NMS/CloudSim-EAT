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

//这是柱形图的另一种效果，其实跟第一种相比都只有数据集发生了变化，再无其他变化
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
        		 "能耗效果", // 图表标题
                 "模拟次数", // 目录轴的显示标签
                 "耗电量", // 数值轴的显示标签
                            dataset, // 数据集
                            PlotOrientation.VERTICAL, // 图表方向：水平、垂直
                            true,           // 是否显示图例(对于简单的柱状图必须是false)
                            false,          // 是否生成工具
                            false           // 是否生成URL链接
                            );
        
        //从这里开始
        CategoryPlot plot=chart.getCategoryPlot();//获取图表区域对象
        CategoryAxis domainAxis=plot.getDomainAxis();         //水平底部列表
         domainAxis.setLabelFont(new Font("黑体",Font.BOLD,14));         //水平底部标题
         domainAxis.setTickLabelFont(new Font("宋体",Font.BOLD,12));  //垂直标题
         ValueAxis rangeAxis=plot.getRangeAxis();//获取柱状
         rangeAxis.setLabelFont(new Font("黑体",Font.BOLD,15));
          chart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15));
          chart.getTitle().setFont(new Font("宋体",Font.BOLD,20));//设置标题字体
          
          //到这里结束，虽然代码有点多，但只为一个目的，解决汉字乱码问题
          
         frame1=new ChartPanel(chart,true);        //这里也可以用chartFrame,可以直接生成一个独立的Frame
         
	}
	   private static CategoryDataset getDataSet() {
           DefaultCategoryDataset dataset = new DefaultCategoryDataset();
           for(int i=0;i<barcount;i++)
           {
        	   System.out.println(a[i]);
           dataset.addValue(a[i],Integer.toString(i+1)+"模拟" , Integer.toString(i+1)+"模拟");
           }
           //dataset.addValue(200, "2模拟", "2模拟");
           //dataset.addValue(170, "3模拟", "3模拟");
           //dataset.addValue(400, "香蕉", "香蕉");
           //dataset.addValue(500, "荔枝", "荔枝");
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
   delAllFile(folderPath); //删除完里面所有内容
   String filePath = folderPath;
   filePath = filePath.toString();
   java.io.File myFilePath = new java.io.File(filePath);
   myFilePath.delete(); //删除空文件夹
} catch (Exception e) {
  e.printStackTrace(); 
}
}

//删除指定文件夹下所有文件
//param path 文件夹完整绝对路径
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
        delAllFile(path + "/" + tempList[i]);//先删除文件夹里面的文件
        delFolder(path + "/" + tempList[i]);//再删除空文件夹
        flag = true;
     }
  }
  return flag;
}

}

