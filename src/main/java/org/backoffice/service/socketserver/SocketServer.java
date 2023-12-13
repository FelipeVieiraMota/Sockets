package org.backoffice.service.socketserver;

import org.backoffice.domains.enums.ports.ServerPort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public final class SocketServer implements Runnable
{
    public static final String SERVER_ADDRESS = "localhost";
    private final ServerPort serverPortNumber;

    public SocketServer(ServerPort serverPortNumber) {
        this.serverPortNumber = serverPortNumber;
    }

    public void serverTest()
    {
        try
        {
            ServerSocket serverSocket = new ServerSocket(serverPortNumber.getPortNumber());
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket.getInetAddress());
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String clientMessage;

            while ((clientMessage = in.readLine()) != null)
            {
                System.out.println("Received from client: " + clientMessage);
            }

            System.out.println("Client disconnected: " + clientSocket.getInetAddress());
            in.close();
            clientSocket.close();
            serverSocket.close();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        serverTest();
    }
}
