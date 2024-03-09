package dev.abu.backendforangular.services;

import dev.abu.backendforangular.exceptions.ProductNotFoundException;
import dev.abu.backendforangular.models.Product;
import dev.abu.backendforangular.repositories.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductServiceImpl implements IProductService{

    private ProductRepo productRepo;
    public ProductServiceImpl(ProductRepo productRepo){
        this.productRepo = productRepo;
    }
    @Override
    public Product create(Product product) {
        Product newProduct = new Product();
        newProduct.setTitle(product.getTitle());
        newProduct.setDescription(product.getDescription());
        newProduct.setImageUrl(product.getImageUrl());
        newProduct.setCategory(product.getCategory());
        newProduct.setPrice(product.getPrice());
        newProduct.setRating(product.getRating());

        return productRepo.save(newProduct);
    }

//    @Override
//    public List<Product> addProducts(Product product) {
//        Product product1 = new Product(1L,"Quantum Smartwatch", "https://source.unsplash.com/800x600/?watch", 199 , "High-tech smartwatch with advanced features.", 4, "Wearable");
//        Product product2 = new Product(2L,"Stellar Noise-Canceling Headphones", "https://source.unsplash.com/800x600/?headphones", 149.99, "Immersive audio experience with noise-canceling technology.", 4.2, "Electronics");
//        Product product3 = new Product(3L,"Nebula Laptop Backpack", "https://source.unsplash.com/800x600/?backpack", 79.99, "Spacious laptop backpack with multiple compartments.", 4.0, "Fashion");
//        Product product4 = new Product(4L,"Eclipse Wireless Charger", "https://source.unsplash.com/800x600/?charger", 29.99, "Wireless charger with fast charging capabilities.", 4.7, "Electronics");
//        Product product5 = new Product(5L,"Celestial Coffee Maker", "https://source.unsplash.com/800x600/?coffee", 49.99, "Modern coffee maker for brewing your favorite beverages.", 4.3, "Appliances");
//        Product product6 = new Product(6L,"Aurora Fitness Tracker", "https://source.unsplash.com/800x600/?fitness", 89.99, "Fitness tracker to monitor your daily activities and health.", 4.1, "Wearable");
//        Product product7 = new Product(7L,"Galactic VR Headset", "https://source.unsplash.com/800x600/?vr", 199.99, "Immersive virtual reality headset for gaming and experiences.", 4.6, "Gaming");
//        Product product8 = new Product(8L,"Fusion Blender Pro", "https://source.unsplash.com/800x600/?blender", 79.99, "High-performance blender for smoothies and food processing.", 4.4, "Appliances");
//        Product product9 = new Product(9L,"Solaris Portable Speaker", "https://source.unsplash.com/800x600/?speaker", 59.99, "Portable speaker with Bluetooth connectivity for on-the-go music.", 4.2, "Audio");
//        Product product10 = new Product(10L,"Nova Digital Camera", "https://source.unsplash.com/800x600/?camera", 299.99, "Digital camera with advanced features for photography enthusiasts.", 4.8, "Photography");
//
//        // Save sample products to the database
//        return  productRepo.saveAll(Arrays.asList(
//                product1, product2, product3, product4, product5,
//                product6, product7, product8, product9, product10
//        ));
//    }

    @Override
    public Product updateProduct(Long id, Product product) throws ProductNotFoundException {
        Product updateProduct = productRepo.findById(id).get();
        if(updateProduct == null){
            throw new ProductNotFoundException(" No product with Id : "+id);
        }
        updateProduct.setRating(product.getRating());
        updateProduct.setTitle(product.getTitle());
        updateProduct.setImageUrl(product.getImageUrl());
        updateProduct.setDescription(product.getDescription());
        updateProduct.setPrice(product.getPrice());
        updateProduct.setRating(product.getRating());

        return productRepo.save(product);
    }

    @Override
    public void deleteById(Long id) throws ProductNotFoundException {
        Product deleteProduct = productRepo.findById(id).get();
        if(deleteProduct == null){
            throw new ProductNotFoundException("No Product with : "+id);
        }
        productRepo.deleteById(id);
    }

    @Override
    public List<Product> getAll() throws ProductNotFoundException {
        List<Product> productList = productRepo.findAll();
        if(productList.isEmpty()){
            throw new ProductNotFoundException("No Products present");
        }
        return productList;
    }

    @Override
    public Product getById(Long id) throws ProductNotFoundException {
        Product res = productRepo.findById(id).get();
        if(res == null){
            throw new ProductNotFoundException("No Product with : "+id);
        }
        return res;
    }
}
