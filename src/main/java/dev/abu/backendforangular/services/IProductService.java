package dev.abu.backendforangular.services;

import dev.abu.backendforangular.exceptions.ProductNotFoundException;
import dev.abu.backendforangular.models.Product;

import java.util.List;

public interface IProductService {

 Product create(Product product);
// List<Product> addProducts(Product product);
 Product updateProduct(Long id , Product product) throws ProductNotFoundException;
 void deleteById(Long id) throws ProductNotFoundException;

 List<Product> getAll() throws ProductNotFoundException;

 Product getById(Long id) throws ProductNotFoundException;
}
