package just.boot.mongodb.service;

import just.boot.mongodb.entity.Product;

/**
 * @author Tenton Lien
 */
public interface ProductService {

    void add(Product product);
    void remove(String id);
    Product getOne(String id);
}
