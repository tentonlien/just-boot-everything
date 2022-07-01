package just.boot.file.service;

import just.boot.file.entity.Product;

/**
 * @author Tenton Lien
 */
public interface ProductService {

    void add(Product product);
    void remove(String id);
    Product getOne(String id);
}
