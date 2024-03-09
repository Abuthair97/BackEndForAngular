package dev.abu.backendforangular.controllers;


import dev.abu.backendforangular.models.Product;
import dev.abu.backendforangular.services.IProductService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ProductController {

 private IProductService  iProductService;
 public ProductController(IProductService iProductService){
     this.iProductService = iProductService;
 }

   @PostMapping("/Products")
    ResponseEntity<Product> create(@RequestBody  Product product){
       HttpHeaders httpHeaders = new HttpHeaders();
       httpHeaders.add("Desc","New product is created");
       return new ResponseEntity<>(iProductService.create(product), httpHeaders,HttpStatus.CREATED);
    }
    @PutMapping("/Products/{id}")
    ResponseEntity<Product> updateProduct(@PathVariable Long id ,@RequestBody Product product) {
     HttpHeaders httpHeaders = new HttpHeaders();
     httpHeaders.add("Desc","Product is Updated with Id : "+id);
     return new ResponseEntity<>(iProductService.updateProduct(id,product),httpHeaders,HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/Products/{id}")
    ResponseEntity<Void> deleteById(@PathVariable  Long id) {
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.add("Desc", "Deleting product with Id : "+id);
    iProductService.deleteById(id);
    return new ResponseEntity<>(httpHeaders,HttpStatus.OK);
 }


    //Practice perpose
//    @GetMapping("/products/add")
//    List<Product> addProduct(Product  product){
//     return iProductService.addProducts(product);
//    }

     @GetMapping("/Products")
     ResponseEntity<List<Product>> getAll() {
     HttpHeaders httpHeaders = new HttpHeaders();
     httpHeaders.add("Desc" , "Getting list of Products");
      return new ResponseEntity<>(iProductService.getAll(),httpHeaders,HttpStatus.OK);
    }

     @GetMapping("/Products/{id}")
     ResponseEntity<Product> getById(@PathVariable  Long id) {
     HttpHeaders httpHeaders = new HttpHeaders();
     httpHeaders.add("Desc" , "Getting product with Id : "+id);
     return new ResponseEntity<>(iProductService.getById(id),HttpStatus.OK);
    }
}
