package sr.will.carstats.commandconsole;

import sr.will.carstats.CarStats;

import java.lang.management.ManagementFactory;

public class CommandConsolePID extends CommandConsole {
    private CarStats carStats;

    public CommandConsolePID(CarStats carStats) {
        this.carStats = carStats;
    }

    public void execute(String... args) {
        CarStats.getLogger().info(ManagementFactory.getRuntimeMXBean().getName().split("@")[0]);
    }
}
