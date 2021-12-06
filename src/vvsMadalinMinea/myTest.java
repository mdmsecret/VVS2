
package vvsMadalinMinea;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.UnknownHostException;
import org.junit.Test;


public class myTest {

	@Test
	public void givenGreetingClient_whenServerRespondsWhenStarted_thenCorrect() throws UnknownHostException, IOException {
	    GreetClient client = new GreetClient();
	    client.startConnection("127.0.0.1", 6666);
	    String response = client.sendMessage("hello server");
	    assertEquals("hello client", response);
	    
	    
	}

}
