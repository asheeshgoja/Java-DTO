package fulfillmentCenter.serviceInterface;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpIpChannel {
	
    ServerSocket _socket = null;
    BufferedReader _inFromClient  = null;
    DataOutputStream _outToClient = null;
   
	public TcpIpChannel()
	{
		try {
			_socket = new ServerSocket(1111);
            System.out.println("Server started on port 1111");			
 		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void Send(String message)
	{	
		try {
			_outToClient.writeBytes(message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String Recieve()
	{
          try 
          {
			  Socket connectionSocket = _socket.accept();
			_inFromClient  = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
			  _outToClient = new DataOutputStream(connectionSocket.getOutputStream());
			return _inFromClient.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;   
	}
	
	
	
}
