package Class;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DatagramSocket clientSocket;
		try {
			clientSocket = new DatagramSocket();
			InetAddress IPAddress = InetAddress.getByName("localhost");
			byte[] sendData = new byte[1024];
			 byte[] receiveData = new byte[1024];
		     sendData = "getDate".getBytes();
		     
		//tao datagram co noi dung yeu cau loai dl de gui cho server

		DatagramPacket sendPacket = 
		            new DatagramPacket(sendData, sendData.length, IPAddress, 9876);

		clientSocket.send(sendPacket);//gui dl cho server

		//tao datagram rong de nhan dl
		DatagramPacket receivePacket = 
		new DatagramPacket(receiveData, receiveData.length);

		clientSocket.receive(receivePacket);//nhan dl tu server

		String str= new String(receivePacket.getData());//lay dl tu packet nhan duoc
		System.out.println(str);
		clientSocket.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//gan cong dong
		

	}

}
