package just.boot.mybatis.service;

import just.boot.mybatis.entity.Product;

/**
 * @author Tenton Lien
 */
public interface ProductService {

    void add(Product product);
    void remove(String id);
    Product getOne(String id);
}
