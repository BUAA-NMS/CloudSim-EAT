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


public class Cloudlet extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cloudlet frame = new Cloudlet();
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
	public Cloudlet() {
		setTitle("Cloudlet Setup");
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
				//aaa.Cloudletv.add(panel)
			}
		});
		button.setBounds(97, 250, 93, 23);
		panel.add(button);
		
		JButton button_1 = new JButton("Cancel");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				aaa.Cloudletv.add(textField_1);
				aaa.Cloudletv.add(textField_2);
				aaa.Cloudletv.add(textField_3);
				aaa.Cloudletv.add(textField_4);
			}
		});
		button_1.setBounds(242, 250, 93, 23);
		panel.add(button_1);
		
		JLabel lblOutputsize = new JLabel("outputSize");
		lblOutputsize.setBounds(359, 42, 63, 15);
		panel.add(lblOutputsize);
		
		JLabel lblLength = new JLabel("Length");
		lblLength.setBounds(40, 42, 63, 15);
		panel.add(lblLength);
		
		JLabel lblPesnumber = new JLabel("pesNumber");
		lblPesnumber.setBounds(141, 42, 63, 15);
		panel.add(lblPesnumber);
		
		JLabel lblFilesize = new JLabel("fileSize");
		lblFilesize.setBounds(239, 42, 84, 15);
		panel.add(lblFilesize);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(31, 67, 72, 21);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(132, 67, 72, 21);
		panel.add(textField_2);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(350, 67, 72, 21);
		panel.add(textField_4);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(229, 67, 72, 21);
		panel.add(textField_3);
		
		JLabel lblCloudelet = new JLabel("Cloudelet_1");
		lblCloudelet.setBounds(12, 10, 72, 15);
		panel.add(lblCloudelet);
	}
}
