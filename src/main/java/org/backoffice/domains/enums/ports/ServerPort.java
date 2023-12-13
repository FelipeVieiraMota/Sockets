package org.backoffice.domains.enums.ports;

public enum ServerPort
{
    P_80(80),
    P_8080(8080);
    private final int portNumber;
    ServerPort(int portNumber)
    {
        this.portNumber = portNumber;
    }

    public int getPortNumber()
    {
        return portNumber;
    }
}
