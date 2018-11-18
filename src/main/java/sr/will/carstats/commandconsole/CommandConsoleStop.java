package sr.will.carstats.commandconsole;

import sr.will.carstats.CarStats;

public class CommandConsoleStop extends CommandConsole {
    private CarStats carStats;

    public CommandConsoleStop(CarStats carStats) {
        this.carStats = carStats;
    }

    public void execute(String... args) {
        carStats.stop();
    }
}
