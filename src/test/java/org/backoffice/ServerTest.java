package org.backoffice;


import org.backoffice.domains.enums.ports.ServerPort;
import org.backoffice.service.socketserver.SocketServer;

public class ServerTest
{
    public static void main( String[] args )
    {
        new SocketServer(ServerPort.P_8080);
    }
}
