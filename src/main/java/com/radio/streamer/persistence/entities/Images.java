package com.radio.streamer.persistence.entities;

import javax.persistence.*;

@Entity
@Table(name = "images")
public class Images {


  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(nullable = false, unique = true)
  private String path;


public Images(){

}

  public Images(String path, long radioStations) {
    this.path = path;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

}
