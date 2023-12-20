package spring.mvc_hibernate_aop.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;


import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "museum")
public class Museum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_museum")
    private int museum_id;

    @Column(name = "museum_name")
    @NotBlank(message = "Input museums name!")
    private String museum_name;

    @Column(name = "museum_open_time")
    @NotBlank(message = "Input museums open time!")
    private String museum_openTime;

    @Column(name = "museum_close_time")
    @NotBlank(message = "Input museums close time!")
    private String museum_closeTime;

    @Column(name = "museum_city")
    @NotBlank(message = "Input museums city!")
    private String museum_City;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH}, mappedBy = "museum")
    private List <Hall> hallList;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH}, mappedBy = "museum")
    private List <Excursion> excursionList;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH}, mappedBy = "museum")
    private List <Guide> guideList;

    @Column(name = "image_MuseumPathLocation")
    private String base64Image;

    public Museum() {
    }

    public Museum(String museum_name, String museum_openTime, String museum_closeTime, String museum_City) {
        this.museum_name = museum_name;
        this.museum_openTime = museum_openTime;
        this.museum_closeTime = museum_closeTime;
        this.museum_City = museum_City;
    }

    public Museum(String museum_name, String museum_openTime, String museum_closeTime, String museum_City, String image_museum) {
        this.museum_name = museum_name;
        this.museum_openTime = museum_openTime;
        this.museum_closeTime = museum_closeTime;
        this.museum_City = museum_City;
        this.base64Image = image_museum;
    }

    public void addHallToMuseum(Hall hall) {
        if (hallList == null) {
            hallList = new ArrayList <>();
        }
        hallList.add(hall);
        hall.setMuseum(this);
    }

    public void addExcursionToMuseum(Excursion excursion) {
        if (excursionList == null) {
            excursionList = new ArrayList <>();
        }
        excursionList.add(excursion);
        excursion.setMuseum(this);
    }

    public void addGuideToMuseum(Guide guide) {
        if (guideList == null) {
            guideList = new ArrayList <>();
        }
        guideList.add(guide);
        guide.setMuseum(this);
    }


    public int getMuseum_id() {
        return museum_id;
    }

    public void setMuseum_id(int museum_id) {
        this.museum_id = museum_id;
    }

    public String getMuseum_name() {
        return museum_name;
    }

    public void setMuseum_name(String museum_name) {
        this.museum_name = museum_name;
    }

    public String getMuseum_openTime() {
        return museum_openTime;
    }

    public void setMuseum_openTime(String museum_openTime) {
        this.museum_openTime = museum_openTime;
    }

    public String getMuseum_closeTime() {
        return museum_closeTime;
    }

    public void setMuseum_closeTime(String museum_closeTime) {
        this.museum_closeTime = museum_closeTime;
    }

    public String getMuseum_City() {
        return museum_City;
    }

    public void setMuseum_City(String museum_City) {
        this.museum_City = museum_City;
    }

    public List <Hall> getHallList() {
        return hallList;
    }

    public void setHallList(List <Hall> hallList) {
        this.hallList = hallList;
    }

    public List <Excursion> getExcursionList() {
        return excursionList;
    }

    public void setExcursionList(List <Excursion> excursionList) {
        this.excursionList = excursionList;
    }

    public String getBase64Image() {
        return base64Image;
    }

    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
    }

    public List <Guide> getGuideList() {
        return guideList;
    }

    public void setGuideList(List <Guide> guideList) {
        this.guideList = guideList;
    }

    @Override
    public String toString() {
        return "Museum{" +
                "museum_id=" + museum_id +
                ", museum_name='" + museum_name + '\'' +
                ", museum_openTime=" + museum_openTime +
                ", museum_closeTime=" + museum_closeTime +
                ", museum_City='" + museum_City + '\'' +
                ", base64Image='" + base64Image + '\'' +
                '}';
    }
}
