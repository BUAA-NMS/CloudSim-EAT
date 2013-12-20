package org.cloudbus.cloudsim.examples.fm;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Choice;
import javax.swing.JEditorPane;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JToggleButton;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class DataCenter extends JFrame {

	private JPanel contentPane;
	private JTextField textField_6;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DataCenter frame = new DataCenter();
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
	public DataCenter() {
		setTitle("DataCenter Setup");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 578, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Submit");
		
		btnNewButton.setBounds(97, 250, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnCancle = new JButton("Cancel");
		btnCancle.setBounds(242, 250, 93, 23);
		contentPane.add(btnCancle);
		
		JLabel lblNewLabel = new JLabel("Arch");
		lblNewLabel.setBounds(28, 42, 35, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblOs = new JLabel("OS");
		lblOs.setBounds(120, 42, 35, 15);
		contentPane.add(lblOs);
		
		JLabel lblVmm = new JLabel("Vmm");
		lblVmm.setBounds(208, 42, 35, 15);
		contentPane.add(lblVmm);
		
		JLabel lblHostlist = new JLabel("Hostlist");
		lblHostlist.setBounds(384, 42, 62, 15);
		contentPane.add(lblHostlist);
		
		JLabel lblTimezone = new JLabel("Time_zone");
		lblTimezone.setBounds(293, 42, 63, 15);
		contentPane.add(lblTimezone);
		
		JLabel lblCost = new JLabel("Cost");
		lblCost.setBounds(28, 131, 35, 15);
		contentPane.add(lblCost);
		
		JLabel lblCostpermem = new JLabel("CostPerMem");
		lblCostpermem.setBounds(106, 131, 63, 15);
		contentPane.add(lblCostpermem);
		
		JLabel lblCostperstorage = new JLabel("CostPerStorage");
		lblCostperstorage.setBounds(186, 131, 84, 15);
		contentPane.add(lblCostperstorage);
		
		JLabel lblCostperbw = new JLabel("CostPerBw");
		lblCostperbw.setBounds(288, 131, 84, 15);
		contentPane.add(lblCostperbw);
		
		final Choice choice_1 = new Choice();
		choice_1.add("Linux");
		choice_1.setBounds(97, 63, 70, 21);
		contentPane.add(choice_1);
		
		final Choice choice_2 = new Choice();
		choice_2.setBounds(187, 63, 70, 21);
		contentPane.add(choice_2);
		
		textField_6 = new JTextField();
		textField_6.setBounds(288, 156, 72, 21);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(284, 63, 72, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(374, 63, 72, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(12, 156, 72, 21);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(97, 156, 72, 21);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(196, 156, 72, 21);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblDatacenter = new JLabel("DataCenter_1");
		lblDatacenter.setBounds(12, 10, 72, 15);
		contentPane.add(lblDatacenter);
		
		final Choice choice = new Choice();
		choice.add("x86");
		choice.setBounds(10, 63, 72, 21);
		contentPane.add(choice);
		
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			aaa.Datacenterv.add(choice_1.getSelectedItem());
			aaa.Datacenterv.add(choice_2.getSelectedItem());
			aaa.Datacenterv.add(textField_1.getText());
			aaa.Datacenterv.add(textField_2.getText());
			aaa.Datacenterv.add(textField_3.getText());
			aaa.Datacenterv.add(textField_4.getText());
			aaa.Datacenterv.add(textField_5.getText());
			aaa.Datacenterv.add(textField_6.getText());
			
			}
		});
	}
}
