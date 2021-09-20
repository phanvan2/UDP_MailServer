package Gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.rmi.Naming;
import java.security.MessageDigest;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;


public class GuiRegister extends JFrame implements FocusListener {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JPasswordField txtCofirmPassword;
	private boolean iconPassConfirm = true, iconPass = true ; // hidden 
	private ImageIcon imageIcon_show, imageIcon_hidden ; 
	JLabel lblWarningUsername; 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiRegister frame = new GuiRegister();
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
	public GuiRegister() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 450, 300);
		setLocation(550, 200);
		setTitle("RMI");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		try {// set icon giao dien---------------------------
			Image iconmes = ImageIO.read(new File("D:\\download\\logo_rmi2.jpg"));
			this.setIconImage(iconmes); 
		} catch (IOException e1) {
			// TODO Auto-generated catch block
		
		}
		
		JLabel lblNewLabel = new JLabel("REGISTER");
		lblNewLabel.setForeground(new Color(0, 128, 0));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lbUsername = new JLabel("Username:");
		lbUsername.setForeground(new Color(0, 128, 0));
		lbUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbUsername.setBounds(36, 32, 109, 31);
		panel.add(lbUsername);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(202, 37, 164, 26);
		txtUsername.setHorizontalAlignment(JTextField.CENTER);
		txtUsername.addFocusListener(this);
		panel.add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lbPassword = new JLabel("Password:");
		lbPassword.setForeground(new Color(0, 128, 0));
		lbPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbPassword.setBounds(36, 84, 128, 22);
		panel.add(lbPassword);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(202, 85, 164, 25);
		txtPassword.setHorizontalAlignment(JTextField.CENTER);
		txtPassword.setText("Type your password");
		txtPassword.setForeground(Color.gray);
		txtPassword.setEchoChar('\0');
		txtPassword.addFocusListener(this);
		panel.add(txtPassword);
		txtPassword.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("confirm passord");
		lblNewLabel_3.setForeground(new Color(0, 128, 0));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(36, 131, 140, 18);
		panel.add(lblNewLabel_3);
		
		txtCofirmPassword = new JPasswordField();
		txtCofirmPassword.setBounds(202, 130, 164, 25);
		txtCofirmPassword.setHorizontalAlignment(JTextField.CENTER);
		txtCofirmPassword.setText("Type your confirm password");
		txtCofirmPassword.setForeground(Color.gray);
		txtCofirmPassword.setEchoChar('\0');
		txtCofirmPassword.addFocusListener(this);
		panel.add(txtCofirmPassword);
		txtCofirmPassword.setColumns(10);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setForeground(new Color(0, 128, 0));
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRegister.setBounds(162, 179, 85, 21);
		panel.add(btnRegister);
		
		JLabel lblLogin = new JLabel("login");
		lblLogin.setBounds(337, 165, 45, 13);
		panel.add(lblLogin);
		
		JLabel lblIconCofirmPass = new JLabel("");
		lblIconCofirmPass.setBounds(376, 137, 21, 15);
		
		JLabel lblIconPass = new JLabel("");
		lblIconPass.setBounds(376, 91, 21, 15);
		try {
			BufferedImage bufferImage = ImageIO.read(new File("D:\\download\\eye-look.png"));
			imageIcon_show = new ImageIcon(bufferImage.getScaledInstance(21, 15, Image.SCALE_SMOOTH));
			
			BufferedImage bufferImage_hidden = ImageIO.read(new File("D:\\download\\hide-private-hidden.png"));
			imageIcon_hidden = new ImageIcon(bufferImage_hidden.getScaledInstance(21, 15, Image.SCALE_SMOOTH));
			lblIconCofirmPass.setIcon(imageIcon_hidden);
			lblIconPass.setIcon(imageIcon_hidden);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		lblIconCofirmPass.addMouseListener(new MouseListener() {
			
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
				if(iconPassConfirm) {
					lblIconCofirmPass.setIcon(imageIcon_show) ;
					iconPassConfirm = !iconPassConfirm; 
					txtCofirmPassword.setEchoChar('\0'); 
				}else {
					lblIconCofirmPass.setIcon(imageIcon_hidden) ; 
					iconPassConfirm = !iconPassConfirm; 
					if (txtCofirmPassword.getText().equals("Type your confirm password")) {
						txtCofirmPassword.setEchoChar('\0'); 
					}else {
						txtCofirmPassword.setEchoChar('*'); 
					}
				}

				
			}
		});
		
		lblIconPass.addMouseListener(new MouseListener() {
			
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
				if(iconPass) {
					lblIconPass.setIcon(imageIcon_show) ;
					iconPass = !iconPass; 
					txtPassword.setEchoChar('\0'); 
				}else {
					lblIconPass.setIcon(imageIcon_hidden) ; 
					iconPass = !iconPass; 
					if (txtPassword.getText().equals("Type your password")) {
						txtPassword.setEchoChar('\0'); 
					}else {
						txtPassword.setEchoChar('*'); 
					}
				}

				
			}
		});
		panel.add(lblIconCofirmPass); 
		panel.add(lblIconPass);
		
		lblWarningUsername = new JLabel("username already in use");
		lblWarningUsername.setForeground(Color.RED);
		lblWarningUsername.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblWarningUsername.setBounds(202, 25, 180, 13);
		lblWarningUsername.setVisible(false);
		panel.add(lblWarningUsername);
		btnRegister.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource().equals(btnRegister)) {
					String username = txtUsername.getText(); 
					String password = txtPassword.getText();
					String confirm_password = txtCofirmPassword.getText(); 
					if( !username.equals("") && !password.equals("") && confirm_password.equals(password)) {
						 
					}else {
						JOptionPane.showMessageDialog(null, "Mời bạn nhập lại!"); 
						txtPassword.setText("");
						txtCofirmPassword.setText("");
					}
					
				}
			}
		});
		
	}
	
	public void checkUsername(String username) {

	}
	
	public String scryptWithMD5(String pass) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
	        byte[] passBytes = pass.getBytes();
	        md.reset();
	        byte[] digested = md.digest(passBytes);
	        StringBuffer sb = new StringBuffer();
	        for(int i=0;i<digested.length;i++){
	            sb.append(Integer.toHexString(0xff & digested[i]));
	        }
	        return sb.toString();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
		return null; 
	}

	
	

	@Override
	public void focusGained(FocusEvent e) {
		
		// TODO Auto-generated method stub
		if(e.getSource().equals(txtUsername)) {
			if(txtUsername.getText().equals("Type your username")) {
				txtUsername.setText("");
				txtUsername.setForeground(Color.black);
			}
		}
		if(e.getSource().equals(txtPassword)) {
			if(txtPassword.getText().equals("Type your password")) {
				txtPassword.setText("");
				txtPassword.setForeground(Color.black);
				txtPassword.setEchoChar('*');
			}
		}
		if(e.getSource().equals(txtCofirmPassword)) {
			if(txtCofirmPassword.getText().equals("Type your confirm password")) {
				txtCofirmPassword.setText("");
				txtCofirmPassword.setForeground(Color.black);
				txtCofirmPassword.setEchoChar('*');

			}
		}
	
	
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
	
		if(e.getSource().equals(txtUsername)) {
			if( txtUsername.getText().equals("")) {
				txtUsername.setText("Type your username");
				txtUsername.setForeground(Color.gray);
			}
			checkUsername(txtUsername.getText());
		}
		if(e.getSource().equals(txtPassword)) {
			if( txtPassword.getText().equals("")) {
				txtPassword.setText("Type your password");
				txtPassword.setForeground(Color.gray);
				txtPassword.setEchoChar('\0');
			}
		}
		if(e.getSource().equals(txtCofirmPassword)) {
			if( txtCofirmPassword.getText().equals("")) {
				txtCofirmPassword.setText("Type your confirm password");
				txtCofirmPassword.setForeground(Color.gray);
				txtCofirmPassword.setEchoChar('\0');

			}
		}
	
	}
}
