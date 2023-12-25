package org.backoffice.socketcliente;

import org.backoffice.domains.enums.commands.ServerCommands;
import org.backoffice.domains.enums.ports.ServerPort;
import org.backoffice.service.socketserver.SocketServer;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import static org.backoffice.service.socketserver.SocketServer.SERVER_ADDRESS;

public final class SocketClient
{
    private String clientId;
    private Socket clientSocket;
    private DataOutputStream out;
    private Scanner in;

    public SocketClient(ServerPort serverPortNumber, String clientId)
    {
        try
        {
            this.clientId = "[ "+ clientId + " ] ";
            clientSocket = new Socket(SERVER_ADDRESS, serverPortNumber.getPortNumber());
            out = new DataOutputStream(clientSocket.getOutputStream());
            in = new Scanner(System.in);
            writeMessage();
            closeClientSocket();
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

    private void writeMessage()
    {
        try
        {
            while (true)
            {
                final String line = in.nextLine();
                if(line.equals(ServerCommands.STOP_COMMUNICATION.getCommand())) return;
                out.writeUTF(clientId + line);
            }
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

    private void closeClientSocket() throws IOException
    {
        clientSocket.close();
        in.close();
        out.close();
    }
}
