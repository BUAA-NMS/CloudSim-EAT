
package org.cloudbus.cloudsim.examples.power.planetlab;


import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JCheckBox;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Choice;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.SystemColor;

import javax.swing.JMenu;
import javax.swing.JTextField;

import org.cloudbus.cloudsim.examples.power.Constants;

import java.awt.Button;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.Arrays;
public class Windows {
	JFrame frmMainwin;
	String pp;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		delAllFile("d:/test/C1/");
		delAllFile("d:/test/C2/");
		delAllFile("d:/test/C3/");

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Windows window = new Windows();
					window.frmMainwin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Windows() {
		initialize();
		delAllFile("d:/test/C1/");
		delAllFile("d:/test/C2/");
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frmMainwin = new JFrame();
		frmMainwin.setTitle("MAIN_WIN");
		frmMainwin.setBounds(100, 100, 614, 790);
		frmMainwin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMainwin.getContentPane().setLayout(null);
		
		final Choice Order = new Choice();
		final Choice StorageType = new Choice();
		final JTextPane V_PES = new JTextPane();
		V_PES.setText(Arrays.toString(Constants.VM_PES));
		final JTextPane V_RAM = new JTextPane();
		V_RAM.setText(Arrays.toString(Constants.VM_RAM));
		final JTextPane V_BW = new JTextPane();
		V_BW.setText(Integer.toString(Constants.VM_BW));
		final JTextPane V_SIZE = new JTextPane();
		V_SIZE.setText(Integer.toString(Constants.VM_SIZE));
		final JTextPane H_BW = new JTextPane();
		H_BW.setText(Integer.toString(Constants.HOST_BW));
		final JTextPane H_STORAGE = new JTextPane();
		H_STORAGE.setText(Integer.toString(Constants.HOST_STORAGE));
		final JTextPane H_MAXNUM = new JTextPane();
		H_MAXNUM.setText(Integer.toString(Constants.HOST_VM_MAX_NUM));
		final JTextPane H_PES = new JTextPane();
		H_PES.setText(Arrays.toString(Constants.HOST_PES));
		final JTextPane H_RAM = new JTextPane();
		H_RAM.setText(Arrays.toString(Constants.HOST_RAM));
		
		final JPanel panel = new JPanel();
		panel.setBackground(SystemColor.info);
		panel.setBounds(27, 23, 562, 87);
		frmMainwin.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u7CFB\u7EDF\u53C2\u6570");
		lblNewLabel.setBounds(10, 38, 56, 32);
		panel.add(lblNewLabel);
		
		final JTextPane INTERVAL = new JTextPane();
		INTERVAL.setBounds(76, 49, 73, 21);
		INTERVAL.setText(Double.toString(Constants.SCHEDULING_INTERVAL));
		panel.add(INTERVAL);
		
		final JTextPane LIMIT = new JTextPane();
		LIMIT.setBounds(175, 49, 73, 21);
		LIMIT.setText(Double.toString(Constants.SIMULATION_LIMIT));
		panel.add(LIMIT);
		
		JCheckBox chckbxDone = new JCheckBox("Done");
		chckbxDone.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!(Order.getSelectedItem()=="DVFS"))
				{
				Constants.Order = Order.getSelectedItem();
				
				}
				panel.setBackground(SystemColor.activeCaption);
			}
		});
		chckbxDone.setBounds(471, 47, 103, 23);
		panel.add(chckbxDone);
		
		JLabel label = new JLabel("\u65F6\u95F4\u95F4\u9694");
		label.setBounds(93, 10, 56, 32);
		panel.add(label);
		
		
		JLabel label_1 = new JLabel("\u6A21\u62DF\u65F6\u957F");
		label_1.setBounds(192, 7, 56, 32);
		panel.add(label_1);
		
		
		JLabel label_2 = new JLabel("\u8C03\u5EA6\u65B9\u6CD5");
		label_2.setBounds(284, 10, 56, 32);
		panel.add(label_2);
		
		Order.setBounds(274, 49, 109, 21);
		panel.add(Order);
	
		
		//StorageType.setBounds(189, 80, 56, 32);


		
		final JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.info);
		panel_1.setLayout(null);
		panel_1.setBounds(27, 123, 562, 87);
		frmMainwin.getContentPane().add(panel_1);
		
		JLabel lblCloudlet = new JLabel("Cloudlet\u8BBE\u7F6E");
		lblCloudlet.setBounds(10, 38, 73, 32);
		panel_1.add(lblCloudlet);
		
		final JTextPane LENGTH = new JTextPane();
		LENGTH.setBounds(149, 49, 73, 21);
		LENGTH.setText(Integer.toString(Constants.CLOUDLET_LENGTH));
		panel_1.add(LENGTH);
		
		final JTextPane C_PES = new JTextPane();
		C_PES.setBounds(297, 49, 73, 21);
		C_PES.setText(Integer.toString(Constants.CLOUDLET_PES));
		panel_1.add(C_PES);
		
		JCheckBox checkBox = new JCheckBox("Done");
		checkBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Constants.CLOUDLET_LENGTH = Integer.parseInt(LENGTH.getText());
				//Constants.CLOUDLET_PES = Integer.parseInt(C_PES.getText());
				panel_1.setBackground(SystemColor.activeCaption);
			}
		});
		checkBox.setBounds(471, 47, 103, 23);
		panel_1.add(checkBox);
		
		JLabel lblLength = new JLabel("LENGTH");
		lblLength.setBounds(166, 10, 56, 32);
		panel_1.add(lblLength);
		
		JLabel lblPes = new JLabel("PES");
		lblPes.setBounds(314, 10, 56, 32);
		panel_1.add(lblPes);
		
		final JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.info);
		panel_2.setLayout(null);
		panel_2.setBounds(27, 224, 562, 155);
		frmMainwin.getContentPane().add(panel_2);
		
		JLabel lblVm = new JLabel("VM\u8BBE\u7F6E");
		lblVm.setBounds(10, 38, 73, 32);
		panel_2.add(lblVm);
		
		final JTextPane V_TYPES = new JTextPane();
		V_TYPES.setBounds(86, 49, 73, 21);
		V_TYPES.setText(Integer.toString(Constants.VM_TYPES));
		panel_2.add(V_TYPES);
		
		final JTextPane V_MIPS = new JTextPane();
		V_MIPS.setBounds(59, 119, 152, 21);
		String vt = Arrays.toString(Constants.VM_MIPS);
		vt.replace("[", "");
		vt.replace("]", "");
		V_MIPS.setText(vt);
		panel_2.add(V_MIPS);
		
		JCheckBox checkBox_1 = new JCheckBox("Done");
		checkBox_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Constants.VM_TYPES = Integer.parseInt(V_TYPES.getText());
				//String tt = V_MIPS.getText();
				//tt.replace("[", "");
				//tt.replace("[", "");
				//String tem1[] = ((V_MIPS.getText().replace("[", "")).replace("]", "").replace(" ", "")).split(",");
				//int k1 = Integer.parseInt(tem1[0]);
				//int k2 = Integer.parseInt(tem1[1]);
				//int k3 = Integer.parseInt(tem1[2]);
				//int k4 = Integer.parseInt(tem1[3]);
				//int[] ttt = new int[]{Integer.parseInt(tem1[0]),Integer.parseInt(tem1[1]),Integer.parseInt(tem1[2]),Integer.parseInt(tem1[3])};
				/*Constants.VM_MIPS = new int[]{Integer.parseInt(tem1[0]),Integer.parseInt(tem1[1]),Integer.parseInt(tem1[2]),Integer.parseInt(tem1[3])};
				String tem2[] = V_PES.getText().replace("[", "").replace("]", "").replace(" ", "").split(",");
				Constants.VM_PES = new int[]{Integer.parseInt(tem2[0]),Integer.parseInt(tem2[1]),Integer.parseInt(tem2[2]),Integer.parseInt(tem2[3])};
				String tem3[] = V_RAM.getText().replace("[", "").replace("]", "").replace(" ", "").split(",");
				Constants.VM_RAM = new int[]{Integer.parseInt(tem3[0]),Integer.parseInt(tem3[1]),Integer.parseInt(tem3[2]),Integer.parseInt(tem3[3])};
				Constants.VM_BW = Integer.parseInt(V_BW.getText());
				Constants.VM_SIZE = Integer.parseInt(V_SIZE.getText());*/
				panel_2.setBackground(SystemColor.activeCaption);
				
			}
		});
		checkBox_1.setBounds(472, 85, 103, 23);
		panel_2.add(checkBox_1);
		
		JLabel lblType = new JLabel("TYPE");
		lblType.setBounds(103, 10, 56, 32);
		panel_2.add(lblType);
		
		JLabel lblMips = new JLabel("MIPS\u6570\u503C\u96C6\u5408");
		lblMips.setBounds(71, 77, 88, 32);
		panel_2.add(lblMips);
		
		
		V_PES.setBounds(274, 119, 152, 21);
		panel_2.add(V_PES);
		
		JLabel lblPes_1 = new JLabel("PES\u6570\u503C\u96C6\u5408");
		lblPes_1.setBounds(274, 80, 88, 32);
		panel_2.add(lblPes_1);
		
		JLabel lblRam = new JLabel("RAM\u6570\u503C\u96C6\u5408");
		lblRam.setBounds(388, 10, 88, 32);
		panel_2.add(lblRam);
		
		
		V_RAM.setBounds(377, 49, 161, 21);
		panel_2.add(V_RAM);
		
		JLabel lblBw = new JLabel("BW");
		lblBw.setBounds(199, 10, 56, 32);
		panel_2.add(lblBw);
		
		JLabel lblSize = new JLabel("SIZE");
		lblSize.setBounds(284, 10, 56, 32);
		panel_2.add(lblSize);
		

		V_SIZE.setBounds(274, 49, 73, 21);
		panel_2.add(V_SIZE);
		
		
		V_BW.setBounds(172, 49, 73, 21);
		panel_2.add(V_BW);
		
		final JPanel panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.info);
		panel_3.setLayout(null);
		panel_3.setBounds(27, 395, 562, 155);
		frmMainwin.getContentPane().add(panel_3);
		
		JLabel lblHost = new JLabel("HOST\u8BBE\u7F6E");
		lblHost.setBounds(10, 38, 73, 32);
		panel_3.add(lblHost);
		
		final JTextPane H_TYPES = new JTextPane();
		H_TYPES.setText(Integer.toString(Constants.HOST_TYPES));
		H_TYPES.setBounds(86, 49, 73, 21);
		panel_3.add(H_TYPES);
		
		final JTextPane H_MIPS = new JTextPane();
		H_MIPS.setBounds(40, 122, 130, 21);
		H_MIPS.setText(Arrays.toString(Constants.HOST_MIPS));
		panel_3.add(H_MIPS);
		
		JCheckBox checkBox_2 = new JCheckBox("Done");
		checkBox_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*Constants.HOST_TYPES = Integer.parseInt(H_TYPES.getText());
				Constants.HOST_BW = Integer.parseInt(H_BW.getText());
				Constants.HOST_STORAGE = Integer.parseInt(H_STORAGE.getText());
				Constants.HOST_VM_MAX_NUM = Integer.parseInt(H_MAXNUM.getText());
				String t1[] = H_MIPS.getText().replace("[", "").replace("]", "").replace(" ", "").split(",");
				Constants.HOST_MIPS = new int[]{Integer.parseInt(t1[0]),Integer.parseInt(t1[1])};
				String t2[] = H_PES.getText().replace("[", "").replace("]", "").replace(" ", "").split(",");
				Constants.HOST_PES = new int[]{Integer.parseInt(t1[0]),Integer.parseInt(t1[1])};
				String t3[] = H_RAM.getText().replace("[", "").replace("]", "").replace(" ", "").split(",");
				Constants.HOST_RAM = new int[]{Integer.parseInt(t1[0]),Integer.parseInt(t1[1])};*/
				panel_3.setBackground(SystemColor.activeCaption);
				
			}
		});
		checkBox_2.setBounds(472, 85, 103, 23);
		panel_3.add(checkBox_2);
		
		JLabel label_4 = new JLabel("TYPE");
		label_4.setBounds(103, 10, 56, 32);
		panel_3.add(label_4);
		
		JLabel label_5 = new JLabel("MIPS\u6570\u503C\u96C6\u5408");
		label_5.setBounds(91, 82, 88, 32);
		panel_3.add(label_5);
		
		
		H_PES.setBounds(284, 122, 145, 21);
		panel_3.add(H_PES);
		
		JLabel label_6 = new JLabel("PES\u6570\u503C\u96C6\u5408");
		label_6.setBounds(303, 80, 88, 32);
		panel_3.add(label_6);
		
		JLabel label_7 = new JLabel("RAM\u6570\u503C\u96C6\u5408");
		label_7.setBounds(388, 10, 88, 32);
		panel_3.add(label_7);
		
		
		H_RAM.setBounds(377, 49, 145, 21);
		panel_3.add(H_RAM);
		
		JLabel label_8 = new JLabel("BW");
		label_8.setBounds(201, 10, 56, 32);
		panel_3.add(label_8);
		
		JLabel lblStorage = new JLabel("STORAGE");
		lblStorage.setBounds(189, 80, 56, 32);
		panel_3.add(lblStorage);
		
		StorageType.setBounds(184, 122, 73, 21);
		panel_3.add(StorageType);
		StorageType.add("None");		
		StorageType.add("NAS");
		StorageType.add("DAS");
		
		//H_STORAGE.setBounds(184, 122, 73, 21);
		//panel_3.add(H_STORAGE);
		
		
		H_BW.setBounds(184, 49, 73, 21);
		panel_3.add(H_BW);
		
		JLabel lblHostvmmaxnum = new JLabel("HOST_VM_MAXNUM");
		lblHostvmmaxnum.setBounds(267, 10, 90, 32);
		panel_3.add(lblHostvmmaxnum);
		
		
		H_MAXNUM.setBounds(277, 49, 73, 21);
		panel_3.add(H_MAXNUM);
		
		final JPanel panel_4 = new JPanel();
		panel_4.setBackground(SystemColor.info);
		panel_4.setBounds(27, 560, 562, 109);
		frmMainwin.getContentPane().add(panel_4);
		panel_4.setLayout(null);
		
		JLabel label_3 = new JLabel("\u6DFB\u52A0\u8D1F\u8F7D\u6587\u4EF6");
		label_3.setBounds(10, 36, 96, 32);
		panel_4.add(label_3);
		
		final JTextField WORKLOADPATH = new JTextField();
		WORKLOADPATH.setBounds(90, 42, 264, 21);
		
		panel_4.add(WORKLOADPATH);
		WORKLOADPATH.setColumns(10);
		WORKLOADPATH.setText("C:\\graduate_program\\cloud3\\cloud3\\bin\\workload\\L");
		pp = "C:\\graduate_program\\cloud3\\cloud3\\bin\\workload\\L";
		
		Button button = new Button("Select");
		button.addMouseListener(new MouseAdapter() {
			@Override
				public void mouseClicked(MouseEvent arg0) {
				String path = null;   
				//设置界面风格   
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException
						| UnsupportedLookAndFeelException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}   
				JFileChooser jdir = new JFileChooser();   
				//设置选择路径模式   
				jdir.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);   
				//设置对话框标题   
				jdir.setDialogTitle("请选择路径");   
				if (JFileChooser.APPROVE_OPTION == jdir.showOpenDialog(null)) {//用户点击了确定   
				    path = jdir.getSelectedFile().getAbsolutePath();//取得路径选择   
				}   
				WORKLOADPATH.setText(path);
				//Constants =
				pp = path;
				System.out.println(path);   
				}   
			
		});
		button.setBounds(369, 42, 76, 23);
		panel_4.add(button);
		
		JCheckBox checkBox_3 = new JCheckBox("Done");
		checkBox_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_4.setBackground(SystemColor.activeCaption);
				pp = WORKLOADPATH.getText();
			}
		});
		checkBox_3.setBounds(475, 41, 81, 23);
		panel_4.add(checkBox_3);
		
		JButton btnNewButton = new JButton("Start Simulation");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			
			public void mouseClicked(MouseEvent e) {

				if(Order.getSelectedItem()=="DVFS")
				{
				boolean enableOutput = true;
				boolean outputToFile = false;
				String inputFolder = Dvfs.class.getClassLoader().getResource("workload").getPath();
				
				String outputFolder = String.valueOf(PlanetLabConstants.NUMBER_OF_HOSTS);
				//String workload = "28"; // PlanetLab workload
				pp=WORKLOADPATH.getText();
				String workload = pp.substring(47);
				String vmAllocationPolicy = "dvfs"; // DVFS policy without VM migrations
				String vmSelectionPolicy = "";
				String parameter = "";
				getFile("C:\\graduate_program\\cloud3\\cloud3\\bin\\workload\\"+workload,workload+"_dvfs_2.5_"+Constants.Order);

				new PlanetLabRunner(
						enableOutput,
						outputToFile,
						inputFolder,
						outputFolder,
						workload,
						vmAllocationPolicy,
						vmSelectionPolicy,
						parameter);
			}
				else
				{
					if(Order.getSelectedItem()=="URS"){
						Constants.Order="BestPower";
					}
					else{
						Constants.Order=Order.getSelectedItem();
					}
					boolean enableOutput = true;
					boolean outputToFile = false;
					//String inputFolder = MadMc.class.getClassLoader().getResource("workload/planetlab").getPath();
					String inputFolder = MadMc.class.getClassLoader().getResource("workload").getPath();
					String outputFolder = String.valueOf(PlanetLabConstants.NUMBER_OF_HOSTS);
					//String workload = "L"; // PlanetLab workload
					pp=WORKLOADPATH.getText();
					String workload = pp.substring(47);
					getFile("C:\\graduate_program\\cloud3\\cloud3\\bin\\workload\\"+workload,workload+"_mad_mc_2.5_"+Constants.Order);
					String vmAllocationPolicy = "mad"; // Median Absolute Deviation (MED) VM allocation policy
					String vmSelectionPolicy = "mc"; // Maximum Correlation (MC) VM selection policy
					String parameter = "2.5"; // the safety parameter of the MED policy 
					
					Constants.workload_path = "aaa";
					new PlanetLabRunner(
							enableOutput,
							outputToFile,
							inputFolder,
							outputFolder,
							workload,
							vmAllocationPolicy,
							vmSelectionPolicy,
							parameter);

				}
			}
	
		});
		btnNewButton.setBounds(118, 705, 138, 23);
		frmMainwin.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.setBounds(346, 705, 138, 23);
		frmMainwin.getContentPane().add(btnNewButton_1);
		Order.add("BestResource");
		Order.add("FirstResource");
		Order.add("BestPower");
		Order.add("DVFS");
		Order.add("URS");
		
		
		
		
	}
	
	
	
	
	
	
	private static void getFile(String path,String name){    
        // get file list where the path has    
        File file = new File(path);    
        // get the folder list    
        File[] array = file.listFiles();
        
           
        for(int i=0;i<array.length;i++){    
            if(array[i].isFile()){     
                System.out.println("*****" + array[i].getPath());    
                int tem = 0;
				tem = (int)calculate_Ave(array[i].getPath());
				System.out.println(tem);
				PrintWriter pw1 = null;
				PrintWriter pw2 = null;
				try {
					pw1 = new PrintWriter(new FileWriter("D://test//C3//"+name+".txt",true),true);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				pw1.println(Integer.toString(tem));
            }else if(array[i].isDirectory()){    
                getFile(array[i].getPath(),"");    
            }    
        }    
    } 
	
	
	private static int calculate_Ave(String filepath)
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
				//	System.out.println(count+"    "+tem);
					count++;
					sum=sum+tem;
				}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		return sum/count;
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
