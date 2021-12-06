package vvsMadalinMinea;



import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.UnknownHostException;
import org.junit.Test;

public class EchoMultiServerTest {

	@Test
	public void givenClient1_whenServerResponds_thenCorrect() throws UnknownHostException, IOException {
	    EchoClient client1 = new EchoClient();
	    client1.startConnection("127.0.0.1", 5555);
	    String msg1 = client1.sendMessage("hello");
	    String msg2 = client1.sendMessage("world");
	    String terminate = client1.sendMessage(".");
	    
	    assertEquals(msg1, "hello");
	    assertEquals(msg2, "world");
	    assertEquals(terminate, "bye");
	}

	@Test
	public void givenClient2_whenServerResponds_thenCorrect() throws UnknownHostException, IOException {
	    EchoClient client2 = new EchoClient();
	    client2.startConnection("127.0.0.1", 5555);
	    String msg1 = client2.sendMessage("hello");
	    String msg2 = client2.sendMessage("world");
	    String terminate = client2.sendMessage(".");
	    
	    assertEquals(msg1, "hello");
	    assertEquals(msg2, "world");
	    assertEquals(terminate, "bye");
	}

}
