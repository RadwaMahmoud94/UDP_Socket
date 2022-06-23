import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;
public class session extends Thread {
	DatagramSocket serversocket;
	public session(DatagramSocket serversocket) {
		this.serversocket=serversocket;
	}
	@Override
	public void run() {
		
		
		DatagramSocket ServerSocket;
		try {
			ServerSocket = new DatagramSocket(4000);
	
		Scanner scanner=new Scanner(System.in);

		while (true) {
			byte[] requestbuff= new byte[1000];
			int length=requestbuff.length;
			DatagramPacket requestpacket=new DatagramPacket(requestbuff, length);
			ServerSocket.receive(requestpacket);
			
			String request=new String(requestpacket.getData());
			System.out.println("clinet"+request.trim());
			String reply=scanner.nextLine();
			
			byte[] replybytes= reply.getBytes();
			int length2=replybytes.length;
			InetAddress clientIP=requestpacket.getAddress();
			int clientport=requestpacket.getPort();
			DatagramPacket recivepacket=new DatagramPacket(replybytes, length2,clientIP,clientport);
			ServerSocket.send(recivepacket);
			
			
		}
		
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
}
