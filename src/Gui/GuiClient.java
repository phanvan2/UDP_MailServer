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

import Class.CustomCell;
import Class.Packet;

import javax.swing.JList;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class GuiClient extends JFrame {

	private JPanel contentPane;
	private Vector<Packet> listData = new Vector<Packet>();

	private Vector<Packet> listData1 = new Vector<Packet>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiClient frame = new GuiClient();
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
	public GuiClient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 842, 567);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		
		
		JList list = new JList(listData);
		listData.add(new Packet("phan", "phjfl", "jlskadjf", "Jlkjsf", null, null)); 
		listData.add(new Packet("phan", "phjfl", "jlskadjf", "Jlkjsf", null, null)); 

		listData.add(new Packet("phan", "phjfl", "jlskadjf", "Jlkjsf", null, null));
		listData.add(new Packet("phan", "phjfl", "jlskadjf", "Jlkjsf", null, null)); 
		listData.add(new Packet("phan", "phjfl", "jlskadjf", "Jlkjsf", null, null)); 



		list.updateUI();
		
		
		list.setCellRenderer(new CustomCell());
		
		
		

		JList list1 = new JList(listData);
		listData1.add(new Packet("phan", "phjfl", "jlskadjf", "Jlkjsf", null, null)); 
		listData1.add(new Packet("phan", "phjfl", "jlskadjf", "Jlkjsf", null, null)); 
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
		
		JLabel lblNewLabel_1 = new JLabel("Phan van");
		panel_2.add(lblNewLabel_1);
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




