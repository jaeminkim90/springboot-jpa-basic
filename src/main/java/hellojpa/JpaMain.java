package hellojpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {
        // Factory 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");


    }


}
