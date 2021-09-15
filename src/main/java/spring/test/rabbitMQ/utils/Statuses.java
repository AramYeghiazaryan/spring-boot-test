package spring.test.rabbitMQ.utils;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Statuses {
    PROGRESS("progress"),
    COMPLETED("completed");

    String value;


    Statuses(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
