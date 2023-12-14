package org.backoffice.service.socketserver;

import org.backoffice.domains.enums.commands.ServerCommands;

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
        execute();
    }

    private void execute()
    {
        try
        {
            in = new DataInputStream(new BufferedInputStream(clientSocket.getInputStream()));
            String clientMessage = "";
            while (!clientMessage.equals(ServerCommands.STOP_COMMUNICATION.getCommand()))
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
