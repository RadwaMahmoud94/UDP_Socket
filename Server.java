import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class Server {

	public static void main(String[] args) {
		try {
			
			
			DatagramSocket ServerSocket=new DatagramSocket();
			Scanner scanner=new Scanner(System.in);
			DatagramSocket serversocket= new DatagramSocket();

			System.out.println("Server is booted up");
			
			session serversession = new session(serversocket);
			serversession.start();
			
			
	
			
			
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
