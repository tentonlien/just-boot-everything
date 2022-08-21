package just.boot.cloud.demo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Tenton Lien
 */
@FeignClient(value = "just-boot-cloud-demo2", path = "/api/demo2")
public interface Demo2Service {

    @GetMapping("/hello")
    String hello();
}
