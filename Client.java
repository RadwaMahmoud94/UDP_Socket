import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;


public class Client {

	public static void main(String[] args) {
		try {
			DatagramSocket clicentsocket=new DatagramSocket();
			Scanner scanner=new Scanner(System.in);
			while(true) {	
				System.out.println("Enter your request or close");
				String request=scanner.nextLine();
				if(request.equalsIgnoreCase("close")) {
					clicentsocket.close();
					System.out.println("client is terminated ");
		
					break;
				}
				else {
					byte[] requestbytes= request.getBytes();
					int length=requestbytes.length;
					InetAddress IP=InetAddress.getByName("Localhost");
					int serverport= 4000;
					DatagramPacket requestpacket=new DatagramPacket(requestbytes, length, IP, serverport);
					clicentsocket.send(requestpacket);
					byte[] buff=new byte[5000];
					DatagramPacket replypacket= new DatagramPacket(buff,buff.length );
					clicentsocket.receive(replypacket);
					String reply=new String (replypacket.getData());
					System.out.println("Server reply"+reply.trim());
					
				}
			}
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
