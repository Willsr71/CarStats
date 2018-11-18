package sr.will.carstats;

import net.noxal.common.config.JSONConfigManager;
import net.noxal.common.util.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sr.will.carstats.config.Config;
import sr.will.carstats.manager.CommandConsoleManager;
import sr.will.carstats.manager.StatsdManager;
import sr.will.carstats.service.InputReaderService;

public class CarStats {
    private static CarStats instance;

    private JSONConfigManager configManager;
    public Config config;

    public CommandConsoleManager consoleManager;
    public InputReaderService inputReaderService;
    public StatsdManager statsdManager;

    private static final Logger logger = LoggerFactory.getLogger("CarStats");
    public static final long startTime = System.currentTimeMillis();
    public static final String VERSION = "@version@";

    public CarStats() {
        instance = this;

        configManager = new JSONConfigManager(this, "carstats.json", "", Config.class);

        consoleManager = new CommandConsoleManager(this);
        inputReaderService = new InputReaderService(consoleManager);
        inputReaderService.start();
        statsdManager = new StatsdManager();

        reload();

        logger.info("Finished starting CarStats v{} in {}!", VERSION, DateUtils.formatDateDiff(startTime));
    }

    public void stop() {
        logger.info("Stopping!");

        statsdManager.stop();

        System.exit(0);
    }

    public void reload() {
        logger.info("Reloading!");

        configManager.reloadConfig();
        config = (Config) configManager.getConfig();

        statsdManager.restart();
    }

    public static Logger getLogger() {
        return logger;
    }

    public static CarStats getInstance() {
        return instance;
    }
}
