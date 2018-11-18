package sr.will.carstats.config;

public class Config {
    public Stats stats = new Stats();
    public boolean debug = false;

    public class Stats {
        public int interval = 1;
        public String host = "localhost";
        public int port = 8125;
        public String prefix = "carstats";
    }
}
