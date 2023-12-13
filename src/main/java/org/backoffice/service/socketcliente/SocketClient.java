package org.backoffice.service.socketcliente;

import org.backoffice.domains.enums.ports.ServerPort;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import static org.backoffice.service.socketserver.SocketServer.SERVER_ADDRESS;

public final class SocketClient implements Runnable
{
    private final ServerPort serverPortNumber;
    private final String message;
    public SocketClient(ServerPort serverPortNumber, String message) {
        this.serverPortNumber = serverPortNumber;
        this.message = message;
    }

    public void clientTest()
    {
        try
        {
            Socket socket = new Socket(SERVER_ADDRESS, serverPortNumber.getPortNumber());
            System.out.println(Thread.currentThread().getName() + " Connected to server: " + socket.getInetAddress());
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println(message);
            out.close();
            socket.close();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        clientTest();
    }
}
