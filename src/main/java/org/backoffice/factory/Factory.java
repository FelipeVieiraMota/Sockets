package org.backoffice.factory;

import org.backoffice.domains.enums.services.HandlerEnum;
import org.backoffice.domains.enums.services.SocketServerEnum;
import org.backoffice.service.socketserver.Handler;
import org.backoffice.service.socketserver.SocketServer;

public class Factory
{    
    public SocketServer getInstance(SocketServerEnum param)
    {
        switch (param) 
        {
            case ALL_ARGS:
            case NO_ARGS:
                return new SocketServer(null);
            default: return null;
        }
    }

    public Handler getInstance(HandlerEnum param)
    {
        switch (param)
        {
            case ALL_ARGS:
            case NO_ARGS:
                return new Handler(null);
            default: return null;
        }
    }
}
