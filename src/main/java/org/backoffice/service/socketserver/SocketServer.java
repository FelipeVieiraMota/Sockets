package org.backoffice.service.socketserver;

import org.backoffice.domains.enums.ports.ServerPort;

import java.io.*;
import java.net.ServerSocket;
import java.util.Date;

public final class SocketServer
{
    public static final String SERVER_ADDRESS = "127.0.0.1";

    public SocketServer(ServerPort serverPortNumber)
    {
        if(serverPortNumber == null) 
            serverPortNumber = ServerPort.P_8080;
        
        System.out.println("********************************");
        System.out.println(new Date() + " Server initialized at " + SERVER_ADDRESS);
        System.out.println("********************************\n\n");
        initialize(serverPortNumber.getPortNumber());
    }

    private void initialize(int serverPortNumber)
    {
        try (ServerSocket serverSocket = new ServerSocket(serverPortNumber))
        {
            while(true)
            {
                new Thread(new Handler(serverSocket.accept())).start();
                System.out.println(new Date() + " New connection from " + serverSocket.getInetAddress() + ":" + serverSocket.getLocalPort() + " established...");
            }
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public static String getServerAddress() throws FileNotFoundException {
        var xml = new File("serverproperties.xml");
        return null;
    }

    public static void main(String[] args) throws FileNotFoundException {
        getServerAddress();
    }
}