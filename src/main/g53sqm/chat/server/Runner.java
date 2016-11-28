package g53sqm.chat.server;

import java.io.IOException;

public class Runner {
	static Server server;
	final static int PORT = 9090;

	public static void main(String[] args) {
		server = new Server(PORT);
		try {
			server.initializeSocketServer();
			server.run();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
