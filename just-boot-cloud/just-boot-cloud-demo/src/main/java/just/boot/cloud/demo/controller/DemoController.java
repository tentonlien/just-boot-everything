package just.boot.cloud.demo.controller;

import just.boot.cloud.demo.service.Demo2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Tenton Lien
 */
@RestController
@RequestMapping("/api/demo")
public class DemoController {

    @Autowired
    private Demo2Service demo2Service;

    @GetMapping("/hello")
    public String hello() {
        return demo2Service.hello();
    }
}
