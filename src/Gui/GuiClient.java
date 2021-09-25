package Gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListCellRenderer;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ScrollPaneUI;

import Class.Client;
import Class.CustomCell;
import Class.HandleFile;
import Class.Packet;
import constant.Constant;


import javax.swing.JList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;

public class GuiClient extends JFrame implements ActionListener, FocusListener {

	private JPanel contentPane;
	private Vector<Packet> listData = new Vector<Packet>();

	private Vector<Packet> listData_Send = new Vector<Packet>();
	private JTextField txtAdressSend;
	private JTextField txt_Subject;
	private JButton btnSendMail, btnRefesh, btnMessSend ; 
	private JTextArea text_Content ; 
	JList list ; 
	Client client  = null; 
	String nameSend = ""; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiClient frame = new GuiClient("van");
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
	public GuiClient(String nameSend) {
		
		this.nameSend = nameSend ; 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 842, 567);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		setTitle("Mail");
		
		
		try {// set icon giao dien---------------------------
			Image iconmes = ImageIO.read(new File( new Constant().LINK_PATH_IMAGE + "logoMail.jpg"));
			this.setIconImage(iconmes); 
		} catch (IOException e1) {
			// TODO Auto-generated catch block
		
		}
		
		 list = new JList(listData);
		listData.add(new Packet("phan","",  "phjfl", "jlskadjf", "Jlkjsf", null, null)); 
		listData.add(new Packet("phan","",  "phjfl", "jlskadjf", "Jlkjsf", null, null)); 
		listData.add(new Packet("phan","",  "phjfl", "jlskadjf", "Jlkjsf", null, null)); 

		list.updateUI();
		list.setCellRenderer(new CustomCell());
		
		
		
		JScrollPane scroll  = new JScrollPane(list);
	
		scroll.setPreferredSize(getPreferredSize());
		scroll.createVerticalScrollBar();
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		contentPane.add(scroll, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new GridLayout(8, 1));
		
		 btnRefesh = new JButton("Mess receive");
		btnRefesh.addActionListener(this);
		panel_1.add(btnRefesh);
		
		btnMessSend = new JButton("mess send");
		btnMessSend.addActionListener(this);
		panel_1.add(btnMessSend);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.NORTH);
		
		JLabel lbImageUser = new JLabel("");
		try {
			BufferedImage bufferImage_hidden = ImageIO.read(new File(new Constant().LINK_PATH_IMAGE+ "logoUser.png"));
			ImageIcon imageIcon_hidden = new ImageIcon(bufferImage_hidden.getScaledInstance(50, 50, Image.SCALE_SMOOTH));
			lbImageUser.setIcon(imageIcon_hidden);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		panel_2.add(lbImageUser);

		JLabel lblUser = new JLabel("Phan van");
		lblUser.setText(this.nameSend);
		panel_2.add(lblUser);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.EAST);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("New Messeage");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel.add(lblNewLabel_2, BorderLayout.NORTH);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new GridLayout(5,1));
		
		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4);
		panel_4.setLayout(new GridLayout(2,1));
		
		txtAdressSend = new JTextField("To");
		txtAdressSend.addFocusListener(this);
		txtAdressSend.setForeground(Color.gray);
		panel_4.add(txtAdressSend);
		txtAdressSend.setColumns(10);
		
		txt_Subject = new JTextField("Subject");
		txt_Subject.addFocusListener(this);
		txt_Subject.setForeground(Color.gray);
		panel_4.add(txt_Subject);
		txt_Subject.setColumns(10);
		
		text_Content = new JTextArea("Content");
		text_Content.setForeground(Color.gray);
		text_Content.addFocusListener(this);
		panel_3.add(text_Content);
		
		btnSendMail = new JButton("Send");
		panel.add(btnSendMail, BorderLayout.SOUTH);
		btnSendMail.addActionListener(this);
		client = new Client(nameSend) ;
		InitGui();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true) {
					Packet packet  =  client.receiveMess(); 
					if(packet != null) {
						System.out.print(nameSend+"nhận");
					
						//if( packet != null) {
							System.out.println("updateUI"); 
							listData.add(packet);
							list.updateUI(); 
						//}
					}
					
				}
			}
		}).start();
		
		list.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				JList theList = (JList) e.getSource(); 

				int index = theList.locationToIndex(e.getPoint()); 
				Packet packetSelect = (Packet)theList.getModel().getElementAt(index);
				GuiContent content  = new  GuiContent(packetSelect);
				content.setVisible(true);
			}
		});
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if( e.getSource().equals(btnSendMail)) {
			Packet packet_send = new Packet(
										new Constant().DEFINE_REQUIRE_SENDMAIL, 
										this.nameSend, txtAdressSend.getText(), 
										txt_Subject.getText(),getDateTime(), 
										text_Content.getText(), null , null
									); 
			client.sendMess(packet_send);
//			Packet packet_send1 = new Packet(this.nameSend, txtAdressSend.getText(), 
//					txt_Subject.getText(),text_Content.getText(), 
//					"ngày", null , null); 
//			listData.add(packet_send);
//			list.updateUI();
			
		}
		if(e.getSource().equals(btnRefesh)) {
			InitGui();
		}
		if(e.getSource().equals(btnMessSend)) {
			getMessSend();
		}
	}
	public void InitGui() {
		listData.removeAllElements();
		Vector<Packet> packet1 = new HandleFile().parseFile(new Constant().LINK_PATH_SERVER + this.nameSend+"\\sendMail.txt"); 
		if(packet1 != null) {
			listData.addAll(packet1);
			list.updateUI();
		}

	}
	public void getMessSend() {
		listData.removeAllElements();
		Vector<Packet> packet1 = new HandleFile().parseFile(new Constant().LINK_PATH_SERVER + this.nameSend+"\\me.txt"); 
		if(packet1 != null) {
			listData.addAll(packet1);
			list.updateUI();
		}
	}
	// get thời gian hiện tại 
	public String getDateTime() {
		String d = String.valueOf( java.time.LocalDate.now());
		String h = String.valueOf(java.time.LocalTime.now());
		String[] timeArr = h.split("\\.");
		System.out.print(h);
		System.out.println(timeArr.length);
		return d + " " + timeArr[0] ; 
	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(txtAdressSend)) {
			if( txtAdressSend.getText().equals("To")) {
				txtAdressSend.setText("");
				txtAdressSend.setForeground(Color.black);
			}
			

			
		}
		if(e.getSource().equals(txt_Subject)) {
			if( txt_Subject.getText().equals("Subject")) {
				txt_Subject.setText("");
				txt_Subject.setForeground(Color.black);
			}
			
		}
		if(e.getSource().equals(text_Content)) {
			if( text_Content.getText().equals("Content")) {
				text_Content.setText("");
				text_Content.setForeground(Color.black);
			}

		}

	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(txtAdressSend)) {
			if( txtAdressSend.getText().equals("")) {
				txtAdressSend.setText("To");
				txtAdressSend.setForeground(Color.gray);
			}	
		}
		if(e.getSource().equals(txt_Subject)) {
			if( txt_Subject.getText().equals("")) {
				txt_Subject.setText("Subject");
				txt_Subject.setForeground(Color.gray);
			}
			
		}
		if(e.getSource().equals(text_Content)) {
			if( text_Content.getText().equals("")) {
				text_Content.setText("Content");
				text_Content.setForeground(Color.gray);
			}

		}
	}

}






