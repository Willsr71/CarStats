package sr.will.carstats.manager;

import net.noxal.common.stats.StatsdClient;
import sr.will.carstats.CarStats;

import java.io.IOException;

public class StatsdManager {
    private StatsdClient client;

    public StatsdManager() {

    }

    public void start() {
        try {
            CarStats.getLogger().info("Starting metrics!");
            client = new StatsdClient(CarStats.getInstance().config.stats.host, CarStats.getInstance().config.stats.port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        if (client != null) {
            client.flush();
        }
    }

    public void restart() {
        stop();
        start();
    }
}
