package org.backoffice.service.socketserver;

import org.backoffice.domains.enums.commands.ServerCommands;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Handler implements Runnable
{
    private final Socket clientSocket;

    public Handler(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run()
    {
        execute();
    }

    private void execute()
    {
        try
        {
            var in = new DataInputStream(new BufferedInputStream(clientSocket.getInputStream()));
            var clientMessage = "";
            while (!clientMessage.equals(ServerCommands.STOP_COMMUNICATION.getCommand()))
            {
                clientMessage = in.readUTF();
                System.out.println(clientMessage);
            }
            in.close();
            clientSocket.close();
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
