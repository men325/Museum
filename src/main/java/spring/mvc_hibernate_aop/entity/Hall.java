package spring.mvc_hibernate_aop.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "hall")
public class Hall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hall")
    private int hall_id;

    @Column(name = "hall_theme")
    @NotBlank(message = "Input hall name!")
    private String hall_theme;

    @Column(name = "hall_number_of_exhibits")
    private int hall_number_of_showpieces;

    @Column(name = "hall_accessibility")
    private boolean hall_access;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "museum_id")
    private Museum museum;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE}, mappedBy = "hall")
    private List <Showpiece> showpieceList;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "excursion_id")
    private Excursion excursion;

    public Hall() {
    }

    public Hall(String hall_theme, int hall_number_of_showpieces, boolean hall_access, Museum museum) {
        this.hall_theme = hall_theme;
        this.hall_number_of_showpieces = hall_number_of_showpieces;
        this.hall_access = hall_access;
        this.museum = museum;
    }

    public void addShowpieceToHall(Showpiece showpiece) {
        if (showpieceList == null) {
            showpieceList = new ArrayList <>();
        }
        showpieceList.add(showpiece);
        showpiece.setHall(this);
    }

    public int getHall_id() {
        return hall_id;
    }

    public void setHall_id(int hall_id) {
        this.hall_id = hall_id;
    }

    public String getHall_theme() {
        return hall_theme;
    }

    public void setHall_theme(String hall_theme) {
        this.hall_theme = hall_theme;
    }

    public int getHall_number_of_showpieces() {
        return hall_number_of_showpieces;
    }

    public void setHall_number_of_showpieces(int hall_number_of_showpieces) {
        this.hall_number_of_showpieces = hall_number_of_showpieces;
    }

    public boolean isHall_access() {
        return hall_access;
    }

    public void setHall_access(boolean hall_access) {
        this.hall_access = hall_access;
    }

    public Museum getMuseum() {
        return museum;
    }

    public void setMuseum(Museum museum) {
        this.museum = museum;
    }

    public Excursion getExcursion() {
        return excursion;
    }

    public void setExcursion(Excursion excursion) {
        this.excursion = excursion;
    }

    public List <Showpiece> getShowpieceList() {
        return showpieceList;
    }

    public void setShowpieceList(List <Showpiece> showpieceList) {
        this.showpieceList = showpieceList;
    }

    @Override
    public String toString() {
//        return "Hall{" +
//                "hall_id=" + hall_id +
//                ", hall_theme='" + hall_theme + '\'' +
//                ", hall_number_of_showpieces=" + hall_number_of_showpieces +
//                ", hall_access=" + hall_access +
//                '}';
        return "ID=" + hall_id + " Тема:" + hall_theme;
    }
}
