package nu.alde.bottery;

import org.nibor.autolink.LinkExtractor;
import org.nibor.autolink.LinkSpan;
import org.nibor.autolink.LinkType;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.types.GenericMessageEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.EnumSet;
import java.util.regex.Pattern;

public class Summry extends ListenerAdapter {

    private final Logger logger;
    private final SmmryClient client;

    public Summry(String key, int count) {
        super();
        this.logger = LoggerFactory.getLogger(this.getClass());
        this.client = new SmmryClient(key, count);
    }

    private SmmryResponse summarize(final String link) throws IOException {
        return this.client.summarize(link);
    }

    @Override
    public void onGenericMessage(GenericMessageEvent event) {
        String msg = event.getMessage();
        LinkExtractor linkExtractor = LinkExtractor.builder()
                .linkTypes(EnumSet.of(LinkType.URL, LinkType.WWW))
                .build();

        Iterable<LinkSpan> links = linkExtractor.extractLinks(msg);
        for (LinkSpan l: links) {
            String link = msg.substring(l.getBeginIndex(), l.getEndIndex());

            try {
                SmmryResponse summary = summarize(link);
                if (summary.hasError()) {
                    return;
                }
                event.respond("Summering av din länk: ");
                for (String s : summary.getContent().split(Pattern.quote("[BREAK]"))) {
                    event.respond(s);
                }
            } catch (IOException e) {
                this.logger.error("Error", e);
            }
        }
    }
}
