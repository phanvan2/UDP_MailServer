package Gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Class.Packet;
import constant.Constant;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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
					GuiPacket JPanel = new GuiPacket(new Packet("phan","",  "phjfl", "jlskadjf", "Jlkjsf", null, null));
					
					
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
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.orange);
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblImage = new JLabel("");
		try {
			BufferedImage bufferImage_hidden = ImageIO.read(new File(new Constant().LINK_PATH_IMAGE+ "logoUser.png"));
			ImageIcon imageIcon_hidden = new ImageIcon(bufferImage_hidden.getScaledInstance(50, 50, Image.SCALE_SMOOTH));
			lblImage.setIcon(imageIcon_hidden);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		panel_1.add(lblImage, BorderLayout.CENTER);
		
		JLabel lblName = new JLabel("Phan V\u0102n PH\u00F9ng");
		lblName.setBackground(Color.white);

		contentPane.add(lblName);
		lblName.setText(packet.getName_send());
		
		JLabel lblTitle = new JLabel("v\u1EAFn b\u1EA3n n\u00E0y d\u00F9ng \u0111\u1EC3 text");
		lblTitle.setBackground(Color.white);
		lblTitle.setAlignmentX(5000);
		contentPane.add(lblTitle);
		lblTitle.setText(packet.getTitle());
		
		JLabel lblDate = new JLabel("12/5/2001");
		lblTitle.setBackground(Color.white);

		contentPane.add(lblDate);
		lblDate.setText(packet.getDate()); 
		
		this.setLayout(new BorderLayout());
		this.add(contentPane, BorderLayout.CENTER);
		this.setVisible(true);
		
	}
}