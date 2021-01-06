package spring.practice.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.practice.redis.service.RedisService;

@RestController
@RequestMapping("/basic")
public class BasicController {

    @Autowired
    private RedisService redisService;

    @GetMapping("/add")
    public String add(@RequestParam String key, @RequestParam String value) {
        redisService.setString(key, value);
        return "success";
    }

    @GetMapping("/get")
    public String get(@RequestParam String key) {
        return redisService.getString(key);
    }

    @GetMapping("/list")
    public String list() {
        return redisService.list().toString();
    }
}
