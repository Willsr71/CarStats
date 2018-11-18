package sr.will.carstats.commandconsole;

import sr.will.carstats.CarStats;

public class CommandConsoleDebug extends CommandConsole {
    private CarStats carStats;

    public CommandConsoleDebug(CarStats carStats) {
        this.carStats = carStats;
    }

    public void execute(String... args) {
        carStats.config.debug = !carStats.config.debug;
        System.out.println("Debug set to " + carStats.config.debug);
    }
}
