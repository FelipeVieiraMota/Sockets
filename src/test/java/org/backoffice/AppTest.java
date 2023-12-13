package org.backoffice;

import org.backoffice.domains.enums.ports.Port;
import org.backoffice.service.socketcliente.SocketClient;

public class AppTest
{
    private static final Port port = Port.P_8080;

    public static void main(String[] args)
    {
        final String message = " Hello world! ";
        new SocketClient(port, message).clientTest();
    }
}
