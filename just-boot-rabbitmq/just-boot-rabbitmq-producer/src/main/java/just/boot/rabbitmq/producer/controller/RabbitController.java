package just.boot.rabbitmq.producer.controller;

import just.boot.rabbitmq.producer.config.RabbitConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author Tenton Lien
 */
@RestController
public class RabbitController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/one2one")
    public String send(@RequestParam String value) {
        rabbitTemplate.convertAndSend(RabbitConfig.QUEUE_NAME, new Date() + ": " + value);
        return "success";
    }
}
