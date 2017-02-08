package nu.alde.bottery;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.List;

public class SmmryClient {
    private final String key;
    private int sentences;

    public SmmryClient(String key, int sentences) {
        this.key = key;
        this.sentences = sentences;
    }

    public SmmryResponse summarize(String link) throws IOException {
        List<String> parr = Arrays.asList(
                "SM_API_KEY=" + this.key,
                "SM_LENGTH=" + this.sentences,
                "SM_URL=" + link,
                "SM_WITH_BREAK"
        );
        URL url = new URL(String.format("http://api.smmry.com/&%s", String.join("&", parr)));
        URLConnection conn = url.openConnection();
        SmmryResponse response = new ObjectMapper().readValue(conn.getInputStream(), SmmryResponse.class);
        return response;
    }
}
