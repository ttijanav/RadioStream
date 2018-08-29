package com.radio.streamer.persistence.entities;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "zemlja")
public class Zemlja {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  @Column(nullable = false, unique = true)
  private String name;


  public Zemlja(String name) {
    this.name = name;
  }

  public Zemlja(){}
  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Zemlja{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
  }
}
