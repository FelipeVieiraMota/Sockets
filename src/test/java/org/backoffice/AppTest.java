package org.backoffice;

import org.backoffice.domains.enums.ports.ServerPort;
import org.backoffice.service.socketcliente.SocketClient;

public class AppTest
{
    private static final ServerPort SERVER_PORT = ServerPort.P_8080;

    public static void main(String[] args)
    {
        final String message = " Hello world! ";
        new SocketClient(SERVER_PORT, message).clientTest();
    }
}
