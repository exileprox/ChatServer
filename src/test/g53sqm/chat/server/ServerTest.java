package g53sqm.chat.server;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ServerTest {
	
	@Test
	public void testThatServerCanBeCreated() {
		Server server = new Server(9090);
		assertNotNull(server);

	}
	
	@Test(expected=java.net.BindException.class)
	public void testThatServerCannotBeCreatedWhenPortIsUsed() throws IOException {
		Server server = new Server(9091);
		server.initializeSocketServer();
		Server server2 = new Server(9091);
		server.initializeSocketServer();
	}
	
	@Test
	public void testThatServerHasEmptyUserListWhenCreated() {
		Server server = new Server(9092);
		try {
			server.initializeSocketServer();
		} catch (IOException e) {
		}
		assertNotNull(server);
		assertEquals(0, server.getNumberOfUsers());
	}
	
	@Test
	public void testThatServerSendPrivateMessageFailsWhenNoUser() {
		Server server = new Server(9093);
		try {
			server.initializeSocketServer();
		} catch (IOException e) {
			e.printStackTrace();
		}
		assertNotNull(server);
		assertEquals(0, server.getNumberOfUsers());
		boolean result = server.sendPrivateMessage("hello", "chris");
		assertEquals(false,result);
	}
	
	@Test
	public void testThatServerWhenUserNotExistCannotFindUser() {
		Server server = new Server(9094);
		try {
			server.initializeSocketServer();
		} catch (IOException e) {
			e.printStackTrace();
		}
		assertNotNull(server);
		assertEquals(0, server.getNumberOfUsers());
		boolean result = server.doesUserExist("Chris");
		assertEquals(false,result);
	}
	
	@Test(expected=java.lang.IllegalArgumentException.class)
	public void testThatServerPortCannotBeNegative(){
		Server server = new Server(-1);
		try {
			server.initializeSocketServer();
		} catch (IOException e) {
		}
	}
}
