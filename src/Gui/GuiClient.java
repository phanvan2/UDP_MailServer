package Gui;

import java.awt.BorderLayout;
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
import Class.Packet;
import constant.Constant;

import javax.swing.JList;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;

public class GuiClient extends JFrame implements ActionListener {

	private JPanel contentPane;
	private Vector<Packet> listData = new Vector<Packet>();

	private Vector<Packet> listData1 = new Vector<Packet>();
	private JTextField txtAdressSend;
	private JTextField txt_Subject;
	private JButton btnSendMail ; 
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
					GuiClient frame = new GuiClient("duc");
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
		
		
		
		 list = new JList(listData);
		listData.add(new Packet("phan","",  "phjfl", "jlskadjf", "Jlkjsf", null, null)); 
		listData.add(new Packet("phan","",  "phjfl", "jlskadjf", "Jlkjsf", null, null)); 
		listData.add(new Packet("phan","",  "phjfl", "jlskadjf", "Jlkjsf", null, null)); 



		list.updateUI();
		
		
		list.setCellRenderer(new CustomCell());
		
		
		

		JList list1 = new JList(listData);
		listData.add(new Packet("phan","",  "phjfl", "jlskadjf", "Jlkjsf", null, null)); 

		list1.updateUI();
		list1.setCellRenderer(new CustomCell());
		
		
		JScrollPane scroll  = new JScrollPane(list);
	
		scroll.setPreferredSize(getPreferredSize());
		scroll.createVerticalScrollBar();
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		contentPane.add(scroll, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new GridLayout(5, 1));
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
			}
		});
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("New button");
		panel_1.add(btnNewButton);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("\u1EA3nh user");
		panel_2.add(lblNewLabel);
		
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
		
		txtAdressSend = new JTextField();
		panel_3.add(txtAdressSend);
		txtAdressSend.setColumns(10);
		
		txt_Subject = new JTextField();
		panel_3.add(txt_Subject);
		txt_Subject.setColumns(10);
		
		text_Content = new JTextArea();
		panel_3.add(text_Content);
		
		btnSendMail = new JButton("Send");
		panel.add(btnSendMail, BorderLayout.SOUTH);
		btnSendMail.addActionListener(this);
		client = new Client() ;
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true) {
					if( client.receiveMess() != null) {
						Packet packet  =  client.receiveMess(); 
						listData.add(packet);
						list.updateUI(); 
					}
				}
			}
		}).start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if( e.getSource().equals(btnSendMail)) {
			Packet packet_send = new Packet(
										new Constant().DEFINE_REQUIRE_SENDMAIL, 
										this.nameSend, txtAdressSend.getText(), 
										txt_Subject.getText(),text_Content.getText(), 
										"ngày", null , null
									); 
			client.sendMess(packet_send);
		}
	}

}

class ContentCell implements ListCellRenderer{
	boolean ok = true ;
	int index1 = -1; 
	@Override
	public JPanel getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,boolean cellHasFocus) {
		// TODO Auto-generated method stub
		Packet packet = (Packet)value;
		JPanel panel = new JPanel();
		JTextArea text = new JTextArea("xin àljasdlkf"); 
		panel.add(text); 
		return panel;

	}
	
	
	
}




