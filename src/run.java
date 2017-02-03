import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;

public class run {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		test newtest = new test();
		
		newtest.setup();
		newtest.whenCanSendAndReceivePacket_thenCorrect();
		newtest.tearDown();
		
	}

}
