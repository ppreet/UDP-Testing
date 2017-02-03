import java.net.*;
import java.io.*;

public class server extends Thread {
 
    private DatagramSocket socket;
    private boolean running;
    private byte[] buf = new byte[256];
 
    public server() throws SocketException {
        socket = new DatagramSocket(4444);
    }
 
    public void run(){
        running = true;
 
        while (running) {
            DatagramPacket packet 
              = new DatagramPacket(buf, buf.length);
            try {
				socket.receive(packet);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
             
            InetAddress address = packet.getAddress();
            int port = packet.getPort();
            packet = new DatagramPacket(buf, buf.length, address, port);
            String received 
              = new String(packet.getData(), 0, packet.getLength());
            
            if (received.equals("end")) {
                running = false;
                continue;
            }
            
            //Send confirmation again
            try {
            	
            	String conf_msg = "Message received: ";
            	byte[] buffer = conf_msg.getBytes();
            	DatagramPacket conf 
                = new DatagramPacket(buffer, buffer.length, address, port);
            	
            	socket.send(conf);
            	socket.send(packet);
            	
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        socket.close();
    }
}