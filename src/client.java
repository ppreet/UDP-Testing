import java.io.*;
import java.net.*;

public class client {
    private DatagramSocket socket;
    private InetAddress address;
 
    private byte[] buf;
    private byte[] conf = new byte[65537];
 
    public client() throws SocketException, UnknownHostException {
        socket = new DatagramSocket();
        address = InetAddress.getByName("localhost");
    }
 
    public String sendEcho(String msg) throws IOException {
        buf = msg.getBytes();
        DatagramPacket packet 
          = new DatagramPacket(buf, buf.length, address, 4444);
        socket.send(packet);
        
        packet = new DatagramPacket(conf, conf.length);
        socket.receive(packet);
        String received = new String(
          packet.getData(), 0, packet.getLength());
        
        packet = new DatagramPacket(buf, buf.length);
        socket.receive(packet);
        String received2 = new String(
          packet.getData(), 0, packet.getLength());
        
        System.out.println(received + received2);
        return received + received2;
    }
 
    public void close() {
        socket.close();
    }
}