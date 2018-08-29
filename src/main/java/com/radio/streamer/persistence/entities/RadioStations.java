package com.radio.streamer.persistence.entities;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;



@Entity
@Table(name = "radio_stations")
public class RadioStations {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Column(nullable = false, unique = true)
  private String name;

  @Column(nullable = false, unique = true)
  private String url;

  @Column (name = "zemlja")
  private int zemlja;

  @Column(name = "website")
  private String webSite;

  @Column (name = "kategrije")
  @ManyToMany (fetch = FetchType.LAZY)
  @JoinTable(name = "station_categories",
          joinColumns = @JoinColumn(name = "id_stat"),
  inverseJoinColumns = @JoinColumn(name = "id_cat"))
  @Fetch(FetchMode.SUBSELECT)
  private List<Kategorija> kategorija;

  @Column (name = "images")
  @ManyToMany (fetch = FetchType.LAZY)
  @JoinTable(name = "station_images",
          joinColumns = @JoinColumn(name = "id_stat"),
          inverseJoinColumns = @JoinColumn(name = "id_img"))
  @Fetch(FetchMode.SUBSELECT)
  private List<Images> images;

  protected RadioStations() {

  }

  public RadioStations(String name, String url, int zemlja, String webSite, List<Kategorija> kategorija, List<Images> images) {
    this.name = name;
    this.url = url;
    this.zemlja = zemlja;
    this.webSite = webSite;
    this.kategorija = kategorija;
    this.images = images;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public int getZemlja() {
    return zemlja;
  }

  public void setZemlja(int zemlja) {
    this.zemlja = zemlja;
  }

  public String getWebSite() {
    return webSite;
  }

  public void setWebSite(String webSite) {
    this.webSite = webSite;
  }

  public List<Kategorija> getKategorija() {
    return kategorija;
  }

  public void setKategorija(List<Kategorija> kategorija) {
    this.kategorija = kategorija;
  }


  public List<Images> getImages() {
    return images;
  }

  public void setImages(List<Images> images) {
    this.images = images;
  }

  @Override
  public String toString() {
    return "RadioStations{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", url='" + url + '\'' +
            ", zemlja=" + zemlja +
            ", webSite=" + webSite +
            ", kategorija=" + kategorija +
            ", images=" + images +
            '}';
  }
}
