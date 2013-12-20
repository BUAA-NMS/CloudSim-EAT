package org.cloudbus.cloudsim.examples.fm;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Label;
import java.awt.Button;
import javax.swing.JSlider;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.JCheckBox;
import javax.swing.JMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


public class aaa extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	public static int H_amount=0, D_amount=0,V_amount=0,C_amount=0,U_amount=0;
	public static ArrayList Hostv = new ArrayList();
	public static ArrayList Datacenterv = new ArrayList();
	public static ArrayList VMv= new ArrayList();
	public static ArrayList Cloudletv= new ArrayList();
	public static ArrayList Userv= new ArrayList();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					aaa frame = new aaa();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public aaa() {
		setTitle("Main Table");
		
		/*getContentPane().setLayout(new GridLayout(3,2,5,5));
		add(new JLabel("First name"));
		add(new JTextField(8));
		add(new JLabel("MI"));
		add(new JTextField(1));
		add(new JLabel("Last name"));
		add(new JTextField(8));*/
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 802, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(427, 66, 302, 361);
		contentPane.add(textField);
		textField.setColumns(10);
		
		Label label = new Label("Running information");
		label.setAlignment(Label.CENTER);
		label.setBounds(502, 37, 141, 23);
		contentPane.add(label);
		
		JLabel lblNewLabel_9 = new JLabel("Amount");
		lblNewLabel_9.setBounds(91, 29, 126, 31);
		contentPane.add(lblNewLabel_9);
		
		final JPanel panel_1 = new JPanel();
		//panel_1.setVisible(false);
		panel_1.setBounds(10, 63, 407, 44);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton button = new JButton("Add Host");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				H_amount++;
				try {
					Host frame = new Host();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		button.setBounds(165, 10, 126, 30);
		panel_1.add(button);
		
		JLabel label_1 = new JLabel("Host");
		label_1.setBounds(10, 10, 72, 31);
		panel_1.add(label_1);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(68, 15, 72, 25);
		panel_1.add(spinner);
		
		JCheckBox checkBox_4 = new JCheckBox("Done");
		
		checkBox_4.setBounds(310, 14, 103, 23);
		panel_1.add(checkBox_4);
		
		final JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 117, 404, 44);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		panel_2.setVisible(false);
		
		checkBox_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_2.setVisible(true);
			}
		});
		
		JButton button_1 = new JButton("Add DataCenter");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				D_amount++;
				try {
					DataCenter frame = new DataCenter();
					frame.setVisible(true);
				} catch (Exception ed) {
					ed.printStackTrace();
				}
			}
		});
		button_1.setBounds(165, 11, 126, 30);
		panel_2.add(button_1);
		
		JLabel label_2 = new JLabel("DataCenter");
		label_2.setBounds(0, 10, 72, 31);
		panel_2.add(label_2);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(68, 14, 72, 25);
		panel_2.add(spinner_1);
		
		JCheckBox checkBox = new JCheckBox("Done");
		
		checkBox.setBounds(313, 15, 103, 23);
		panel_2.add(checkBox);
		
		final JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 171, 407, 44);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		panel_3.setVisible(false);
		
		checkBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_3.setVisible(true);
			}
		});
		JLabel lblNewLabel_8 = new JLabel("VMs");
		lblNewLabel_8.setBounds(0, 10, 72, 31);
		panel_3.add(lblNewLabel_8);
		
		JSpinner spinner_V = new JSpinner();
		spinner_V.setBounds(68, 13, 72, 25);
		panel_3.add(spinner_V);
		
		JButton btnAddVms = new JButton("Add VMs");
		btnAddVms.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				V_amount++;
				try {
					VM frame = new VM();
					frame.setVisible(true);
				} catch (Exception ev) {
					ev.printStackTrace();
				}
			}
		});
		btnAddVms.setBounds(163, 10, 126, 30);
		panel_3.add(btnAddVms);
		
		JCheckBox checkBox_1 = new JCheckBox("Done");
		
		checkBox_1.setBounds(314, 14, 103, 23);
		panel_3.add(checkBox_1);
		
		final JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 225, 407, 44);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		panel_4.setVisible(false);
		
		checkBox_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_4.setVisible(true);
			}
		});
		
		JLabel lblNewLabel_6 = new JLabel("Cloudlet");
		lblNewLabel_6.setBounds(0, 10, 72, 31);
		panel_4.add(lblNewLabel_6);
		
		JSpinner spinner_C = new JSpinner();
		spinner_C.setBounds(68, 10, 72, 25);
		panel_4.add(spinner_C);
		
		JButton btnAddCloudlets = new JButton("Add CloudLets");
		btnAddCloudlets.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				C_amount++;
				try {
					Cloudlet frame = new Cloudlet();
					frame.setVisible(true);
				} catch (Exception ec) {
					ec.printStackTrace();
				}
			}
		});
		btnAddCloudlets.setBounds(163, 10, 126, 30);
		panel_4.add(btnAddCloudlets);
		
		JCheckBox checkBox_2 = new JCheckBox("Done");
		
		checkBox_2.setBounds(315, 11, 103, 23);
		panel_4.add(checkBox_2);
		
		final JPanel panel_5 = new JPanel();
		panel_5.setBounds(10, 279, 407, 44);
		contentPane.add(panel_5);
		panel_5.setLayout(null);
		panel_5.setVisible(false);
		
		checkBox_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_5.setVisible(true);
			}
		});
		
		JLabel lblNewLabel_10 = new JLabel("Users");
		lblNewLabel_10.setBounds(0, 10, 72, 31);
		panel_5.add(lblNewLabel_10);
		
		JSpinner spinner_U = new JSpinner();
		spinner_U.setBounds(68, 13, 72, 25);
		panel_5.add(spinner_U);
		
		JButton btnAddUsers = new JButton("Add Users");
		btnAddUsers.setBounds(162, 10, 126, 30);
		panel_5.add(btnAddUsers);
		
		JCheckBox checkBox_3 = new JCheckBox("Done");
		
		checkBox_3.setBounds(317, 14, 103, 23);
		panel_5.add(checkBox_3);
		
		final JButton btnNewButton = new JButton("Start Simulation");
		btnNewButton.setBounds(33, 379, 141, 38);
		contentPane.add(btnNewButton);
		btnNewButton.setVisible(false);
		
		checkBox_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				U_amount++;
				btnNewButton.setVisible(true);
			}
		});
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(219, 379, 141, 38);
		contentPane.add(btnCancel);
	}
	/*Hostv = new ArrayList();
	public ArrayList Datacenterv = new ArrayList();
	public ArrayList VMv= new ArrayList();
	public ArrayList Cloudletv= new ArrayList();
	public ArrayList Userv= new ArrayList();*/
	public static void setHostv(String a)
	{
		Hostv.add(a);
	}
	public static void setDatacenterv(String a)
	{
		Datacenterv.add(a);
	}
	public static void setVMv(String a)
	{
		VMv.add(a);
	}
	public static void setCloudletv(String a)
	{
		Cloudletv.add(a);
	}
	public static void setUserv(String a)
	{
		Userv.add(a);
	}

}
