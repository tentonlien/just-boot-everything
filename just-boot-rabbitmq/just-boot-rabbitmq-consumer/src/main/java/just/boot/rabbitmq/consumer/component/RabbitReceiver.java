package just.boot.rabbitmq.consumer.component;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author Tenton Lien
 */
@Component
@RabbitListener(queues = "just-boot-rabbitmq")
public class RabbitReceiver {

    @RabbitHandler
    public void receive(String msg) {
        System.out.println("Received: " + msg);
    }
}
