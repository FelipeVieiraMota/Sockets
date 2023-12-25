package org.backoffice;

import org.backoffice.domains.enums.services.SocketServerEnum;
import org.backoffice.factory.Factory;

public class ServerStart {
    public static void main( String[] args )
    {
        new Factory().getInstance(SocketServerEnum.ALL_ARGS);
    }
}
