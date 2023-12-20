package spring.mvc_hibernate_aop.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "guide")
public class Guide {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_guide")
    private int guide_id;

    @Column(name = "guide_fullname")
    @NotBlank()
    private String guide_full_name;

    @Column(name = "guide_education")
    @NotBlank()
    private String guide_education;

    @Column(name = "guide_phone_number")
    @NotBlank()
    private String guide_phone_number;

    @Column(name = "guide_post")
    @NotBlank()
    private String guide_post;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH}, mappedBy = "guide")
    private List <Excursion> excursionList;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "id_museum_guide")
    private Museum museum;

    public Guide() {
    }

    public Guide(String guide_full_name, String guide_education, String guide_phone_number, String guide_post) {
        this.guide_full_name = guide_full_name;
        this.guide_education = guide_education;
        this.guide_phone_number = guide_phone_number;
        this.guide_post = guide_post;
    }

    public void addExcursionToGuide(Excursion excursion) {
        if (excursionList == null) {
            excursionList = new ArrayList <>();
        }
        excursionList.add(excursion);
        excursion.setGuide(this);
    }

    public int getGuide_id() {
        return guide_id;
    }

    public void setGuide_id(int guide_id) {
        this.guide_id = guide_id;
    }

    public String getGuide_full_name() {
        return guide_full_name;
    }

    public void setGuide_full_name(String guide_full_name) {
        this.guide_full_name = guide_full_name;
    }

    public String getGuide_education() {
        return guide_education;
    }

    public void setGuide_education(String guide_education) {
        this.guide_education = guide_education;
    }

    public String getGuide_phone_number() {
        return guide_phone_number;
    }

    public void setGuide_phone_number(String guide_phone_number) {
        this.guide_phone_number = guide_phone_number;
    }

    public String getGuide_post() {
        return guide_post;
    }

    public void setGuide_post(String guide_post) {
        this.guide_post = guide_post;
    }

    public List <Excursion> getExcursionList() {
        return excursionList;
    }

    public void setExcursionList(List <Excursion> excursionList) {
        this.excursionList = excursionList;
    }

    public Museum getMuseum() {
        return museum;
    }

    public void setMuseum(Museum museum) {
        this.museum = museum;
    }

    @Override
    public String toString() {
        return "Guide{" +
                "guide_id=" + guide_id +
                ", guide_full_name='" + guide_full_name + '\'' +
                ", guide_education='" + guide_education + '\'' +
                ", guide_phone_number='" + guide_phone_number + '\'' +
                ", guide_post='" + guide_post + '\'' +
                '}';
    }
}
