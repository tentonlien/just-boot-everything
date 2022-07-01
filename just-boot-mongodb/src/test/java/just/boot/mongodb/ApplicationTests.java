package just.boot.mongodb;

import com.github.javafaker.Faker;
import just.boot.mongodb.entity.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.Locale;

@SpringBootTest
class ApplicationTests {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    void contextLoads() {
    }

    @Test
    void generateMongoData() {
        System.out.println("Mongo");
        Faker faker = new Faker(Locale.CHINA);
        for (int i = 0; i < 100; i ++) {
            Customer customer = new Customer();
            customer.setName(faker.name().fullName());
            customer.setAddress(faker.address().fullAddress());
            customer.setAge(faker.random().nextInt(0, 100));
            System.out.println(customer);
            mongoTemplate.save(customer);
        }
    }


}
