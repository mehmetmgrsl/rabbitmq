package study.tech.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
public class SimpleMessageConsumer {

    private static final Logger log = LoggerFactory.getLogger(SimpleMessageConsumer.class);

    @RabbitListener(queues = RabbitmqApplication.DEFAULT_PARSING_QUEUE)
    public void consumeDefaultMessage(final Message message) {
        log.info("Message -> {} was received!!!", message.toString());

    }


}
