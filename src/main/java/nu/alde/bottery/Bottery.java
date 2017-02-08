package nu.alde.bottery;

import org.pircbotx.Configuration;
import org.pircbotx.PircBotX;
import org.pircbotx.exception.IrcException;

import java.io.IOException;

public class Bottery {

    public static void main(String[] args) throws IrcException, IOException {
        BotteryConfig bc = new BotteryConfig(System.getenv());

        bc.validate();

        Configuration configuration = new Configuration.Builder()
                .setName("bottery")
                .addServer("irc.quakenet.org")
                .addAutoJoinChannel(String.format("%s %s", bc.getChannel(), bc.getPass()))
                .addListener(new Summry(bc.getKey(), bc.getCount()))
                .buildConfiguration();

        PircBotX bot = new PircBotX(configuration);
        bot.startBot();
    }
}
