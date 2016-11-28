package g53sqm.chat.server;

import java.net.Socket;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ConnectionTest {
	
	@Test
	public void testThatConnectionCanBeCreated() {
		Server serverMock = Mockito.mock(Server.class);
		assertNotNull(serverMock);
		Socket socketMock = Mockito.mock(Socket.class);
		assertNotNull(socketMock);

		Connection connection = new Connection(socketMock,serverMock);
		assertNotNull(connection);
	}
	
	@Test
	public void testThatNewConnectionGetStateUnregistered() {
		Server serverMock = Mockito.mock(Server.class);
		assertNotNull(serverMock);
		Socket socketMock = Mockito.mock(Socket.class);
		assertNotNull(socketMock);

		Connection connection = new Connection(socketMock,serverMock);
		assertNotNull(connection);
		assertEquals(Connection.STATE_UNREGISTERED,connection.getState());
	}

	@Test
	public void testThatNewConnectionGetUserNameNull() {
		Server serverMock = Mockito.mock(Server.class);
		assertNotNull(serverMock);
		Socket socketMock = Mockito.mock(Socket.class);
		assertNotNull(socketMock);

		Connection connection = new Connection(socketMock,serverMock);
		assertNotNull(connection);
		assertNull(connection.getUserName());
	}
	
}
