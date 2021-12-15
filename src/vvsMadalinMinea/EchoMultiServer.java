package vvsMadalinMinea;

import java.net.*;
import java.io.*;


public class EchoMultiServer extends JavaGUI {
    private ServerSocket serverSocket;

    public void start(int port) throws IOException {
    	createGUI(null);
        serverSocket = new ServerSocket(port);
        while (true)
            new EchoClientHandler(serverSocket.accept()).start();
    }

    public void stop() throws IOException {
        serverSocket.close();
    }

    private static class EchoClientHandler extends Thread {
        private Socket clientSocket;
        private PrintWriter out;
        private BufferedReader in;

        public EchoClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        public void run() {
            try {
				out = new PrintWriter(clientSocket.getOutputStream(), true);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            try {
				in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
            String inputLine;
            try {
				while ((inputLine = in.readLine()) != null) {
				    if (".".equals(inputLine)) {
				        out.println("bye");
				        break;
				    }
				    out.println(inputLine);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

            try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            out.close();
            try {
				clientSocket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }
        public static void main(String[] args) throws IOException {
            EchoMultiServer server = new EchoMultiServer();
            server.start(5555);
        }

}
}
