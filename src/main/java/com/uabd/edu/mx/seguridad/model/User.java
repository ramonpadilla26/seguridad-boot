package com.uabd.edu.mx.seguridad.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  private String username;
  private String password;
  private String role;
  private boolean active;

  public User(String username,String password,String role,boolean active) {
    this.active=active;
    this.username=username;
    this.password=password;
    this.role=role;
  }

  public User() {
  }
}
