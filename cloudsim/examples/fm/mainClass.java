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
	JFrame frame=new JFrame("CloudSimִ�н������ͳ��ͼ");
	frame.setLayout(new GridLayout(2,2,10,10));
	//frame.add(new BarChart().getChartPanel());           //�������ͼ
	frame.add(new BarChart1().getChartPanel());//�������ͼ����һ��Ч��
	frame.add(new BarChart2().getChartPanel()); 
	//frame.add(new PieChart().getChartPanel());           //��ӱ�״ͼ
	frame.add(new TimeSeriesChart().getChartPanel());    //�������ͼ
	frame.add(new Button("����ԱȰ�ť"));
	frame.setBounds(50, 50, 800, 600);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}




}
