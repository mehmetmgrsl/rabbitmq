package study.tech.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class SimpleMessageSender {
    private static final Logger log = LoggerFactory.getLogger(SimpleMessageSender.class);

    private final RabbitTemplate rabbitTemplate;

    public SimpleMessageSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Scheduled(fixedDelay = 3000L)
    public void sendSimpleMessage() {
        SimpleMessage msg = new SimpleMessage("Hello everyone", 1);
        rabbitTemplate.convertAndSend(RabbitmqApplication.EXCHANGE_NAME, RabbitmqApplication.ROUTING_KEY, msg);
        log.info("Message -> {} was sent!!!", msg);
    }
}
