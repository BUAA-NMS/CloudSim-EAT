package org.cloudbus.cloudsim.examples.fm;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Host extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public Host() {
		setTitle("Host Setup");
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
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				aaa.setHostv(textField_1.getText());
				aaa.setHostv(textField_2.getText());
				aaa.setHostv(textField_3.getText());
			}
		});
		button.setBounds(95, 250, 93, 23);
		panel.add(button);
		
		JButton button_1 = new JButton("Cancel");
		button_1.setBounds(240, 250, 93, 23);
		panel.add(button_1);
		
		JLabel lblRam = new JLabel("Ram");
		lblRam.setBounds(38, 42, 63, 15);
		panel.add(lblRam);
		
		JLabel lblStorage = new JLabel("Storage");
		lblStorage.setBounds(139, 42, 63, 15);
		panel.add(lblStorage);
		
		JLabel lblBw = new JLabel("bw");
		lblBw.setBounds(263, 42, 28, 15);
		panel.add(lblBw);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(29, 67, 72, 21);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(240, 67, 72, 21);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(130, 67, 72, 21);
		panel.add(textField_3);
		
		JLabel lblHost = new JLabel("Host_1");
		lblHost.setBounds(10, 10, 72, 15);
		panel.add(lblHost);
	}

}
