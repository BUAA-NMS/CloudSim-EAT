package org.cloudbus.cloudsim.examples.fm;

import java.awt.Button;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import javax.swing.JFrame;

public class mainClass {
	
	
public mainClass(){
	JFrame frame=new JFrame("CloudSim执行结果数据统计图");
	frame.setLayout(new GridLayout(2,2,10,10));
	//frame.add(new BarChart().getChartPanel());           //添加柱形图
	frame.add(new BarChart1().getChartPanel());//添加柱形图的另一种效果
	frame.add(new BarChart2().getChartPanel()); 
	//frame.add(new PieChart().getChartPanel());           //添加饼状图
	frame.add(new TimeSeriesChart().getChartPanel());    //添加折线图
	frame.add(new Button("加入对比按钮"));
	frame.setBounds(50, 50, 800, 600);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}




}
