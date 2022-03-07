package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {
        // Factory 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        // Factory에서 EntityManager를 꺼낸다
        EntityManager entityManager = emf.createEntityManager();

        entityManager.close();

        emf.close();
    }


}
