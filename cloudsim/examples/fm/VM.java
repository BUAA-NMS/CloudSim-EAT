package org.cloudbus.cloudsim.examples.fm;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Choice;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class VM extends JFrame {

	private JPanel contentPane;
	private JTextField textField_3;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VM frame = new VM();
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
	public VM() {
		setTitle("VM Setup");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 578, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton button = new JButton("Submit");
		
		button.setBounds(167, 225, 93, 23);
		panel.add(button);
		
		JButton button_1 = new JButton("Cancel");
		button_1.setBounds(312, 225, 93, 23);
		panel.add(button_1);
		
		JLabel label_2 = new JLabel("Vmm");
		label_2.setBounds(144, 32, 35, 15);
		panel.add(label_2);
		
		JLabel lblBw = new JLabel("BW");
		lblBw.setBounds(354, 32, 62, 15);
		panel.add(lblBw);
		
		JLabel lblMips = new JLabel("MIPS");
		lblMips.setBounds(21, 32, 63, 15);
		panel.add(lblMips);
		
		JLabel lblSize = new JLabel("Size");
		lblSize.setBounds(250, 28, 35, 15);
		panel.add(lblSize);
		
		JLabel lblRam = new JLabel("RAM");
		lblRam.setBounds(441, 28, 84, 15);
		panel.add(lblRam);
		
		final Choice choice_1 = new Choice();
		choice_1.setBounds(123, 53, 70, 21);
		panel.add(choice_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(344, 53, 72, 21);
		panel.add(textField_3);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(12, 53, 72, 21);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(228, 53, 72, 21);
		panel.add(textField_2);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(451, 53, 72, 21);
		panel.add(textField_4);
		
		JLabel lblVm = new JLabel("VM_1");
		lblVm.setBounds(2, 0, 72, 15);
		panel.add(lblVm);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				aaa.VMv.add(textField_1.getText());
				aaa.VMv.add(choice_1.getSelectedItem());
				aaa.VMv.add(textField_2.getText());
				aaa.VMv.add(textField_3.getText());
				aaa.VMv.add(textField_4.getText());
			}
		});
	}

}
