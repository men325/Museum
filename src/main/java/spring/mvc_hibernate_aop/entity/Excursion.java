package spring.mvc_hibernate_aop.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "excursion")
public class Excursion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_excursion")
    private int id_excursion;

    @Column(name = "excursion_name")
    private String excursion_name;

    @Column(name = "excursion_description")
    private String excursion_description;

    @Column(name = "excursion_date")
    private String excursion_date;

    @Column(name = "excursion_start_time")
    private String excursion_start_time;

    @Column(name = "excursion_end_time")
    private String excursion_end_time;

    @Column(name = "excursion_age_accesss")
    private int excursion_age_access;

    @Column(name = "excursion_price")
    private int excursion_price;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_museum_excursion")
    private Museum museum;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_guide_excursion")
    private Guide guide;

    //DO NOT TOUCH!
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE}, mappedBy = "excursion", fetch = FetchType.EAGER)
    private List <Hall> hallList;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE}, mappedBy = "excursion")
    private List <User> userList;

    public Excursion() {
    }

    public Excursion(String excursion_name, String excursion_description, String excursion_date, String excursion_start_time, String excursion_end_time, int excursion_age_access, int excursion_price, Museum museum, Guide guide) {
        this.excursion_name = excursion_name;
        this.excursion_description = excursion_description;
        this.excursion_date = excursion_date;
        this.excursion_start_time = excursion_start_time;
        this.excursion_end_time = excursion_end_time;
        this.excursion_age_access = excursion_age_access;
        this.excursion_price = excursion_price;
        this.museum = museum;
        this.guide = guide;
    }

    public void addHallToExcursion(Hall hall) {
        if (hallList == null) {
            hallList = new ArrayList <>();
        }
        hallList.add(hall);
        hall.setExcursion(this);
    }

    public void addUserToExcursion(User user) {
        if (userList == null) {
            userList = new ArrayList <>();
        }
        userList.add(user);
        user.setExcursion(this);
    }

    public Integer getId_excursion() {
        return id_excursion;
    }

    public void setId_excursion(int id_excursion) {
        this.id_excursion = id_excursion;
    }

    public String getExcursion_name() {
        return excursion_name;
    }

    public void setExcursion_name(String excursion_name) {
        this.excursion_name = excursion_name;
    }

    public String getExcursion_description() {
        return excursion_description;
    }

    public void setExcursion_description(String excursion_description) {
        this.excursion_description = excursion_description;
    }

    public String getExcursion_date() {
        return excursion_date;
    }

    public void setExcursion_date(String excursion_date) {
        this.excursion_date = excursion_date;
    }

    public String getExcursion_start_time() {
        return excursion_start_time;
    }

    public void setExcursion_start_time(String excursion_start_time) {
        this.excursion_start_time = excursion_start_time;
    }

    public String getExcursion_end_time() {
        return excursion_end_time;
    }

    public void setExcursion_end_time(String excursion_end_time) {
        this.excursion_end_time = excursion_end_time;
    }

    public int getExcursion_age_access() {
        return excursion_age_access;
    }

    public void setExcursion_age_access(int excursion_age_access) {
        this.excursion_age_access = excursion_age_access;
    }

    public int getExcursion_price() {
        return excursion_price;
    }

    public void setExcursion_price(int excursion_price) {
        this.excursion_price = excursion_price;
    }

    public Museum getMuseum() {
        return museum;
    }

    public void setMuseum(Museum museum) {
        this.museum = museum;
    }

    public List <Hall> getHallList() {
        return hallList;
    }

    public void setHallList(List <Hall> hallList) {
        this.hallList = hallList;
    }

    public Guide getGuide() {
        return guide;
    }

    public void setGuide(Guide guide) {
        this.guide = guide;
    }

    public List <User> getUserList() {
        return userList;
    }

    public void setUserList(List <User> userList) {
        this.userList = userList;
    }

    @Override
    public String toString() {
        return "Excursion{" +
                "id_excursion=" + id_excursion +
                ", excursion_name='" + excursion_name + '\'' +
                ", excursion_description='" + excursion_description + '\'' +
                ", excursion_date=" + excursion_date +
                ", excursion_start_time=" + excursion_start_time +
                ", excursion_end_time=" + excursion_end_time +
                ", excursion_age_access=" + excursion_age_access +
                ", excursion_price=" + excursion_price +
                '}';
    }
}














