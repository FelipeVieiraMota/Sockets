package org.backoffice.domains.enums.commands;

public enum ServerCommands
{
    STOP_COMMUNICATION("###");
    private final String command;
    ServerCommands(String command){
        this.command = command;
    }

    public String getCommand(){
        return command;
    }
}
