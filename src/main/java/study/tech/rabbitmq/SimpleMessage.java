package study.tech.rabbitmq;

import java.io.Serializable;

public class SimpleMessage implements Serializable {

    private final String text;
    private final int priority;

    public SimpleMessage(String text, int priority) {
        this.text = text;
        this.priority = priority;
    }

    public String getText() {
        return text;
    }

    public int getPriority() {
        return priority;
    }


    @Override
    public String toString() {
        return "SimpleMessage{" +
                "text='" + text + '\'' +
                ", priority=" + priority +
                '}';
    }
}
