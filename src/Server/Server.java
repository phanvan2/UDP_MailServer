package Server;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;

import java.net.DatagramSocket;

import java.net.InetAddress;
import java.net.SocketException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import constant.Constant;

public class Server {
	String path = "D:\\new_email" ; 
	DatagramSocket socket ; 
	int port = new Constant().PORT;
	
	public Server() {
		 //khởi động udp server với port 8000

        try {
			socket = new DatagramSocket(port); 
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

       System.out.println("server is running");

       receive_send_mess();

      
	}
    public static void main(String args[]) throws Exception {
    	new Server(); 
    	
    }
    public void registerServer() {
    	
    }
    public void loginServer() {
    	
    }
    public void receive_send_mess() {
    	  //tạo chuỗi byte
    	
        byte[] inServer = new byte[1024];

        byte[] outServer = new byte[1024];

        //tạo packet nhận dữ liệu

        DatagramPacket rcvPkt = new DatagramPacket(inServer, inServer.length);
    	 while (true) {

             // chờ nhận dữ liệu từ client

             try {
  			socket.receive(rcvPkt);
  		} catch (IOException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}

             System.out.println("Packet Received!");

             System.out.println("ip Address!" + rcvPkt.getAddress());

             System.out.println("port!" + rcvPkt.getPort());

             System.out.println("message Received!" + new String(rcvPkt.getData()));

            
             InetAddress IP = rcvPkt.getAddress();

             int port = rcvPkt.getPort();
             
             // tạo thư muc
             CreateDirectory(path);
             createFile(path+"\\new_email.txt");
             writeFile(path+"\\new_email.txt"); 
             //lấy dữ liệu nhận và gửi dữ liệu lại cho client

             String temp = new String(rcvPkt.getData());

             temp = "server :" + temp.toUpperCase();

             outServer = temp.getBytes();

             //gửi dữ liệu lại cho client

             DatagramPacket sndPkt = new DatagramPacket(outServer, outServer.length, IP, port);
             
             try {
  			socket.send(sndPkt);
  		} catch (IOException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}

         }
    }
    
    public void CreateDirectory(String path) {
    	try {
    	  	File x = new File(path);
	  		  if (!x.exists()) {
	  	            if ( x.mkdir()) {
	  	                System.out.println("Thư mục đã được tạo!");
	  	                
	  	            } else {
	  	                System.out.println("Có lỗi xảy ra!");
	  	            }
	  	            path = path + "\\new_email.txt";
	  	            
	  	        }
	  		Scanner sc = new Scanner(x);
	  		String content = "";
	  		while (sc.hasNextLine()) {
	  			content += sc.nextLine() + "\r\n";
	  		}
	  		System.out.println("\n"+content);
		} catch (Exception e) {
			// TODO: handle exception
		}
  
    }
    public void createFile(String path) {
    	File file = new File(path);
    	try {
			if( file.createNewFile()) {
				System.out.println("Tạo file thành côcng");
			}else {
				System.out.println("lỗi rồi ");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public void writeFile(String path) {
    	try {
			FileOutputStream file = new FileOutputStream(path);
			String string = "Thank you for using this service. we hope that you will feel comfortable........";
			byte[] a = string.getBytes(); // ep kieu String ve mang byte
		
			file.write(a); // ghi mang byte vao file
			System.out.print("Da ghi thanh cong!");
			file.close();
		} catch (Exception e2) {
			System.out.print(e2);// In lỗi ra màn hình
		}
    }

}