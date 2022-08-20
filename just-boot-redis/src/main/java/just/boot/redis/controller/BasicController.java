package just.boot.redis.controller;

import just.boot.redis.util.SimpleLockUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import just.boot.redis.service.RedisService;

/**
 * @author Tenton Lien
 */
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

    @PostMapping("lock")
    public boolean lock(@RequestParam String key, @RequestParam String request, @RequestParam String expire) {
        return SimpleLockUtil.lock(key, request, expire);
    }

    @DeleteMapping("lock")
    public boolean unlock(@RequestParam String key, @RequestParam String request) {
        return SimpleLockUtil.unlock(key, request);
    }
}
