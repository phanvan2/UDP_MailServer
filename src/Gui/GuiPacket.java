package Gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Class.Packet;


import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;

public class GuiPacket extends JPanel {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame b = new JFrame();
					GuiPacket JPanel = new GuiPacket(new Packet("phan", "phjfl", "jlskadjf", "Jlkjsf", null, null));
		
					b.getContentPane().add(JPanel);
					b.setVisible(true);
					b.setSize(500,500);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GuiPacket(Packet packet) {
		
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setLayout(new GridLayout(1,3));
		
		JLabel lblName = new JLabel("Phan V\u0102n PH\u00F9ng");
		contentPane.add(lblName);
		lblName.setText(packet.getName());
		
		JLabel lblTitle = new JLabel("v\u1EAFn b\u1EA3n n\u00E0y d\u00F9ng \u0111\u1EC3 text");
		lblTitle.setAlignmentX(5000);
		contentPane.add(lblTitle);
		lblTitle.setText(packet.getTitle());
		
		JLabel lblDate = new JLabel("12/5/2001");
		contentPane.add(lblDate);
		lblDate.setText(packet.getDate()); 
		
		this.setLayout(new BorderLayout());
		this.add(contentPane, BorderLayout.CENTER);
		this.setVisible(true);
		
	}

}
