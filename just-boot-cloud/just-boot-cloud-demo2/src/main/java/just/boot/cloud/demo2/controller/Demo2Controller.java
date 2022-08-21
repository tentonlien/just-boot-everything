package just.boot.cloud.demo2.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Tenton Lien
 */
@RestController
@RequestMapping("/api/demo2")
public class Demo2Controller {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("hello")
    public String hello() {
        return "Hello from demo2 port " + serverPort;
    }
}
