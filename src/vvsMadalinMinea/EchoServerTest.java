package vvsMadalinMinea;

import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.Before;
import java.io.IOException;
import java.net.UnknownHostException;
import org.junit.Test;

public class EchoServerTest {
	
	EchoClient client;
	
	
	@Before
	public void setup() throws UnknownHostException, IOException {
	    client = new EchoClient();
	    client.startConnection("127.0.0.1", 5555);
	}
	@After
	public void tearDown() throws IOException {
	    
		client.stopConnection();
	}
	@Test
	public void givenClient_whenServerEchosMessage_thenCorrect() throws IOException {
	   
		String resp1 = client.sendMessage("hello");
	    String resp2 = client.sendMessage("world");
	    String resp3 = client.sendMessage("!");
	    String resp4 = client.sendMessage(".");
	    
	    assertEquals("hello", resp1);
	    assertEquals("world", resp2);
	    assertEquals("!", resp3);
	    assertEquals("good bye", resp4);
	}
	
	
	
	}


