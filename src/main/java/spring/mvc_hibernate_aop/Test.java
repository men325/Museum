package spring.mvc_hibernate_aop;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import spring.mvc_hibernate_aop.entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Test {
    public static void main(String[] args) {

//        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Museum.class).addAnnotatedClass(Hall.class).addAnnotatedClass(Excursion.class).addAnnotatedClass(Showpiece.class).addAnnotatedClass(Guide.class).addAnnotatedClass(User.class).buildSessionFactory();
//        Session session = sessionFactory.getCurrentSession();
//        session.beginTransaction();
//        Museum museum = session.get(Museum.class, 1);
//        System.out.println(museum);
//        System.out.println(museum.getHallList());
//        session.getTransaction().commit();
//
//        sessionFactory.close();

        Hall hall1 = new Hall();
        hall1.setHall_theme("Hall 1");
        Hall hall2 = new Hall();
        hall2.setHall_theme("Hall 2");

        Hall hall3 = new Hall();
        hall3.setHall_theme("Hall 3");
        Hall hall4 = new Hall();
        hall4.setHall_theme("Hall 4");

        Hall hall5 = new Hall();
        hall5.setHall_theme("Hall 5");
        Hall hall6 = new Hall();
        hall6.setHall_theme("Hall 6");

        Hall hall7 = new Hall();
        hall7.setHall_theme("Hall 7");
        Hall hall8 = new Hall();
        hall8.setHall_theme("Hall 8");

        Hall hall9 = new Hall();
        hall9.setHall_theme("Hall 9");
        Hall hall10 = new Hall();
        hall10.setHall_theme("Hall 10");



        List <Hall> OLD_HALL_LIST = new ArrayList <>();
        List <Hall> NEW_HALL_LIST = new ArrayList <>();

        OLD_HALL_LIST.add(hall1);
        OLD_HALL_LIST.add(hall2);
        OLD_HALL_LIST.add(hall3);
        OLD_HALL_LIST.add(hall4);
        OLD_HALL_LIST.add(hall5);
        OLD_HALL_LIST.add(hall6);
        OLD_HALL_LIST.add(hall7);
        OLD_HALL_LIST.add(hall8);
        OLD_HALL_LIST.add(hall9);
        OLD_HALL_LIST.add(hall10);

        //NEW_HALL_LIST.add(hall1);
        NEW_HALL_LIST.add(hall2);
        NEW_HALL_LIST.add(hall3);
        NEW_HALL_LIST.add(hall4);
        NEW_HALL_LIST.add(hall5);
        NEW_HALL_LIST.add(hall6);
        NEW_HALL_LIST.add(hall7);
        NEW_HALL_LIST.add(hall8);
        NEW_HALL_LIST.add(hall9);
        //NEW_HALL_LIST.add(hall10);


        List <Hall> TARMINATED_HALL_LIST = new ArrayList <>();



        for (int i = 0; i < OLD_HALL_LIST.size(); i++) {

            String hall_theme = OLD_HALL_LIST.get(i).getHall_theme();
            int DROP = 0;
            for (Hall hall : NEW_HALL_LIST) {
                if (hall_theme.equals(hall.getHall_theme())) {
                    DROP = 1;
                    //i++;
                    break;
                }
            }

            if (DROP == 0) {
                TARMINATED_HALL_LIST.add(OLD_HALL_LIST.get(i));
            }

        }

        System.out.println();
        System.out.println("OLD_HALL_LIST-->" + OLD_HALL_LIST);
        System.out.println("NEW_HALL_LIST-->" + NEW_HALL_LIST);
        System.out.println("$$$$$$$$$$$$$$$");
        System.out.println("TARMINATED_HALL_LIST-->" + TARMINATED_HALL_LIST);


    }
}


































