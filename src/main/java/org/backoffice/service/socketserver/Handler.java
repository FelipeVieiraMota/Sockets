package org.backoffice.service.socketserver;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Handler extends Thread
{
    private DataInputStream in;
    private final Socket clientSocket;

    public Handler(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run()
    {
        try
        {
            // Set up input stream to read data from the client
            in = new DataInputStream(new BufferedInputStream(clientSocket.getInputStream()));

            // Read data from the client and send a response
            String clientMessage = "";
            while (!clientMessage.equals(SocketServer.STOP_COMMUNICATION))
            {
                clientMessage = in.readUTF();
                System.out.println(clientMessage);
            }

            close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private void close() throws IOException {
        in.close();
        clientSocket.close();
    }
}
