package org.backoffice.service.socketserver;

import org.backoffice.domains.enums.ports.ServerPort;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public final class SocketServer
{
    public static final String SERVER_ADDRESS = "127.0.0.1";
    public static final String STOP_COMMUNICATION = "##";

    public SocketServer(ServerPort serverPortNumber)
    {
        initialize(serverPortNumber);
    }

    private void initialize(ServerPort serverPortNumber)
    {
        try
        {
            try (ServerSocket serverSocket = new ServerSocket(serverPortNumber.getPortNumber()))
            {
                do
                {
                    Socket clientSocket = serverSocket.accept();
                    new Handler(clientSocket).start();
                }
                while (true);
            }
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}
