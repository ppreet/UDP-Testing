import java.io.IOException;
import java.lang.Object;
import java.net.SocketException;
import java.net.UnknownHostException;
import static org.junit.Assert.*;

public class test {
    client curr_client;
 
    public void setup() throws SocketException, UnknownHostException{
        new server().start();
        curr_client = new client();
    }
 
    
    public void whenCanSendAndReceivePacket_thenCorrect() throws IOException {
        
    	
    	String echo = curr_client.sendEcho("THIS IS NOT VERY EXCITING");
      
        echo = curr_client.sendEcho(" CSE $$$$$$");
        
    }
 
    
    public void tearDown() throws IOException {
        curr_client.sendEcho("end");
        curr_client.close();
    }
}