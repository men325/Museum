package spring.mvc_hibernate_aop.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "showpiece")
public class Showpiece {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_showpiece")
    private int showpiece_id;

    @Column(name = "showpiece_name")
    @NotBlank
    private String showpiece_name;

    @Column(name = "showpiece_description")
    @NotBlank
    private String showpiece_description;

    @Column(name = "date_of_creation")
    @NotBlank
    private String showpiece_date_of_creation;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "hall_id")
    private Hall hall;

    public Showpiece() {
    }

    public Showpiece(String showpiece_name, String showpiece_description, String showpiece_date_of_creation) {
        this.showpiece_name = showpiece_name;
        this.showpiece_description = showpiece_description;
        this.showpiece_date_of_creation = showpiece_date_of_creation;
    }

    public int getShowpiece_id() {
        return showpiece_id;
    }

    public void setShowpiece_id(int showpiece_id) {
        this.showpiece_id = showpiece_id;
    }

    public String getShowpiece_name() {
        return showpiece_name;
    }

    public void setShowpiece_name(String showpiece_name) {
        this.showpiece_name = showpiece_name;
    }

    public String getShowpiece_description() {
        return showpiece_description;
    }

    public void setShowpiece_description(String showpiece_description) {
        this.showpiece_description = showpiece_description;
    }

    public String getShowpiece_date_of_creation() {
        return showpiece_date_of_creation;
    }

    public void setShowpiece_date_of_creation(String showpiece_date_of_creation) {
        this.showpiece_date_of_creation = showpiece_date_of_creation;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    @Override
    public String toString() {
        return "Showpiece{" +
                "showpiece_id=" + showpiece_id +
                ", showpiece_name='" + showpiece_name + '\'' +
                ", showpiece_description='" + showpiece_description + '\'' +
                ", showpiece_date_of_creation=" + showpiece_date_of_creation +
                '}';
    }
}
