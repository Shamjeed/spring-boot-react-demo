package com.example.springbootreactdemo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Owner implements Serializable {
   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
   private long ownerid;
   private String firstname, lastname;

   @OneToMany(cascade = CascadeType.ALL, mappedBy="owner")
   @JsonIgnore
   private List<Car> cars;

   //Getter and setter
   public List<Car> getCars() {
      return cars;
   }

   public void setCars(List<Car> cars) {
      this.cars = cars;
   }

   public Owner() {}

   public Owner(String firstname, String lastname) {
      super();
      this.firstname = firstname;
      this.lastname = lastname;
   }

   public long getOwnerid() {
      return ownerid;
   }
   public void setOwnerid(long ownerid) {
      this.ownerid = ownerid;
   }
   public String getFirstname() {
      return firstname;
   }
   public void setFirstname(String firstname) {
      this.firstname = firstname;
   }
   public String getLastname() {
      return lastname;
   }
   public void setLastname(String lastname) {
      this.lastname = lastname;
   }
}