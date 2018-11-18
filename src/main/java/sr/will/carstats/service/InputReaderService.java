package sr.will.carstats.service;

import sr.will.carstats.CarStats;
import sr.will.carstats.manager.CommandConsoleManager;

public class InputReaderService extends Thread {
    private CommandConsoleManager commandConsoleManager;

    public InputReaderService(CommandConsoleManager commandConsoleManager) {
        this.commandConsoleManager = commandConsoleManager;
    }

    public void run() {
        setName("InputReader");
        CarStats.getLogger().info("Input reader thread started");
        while (true) {
            String string;
            string = System.console().readLine();

            if (string != null) {
                commandConsoleManager.executeCommand(string);
            }
        }
    }
}

