package Server;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;

import java.net.DatagramSocket;

import java.net.InetAddress;
import java.net.SocketException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import Class.HandleFile;
import Class.Packet;
import constant.Constant;

public class Server {
	String path = "D:\\new_email" ; 
	DatagramSocket socket ; 
	int port = new Constant().PORT;
	byte[] byte_recerive = new byte[1024]; 
	DatagramPacket datagramPacket_receive ; 
	Constant constant = new Constant();
	HandleFile handleFile = new HandleFile();
	public Server() {
	

        try {
			socket = new DatagramSocket(port); 
			datagramPacket_receive = new DatagramPacket(byte_recerive, byte_recerive.length); 
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

       System.out.println("server is running");
       new Thread(new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true) {
			       receiveMail();

			}
		}
	}).start(); 

      
	}
    public static void main(String args[]) throws Exception {
    	new Server(); 
    	
    }
    

    public void receiveMail() {
    	try {
			socket.receive(datagramPacket_receive);
			Packet packet_receive = (Packet)deserialize(datagramPacket_receive.getData()); 
			int require = packet_receive.getDefine_require(); 
			
			if( require == constant.DEFINE_REQUIRE_LOGIN ) {
				
			}
			if( require == constant.DEFINE_REQUIRE_REGISTER) {
				registerServer(packet_receive.getName());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    public void registerServer(String name) {
    	String[] arr = name.split(constant.SPLIT_S);
    	System.out.println(arr.length); 
    	if( !handleFile.checkFileExist(constant.LINK_PATH_SERVER +"" + arr[0])) {
    		handleFile.CreateDirectory(constant.LINK_PATH_SERVER, arr[0]);
    		handleFile.createFile(constant.LINK_PATH_SERVER +"" + arr[0], "newEmail.txt");
    	}
    	
    }
    public void loginServer() {
    	
    }

    
    public static byte[] serialize(Object obj) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream(out);
        os.writeObject(obj);
        return out.toByteArray();
    }
    public static Object deserialize(byte[] data) throws IOException, ClassNotFoundException {
        ByteArrayInputStream in = new ByteArrayInputStream(data);
        ObjectInputStream is = new ObjectInputStream(in);
        return is.readObject();
    }
}