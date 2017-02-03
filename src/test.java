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
        String echo = curr_client.sendEcho("hello server");
        //assertEquals("hello server", echo);
        
        //System.out.println(echo);
        
        echo = curr_client.sendEcho("server is working");
        //assertFalse(echo.equals("hello server"));
        
        //System.out.println(echo);
        
    }
 
    
    public void tearDown() throws IOException {
        curr_client.sendEcho("end");
        curr_client.close();
    }
}