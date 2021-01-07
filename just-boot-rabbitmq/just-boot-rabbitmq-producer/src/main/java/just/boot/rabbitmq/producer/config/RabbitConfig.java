package just.boot.rabbitmq.producer.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Tenton Lien
 */
@Configuration
public class RabbitConfig {

    public static final String QUEUE_NAME = "just-boot-rabbitmq";

    @Bean
    public Queue Queue() {
        return new Queue(QUEUE_NAME);
    }

}
