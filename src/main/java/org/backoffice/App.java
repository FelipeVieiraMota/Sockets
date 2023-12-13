package org.backoffice;


import org.backoffice.domains.enums.ports.Port;
import org.backoffice.service.socketcliente.SocketClient;
import org.backoffice.service.socketserver.SocketServer;

public class App
{
    private static final Port port = Port.P_8080;

    public static void main( String[] args )
    {
        new SocketServer(port).serverTest();
    }
}
