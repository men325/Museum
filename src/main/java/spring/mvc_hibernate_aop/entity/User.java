package spring.mvc_hibernate_aop.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private int user_id;

    @Column(name = "user_fullname")
    @NotBlank
    private String user_full_name;

    @Column(name = "user_age")
    private int user_age;

    @Column(name = "user_phone")
    private String user_phone;

    @Column(name = "user_email")
//    @CheckEmail(value = "abc.net", message = "email must ends with abc.net!")
//    @Pattern(regexp = ".+@ukr\\.net")
    @Pattern(regexp = "(.+@ukr\\.net|.+@gmail\\.com)")
    private String user_email;


    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "excursion_id")
    private Excursion excursion;

    public User() {
    }

    public User(String user_full_name, int user_age, String user_phone, String user_email, Excursion excursion) {
        this.user_full_name = user_full_name;
        this.user_age = user_age;
        this.user_phone = user_phone;
        this.user_email = user_email;
        this.excursion = excursion;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_full_name() {
        return user_full_name;
    }

    public void setUser_full_name(String user_full_name) {
        this.user_full_name = user_full_name;
    }

    public int getUser_age() {
        return user_age;
    }

    public void setUser_age(int user_age) {
        this.user_age = user_age;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public Excursion getExcursion() {
        return excursion;
    }

    public void setExcursion(Excursion excursion) {
        this.excursion = excursion;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_full_name='" + user_full_name + '\'' +
                ", user_age=" + user_age +
                ", user_phone='" + user_phone + '\'' +
                ", user_email='" + user_email + '\'' +
                '}';
    }
}
