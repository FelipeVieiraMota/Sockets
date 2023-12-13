package org.backoffice;


import org.backoffice.domains.enums.ports.ServerPort;
import org.backoffice.service.socketserver.SocketServer;

public class App
{
    private static final ServerPort SERVER_PORT = ServerPort.P_8080;

    public static void main( String[] args )
    {
        new SocketServer(SERVER_PORT).serverTest();
    }
}
