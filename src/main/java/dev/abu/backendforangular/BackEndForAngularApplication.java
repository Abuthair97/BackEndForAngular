package dev.abu.backendforangular;


import dev.abu.backendforangular.models.Product;
import dev.abu.backendforangular.repositories.ProductRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class BackEndForAngularApplication {

    private static ProductRepo  productRepo;
    public BackEndForAngularApplication(ProductRepo productRepo){
         this.productRepo=productRepo;
    }

    public static void main(String[] args) {


        SpringApplication.run(BackEndForAngularApplication.class, args);
    }

}
