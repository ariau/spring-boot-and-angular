package com.globomatics.bike.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.math.BigDecimal;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// POJO : Plain Old Java Object. model qui a les infos de purchase du vélo
// Hibernate implemente automatiquement des méthdde qu'on ne veut pas utiliser car on préfère
// utiliser Jackson (JSON)
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Bike {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String name;
  private String email;
  private String phone;
  private String model;
  private String serialNumber;
  private BigDecimal purchasePrice;

  @JsonFormat(shape = Shape.STRING, pattern = "MM-dd-yyyy")
  private Date purchaseDate;

  private String contact;

  protected Bike() {};

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public String getSerialNumber() {
    return serialNumber;
  }

  public void setSerialNumber(String serialNumber) {
    this.serialNumber = serialNumber;
  }

  public BigDecimal getPurchasePrice() {
    return purchasePrice;
  }

  public void setPurchasePrice(BigDecimal purchasePrice) {
    this.purchasePrice = purchasePrice;
  }

  public Date getPurchaseDate() {
    return purchaseDate;
  }

  public void setPurchaseDate(Date purchaseDate) {
    this.purchaseDate = purchaseDate;
  }

  public String getContact() {
    return contact;
  }

  public void setContact(String contact) {
    this.contact = contact;
  }
}
