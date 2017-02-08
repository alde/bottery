package nu.alde.bottery;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SmmryResponse {
    @JsonProperty("sm_api_content")
    private String content;

    @JsonProperty("sm_api_message")
    private String message;

    @JsonProperty("sm_api_character_count")
    private int count;

    @JsonProperty("sm_api_title")
    private String title;

    @JsonProperty("sm_api_keyword_array")
    private String[] keywords;

    @JsonProperty("sm_api_error")
    private int error;

    @JsonProperty("sm_api_limitation")
    private String limitation;


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getKeywords() {
        return keywords;
    }

    public void setKeywords(String[] keywords) {
        this.keywords = keywords;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public boolean hasError() {
        return this.getError() > 0;
    }

    public String getLimitation() {
        return limitation;
    }

    public void setLimitation(String limitation) {
        this.limitation = limitation;
    }
}
