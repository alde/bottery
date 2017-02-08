package nu.alde.bottery;

import java.util.Map;

public class BotteryConfig {
    private final String key;
    private final int count;
    private final String channel;
    private final String pass;

    public String getKey() {
        return key;
    }

    public int getCount() {
        return count;
    }

    public String getChannel() {
        return channel;
    }

    public String getPass() {
        return pass;
    }

    public BotteryConfig(Map<String, String> getenv) {
        this.key = getenv.getOrDefault("SMMRY_KEY", "");
        this.count = Integer.parseInt(getenv.getOrDefault("SMMRY_COUNT", "4"));
        this.channel = getenv.getOrDefault("BOTTERY_CHANNEL", "");
        this.pass = getenv.getOrDefault("BOTTERY_PASS", "");
    }

    public boolean isValid() {
        return !this.channel.isEmpty() && (this.key.isEmpty() ? false : true);
    }

    public void validate() {
        if (!this.isValid()) {
            throw new RuntimeException("Missing required environment variables. Ensure you have set:" +
                    "\n\tBOTTERY_CHANNEL" +
                    "\n\tSMMRY_KEY");
        }
    }
}
