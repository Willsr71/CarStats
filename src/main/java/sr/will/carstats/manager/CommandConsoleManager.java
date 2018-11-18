package sr.will.carstats.manager;

import sr.will.carstats.CarStats;
import sr.will.carstats.commandconsole.CommandConsole;
import sr.will.carstats.commandconsole.CommandConsoleDebug;
import sr.will.carstats.commandconsole.CommandConsolePID;
import sr.will.carstats.commandconsole.CommandConsoleStop;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CommandConsoleManager {
    private CarStats carStats;

    private HashMap<String, CommandConsole> commands = new HashMap<>();

    public CommandConsoleManager(CarStats carStats) {
        this.carStats = carStats;

        registerCommand("debug", new CommandConsoleDebug(carStats));
        registerCommand("pid", new CommandConsolePID(carStats));
        registerCommand("stop", new CommandConsoleStop(carStats));
    }

    public void registerCommand(String name, CommandConsole command) {
        commands.put(name, command);
    }

    public void executeCommand(String string) {
        if (string.equals("")) {
            return;
        }

        string = string.toLowerCase();
        List<String> parts = Arrays.asList(string.split(" "));

        String command = parts.get(0);
        String[] args = parts.subList(1, parts.size()).toArray(new String[parts.size() - 1]);

        executeCommand(command, args);
    }

    public void executeCommand(String command, String... args) {
        if (commands.containsKey(command)) {
            commands.get(command).execute(args);
            return;
        }

        System.out.println("Command does not exist.");
    }
}
