package org.backoffice;

import org.backoffice.domains.enums.ports.ServerPort;
import org.backoffice.service.socketcliente.SocketClient;

public class Client2Test
{
    public static void main(String[] args)
    {
        new SocketClient(ServerPort.P_8080, "Daniela Mota");
    }
}
