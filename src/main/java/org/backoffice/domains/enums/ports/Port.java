package org.backoffice.domains.enums.ports;

public enum Port
{
    P_80(80),
    P_8080(8080);
    private final int portNumber;
    Port(int portNumber)
    {
        this.portNumber = portNumber;
    }

    public int getPortNumber()
    {
        return portNumber;
    }
}
