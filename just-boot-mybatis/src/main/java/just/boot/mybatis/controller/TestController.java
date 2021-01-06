package just.boot.mybatis.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Tenton Lien
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("hi")
    public String greet() {
        
        return "Hi~";
    }
}
