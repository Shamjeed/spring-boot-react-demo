package com.example.springbootreactdemo;

import com.example.springbootreactdemo.domain.Car;
import com.example.springbootreactdemo.domain.CarRepository;
import com.example.springbootreactdemo.domain.Owner;
import com.example.springbootreactdemo.domain.OwnerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class SpringBootReactDemoApplication {
   private static final Logger logger = LoggerFactory.getLogger(SpringBootReactDemoApplication.class);

   @Autowired
   private CarRepository repository;

   @Autowired
   private OwnerRepository orepository;

   public static void main(String[] args) {

      SpringApplication.run(SpringBootReactDemoApplication.class, args);
      logger.info("Spring boot logger info!!!");
   }

   @Bean
   CommandLineRunner runner(){
      return args -> {
         Owner owner1 = new Owner("Sham" , "tc");
         Owner owner2 = new Owner("Jeed" , "tc");
         orepository.save(owner1);
         orepository.save(owner2);

         // Add car object with link to owners and save these to db.
         Car car = new Car("Ford", "Mustang", "Red",
                 "ADF-1121", 2017, 59000, owner1);
         repository.save(car);
         car = new Car("Nissan", "Leaf", "White",
                 "SSJ-3002", 2014, 29000, owner2);
         repository.save(car);
         car = new Car("Toyota", "Prius", "Silver",
                 "KKO-0212", 2018, 39000, owner2);
         repository.save(car);
      };
   }

}
