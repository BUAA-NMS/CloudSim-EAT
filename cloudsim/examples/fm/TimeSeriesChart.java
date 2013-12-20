package org.cloudbus.cloudsim.examples.fm;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.SimpleDateFormat;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Minute;
import org.jfree.data.time.Month;
import org.jfree.data.time.Second;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;

public class TimeSeriesChart {
	ChartPanel frame1;
	private static int a[][]= new int [10][300];
	private static int flag = 0;
	private static int flag2 = 0;
	public TimeSeriesChart(){
		
		getFile("D://test//C3");
		XYDataset xydataset = createDataset();
		JFreeChart jfreechart = ChartFactory.createTimeSeriesChart("负载运行期间能耗时间曲线", "时间", "能耗值",xydataset, true, true, true);
		XYPlot xyplot = (XYPlot) jfreechart.getPlot();
		DateAxis dateaxis = (DateAxis) xyplot.getDomainAxis();
        dateaxis.setDateFormatOverride(new SimpleDateFormat(""));
        frame1=new ChartPanel(jfreechart,true);
        dateaxis.setLabelFont(new Font("黑体",Font.BOLD,14));         //水平底部标题
        dateaxis.setTickLabelFont(new Font("宋体",Font.BOLD,12));  //垂直标题
        ValueAxis rangeAxis=xyplot.getRangeAxis();//获取柱状
        rangeAxis.setLabelFont(new Font("黑体",Font.BOLD,15));
        jfreechart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15));
        jfreechart.getTitle().setFont(new Font("宋体",Font.BOLD,20));//设置标题字体

	} 
	 private static XYDataset createDataset() {  //这个数据集有点多，但都不难理解
		 TimeSeriesCollection timeseriescollection = new TimeSeriesCollection();
	       for(int i=0;i<flag2;i++)
	       {
	    	    if(i==0)
	    	    {
	    	    TimeSeries timeseries = new TimeSeries("第1次模拟过程 ",
	    	                org.jfree.data.time.Month.class);
	        	for(int j=0;j<a[flag2].length;j++)
	        	{
	        		timeseries.add(new Month(1, j+2), a[i][j]);
	        	}
	        	timeseriescollection.addSeries(timeseries);
	    	    }
	    	    
	    	    if(i==1)
	    	    {
	    	    	TimeSeries timeseries2 = new TimeSeries("第2次模拟过程 ",
	    	                org.jfree.data.time.Month.class);
	    	    	for(int j=0;j<a[flag2].length;j++)
	    	    	{
	    	    		timeseries2.add(new Month(1, j+2), a[i][j]);
	    	    	}
	    	    	timeseriescollection.addSeries(timeseries2);
	    	    }
	    	    
	    	    if(i==2)
	    	    {
	    	    	TimeSeries timeseries3 = new TimeSeries("第3次模拟过程 ",
	    	                org.jfree.data.time.Month.class);
	        	for(int j=0;j<a[flag2].length;j++)
	        	{
	        		timeseries3.add(new Month(1, j+2), a[i][j]);
	        	}
	        	timeseriescollection.addSeries(timeseries3);
	    	    }
	    	    
	    	    if(i==3)
	    	    {
	    	    	TimeSeries timeseries4 = new TimeSeries("第4次模拟过程 ",
	    	                org.jfree.data.time.Month.class);
	        	for(int j=0;j<a[flag2].length;j++)
	        	{     		
	        		timeseries4.add(new Month(1, j+2), a[i][j]);
	        	}
	        	timeseriescollection.addSeries(timeseries4);
	    	    }
	    	    
	    	    if(i==4)
	    	    {
	    	    	TimeSeries timeseries5 = new TimeSeries("第4次模拟过程 ",
	    	                org.jfree.data.time.Month.class);
	        	for(int j=0;j<a[flag2].length;j++)
	        	{
	        		timeseries5.add(new Month(1, j+2), a[i][j]);
	        	}
	        	timeseriescollection.addSeries(timeseries5);
	    	    }
	    	    
	       }
		/* TimeSeries timeseries = new TimeSeries("第1次模拟过程 ",
	                org.jfree.data.time.Month.class);
	        timeseries.add(new Month(1, 1), 81);
	        timeseries.add(new Month(1, 2), 97);
	        timeseries.add(new Month(1, 3), 113);
	        timeseries.add(new Month(1, 4), 117);
	        timeseries.add(new Month(1, 5), 58);
	        timeseries.add(new Month(1, 6), 98);
	        timeseries.add(new Month(1, 7), 153);
	        timeseries.add(new Month(1, 8), 142);
	        timeseries.add(new Month(1, 9), 123);
	        //timeseries.add(new Month(11, 2001), 123.2D);
	        /*timeseries.add(new Month(12, 2001), 139.59999999999999D);
	        timeseries.add(new Month(1, 2002), 142.90000000000001D);
	        timeseries.add(new Month(2, 2002), 138.69999999999999D);
	        timeseries.add(new Month(3, 2002), 137.30000000000001D);
	        timeseries.add(new Month(4, 2002), 143.90000000000001D);
	        timeseries.add(new Month(5, 2002), 109.80000000000001D);
	        timeseries.add(new Month(6, 2002), 117D);
	        timeseries.add(new Month(7, 2002), 132.80000000000001D);
	        timeseries.add(new Month(8, 2002), 129.59999999999999D);
	        timeseries.add(new Month(9, 2002), 133.2D);
	        timeseries.add(new Month(10, 2002), 47.2D);
	        timeseries.add(new Month(11, 2002), 74.09999999999999D);
	        timeseries.add(new Month(12, 2002), 122.59999999999999D);
	        timeseries.add(new Month(1, 2003), 111.7D);
	        timeseries.add(new Month(2, 2003), 111D);
	        timeseries.add(new Month(3, 2003), 109.59999999999999D);
	        timeseries.add(new Month(4, 2003), 113.2D);
	        timeseries.add(new Month(5, 2003), 111.59999999999999D);
	        timeseries.add(new Month(6, 2003), 48.8D);
	        timeseries.add(new Month(7, 2003), 71.59999999999999D);
	        timeseries.add(new Month(8, 2004), 57.5D);
	        timeseries.add(new Month(9, 2003), 92.7D);
	        timeseries.add(new Month(10, 2003), 101.5D);
	        timeseries.add(new Month(11, 2003), 106.09999999999999D);
	        timeseries.add(new Month(12, 2003), 110.3D);
	        
	        
	       /*TimeSeries timeseries1 = new TimeSeries("第二次模拟过程",
	                org.jfree.data.time.Month.class);
			timeseries1.add(new Month(2, 2001), 172.80000000000001D);
	        timeseries1.add(new Month(3, 2001), 157.30000000000001D);
	        timeseries1.add(new Month(4, 2001), 133.80000000000001D);
	        timeseries1.add(new Month(5, 2001), 177.59999999999999D);
	        timeseries1.add(new Month(6, 2001), 148.80000000000001D);
	        timeseries1.add(new Month(7, 2001), 141.30000000000001D);
	        timeseries1.add(new Month(8, 2001), 163.90000000000001D);
	        timeseries1.add(new Month(9, 2001), 149.69999999999999D);
	        timeseries1.add(new Month(10, 2001), 113.2D);
	        timeseries1.add(new Month(11, 2001), 123.2D);
	        timeseries1.add(new Month(12, 2001), 135.59999999999999D);
	        timeseries1.add(new Month(1, 2002), 137.90000000000001D);
	        timeseries1.add(new Month(2, 2002), 134.69999999999999D);
	        timeseries1.add(new Month(3, 2002), 139.30000000000001D);
	        timeseries1.add(new Month(4, 2002), 157.90000000000001D);
	        timeseries1.add(new Month(5, 2002), 129.80000000000001D);
	        timeseries1.add(new Month(6, 2002), 117D);
	        timeseries1.add(new Month(7, 2002), 102.80000000000001D);
	        timeseries1.add(new Month(8, 2002), 139.59999999999999D);
	        timeseries1.add(new Month(9, 2002), 125.2D);
	        timeseries1.add(new Month(10, 2002), 127.2D);
	        timeseries1.add(new Month(11, 2002), 144.09999999999999D);
	        timeseries1.add(new Month(12, 2002), 132.59999999999999D);
	        timeseries1.add(new Month(1, 2003), 101.7D);
	        timeseries1.add(new Month(2, 2003), 117D);
	        timeseries1.add(new Month(3, 2003), 129.59999999999999D);
	        timeseries1.add(new Month(4, 2003), 117.2D);
	        timeseries1.add(new Month(5, 2003), 110.59999999999999D);
	        timeseries1.add(new Month(6, 2003), 98.8D);
	        timeseries1.add(new Month(7, 2003), 81.59999999999999D);
	        timeseries1.add(new Month(8, 2004), 106.5D);
	        timeseries1.add(new Month(9, 2003), 122.7D);
	        timeseries1.add(new Month(10, 2003), 57.5D);
	        timeseries1.add(new Month(11, 2003), 127.09999999999999D);
	        timeseries1.add(new Month(12, 2003), 99.3D);
	        
	        TimeSeries timeseries2 = new TimeSeries("第三次模拟过程",
	                org.jfree.data.time.Month.class);
	        timeseries2.add(new Month(2, 2001), 132.80000000000001D);
	        timeseries2.add(new Month(3, 2001), 167.30000000000001D);
	        timeseries2.add(new Month(4, 2001), 113.80000000000001D);
	        timeseries2.add(new Month(5, 2001), 182.59999999999999D);
	        timeseries2.add(new Month(6, 2001), 144.80000000000001D);
	        timeseries2.add(new Month(7, 2001), 137.30000000000001D);
	        timeseries2.add(new Month(8, 2001), 55.90000000000001D);
	        timeseries2.add(new Month(9, 2001), 49.69999999999999D);
	        timeseries2.add(new Month(10, 2001), 13.2D);
	        timeseries2.add(new Month(11, 2001), 43.2D);
	        timeseries2.add(new Month(12, 2001), 95.59999999999999D);
	        timeseries2.add(new Month(1, 2002), 14.90000000000001D);
	        timeseries2.add(new Month(2, 2002), 66.69999999999999D);
	        timeseries2.add(new Month(3, 2002), 33.30000000000001D);
	        timeseries2.add(new Month(4, 2002), 55.90000000000001D);
	        timeseries2.add(new Month(5, 2002), 23.80000000000001D);
	        timeseries2.add(new Month(6, 2002), 17D);
	        timeseries2.add(new Month(7, 2002), 21.80000000000001D);
	        timeseries2.add(new Month(8, 2002), 39.59999999999999D);
	        timeseries2.add(new Month(9, 2002), 25.2D);
	        timeseries2.add(new Month(10, 2002), 57.2D);
	        timeseries2.add(new Month(11, 2002), 131.09999999999999D);
	        timeseries2.add(new Month(12, 2002), 121.59999999999999D);
	        timeseries2.add(new Month(1, 2003), 11.7D);
	        timeseries2.add(new Month(2, 2003), 97D);
	        timeseries2.add(new Month(3, 2003), 59.59999999999999D);
	        timeseries2.add(new Month(4, 2003), 47.2D);
	        timeseries2.add(new Month(5, 2003), 11.59999999999999D);
	        timeseries2.add(new Month(6, 2003), 98.8D);
	        timeseries2.add(new Month(7, 2003), 61.59999999999999D);
	        timeseries2.add(new Month(8, 2004), 29.5D);
	        timeseries2.add(new Month(9, 2003), 22.7D);
	        timeseries2.add(new Month(10, 2003), 157.5D);
	        timeseries2.add(new Month(11, 2003), 77.09999999999999D);
	        timeseries2.add(new Month(12, 2003), 89.3D);
	        */
	        
	        //TimeSeriesCollection timeseriescollection = new TimeSeriesCollection();
	        //timeseriescollection.addSeries(timeseries);
	        //timeseriescollection.addSeries(timeseries1);
	        //timeseriescollection.addSeries(timeseries2);
	        return timeseriescollection;
	    }
	  public ChartPanel getChartPanel(){
	    	return frame1;
	    	
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
					flag2++;
					flag=0;
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
		        int aa=0,cc=0;
		        
		        try {
					while ((data = br.readLine()) != null) {
						a[flag2][flag]=Integer.parseInt(data);
						System.out.println(a[flag2][flag]);
						flag++;
						
					}
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		       

		}
}
