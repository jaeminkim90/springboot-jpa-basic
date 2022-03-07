package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {
        // Factory 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        // Factory에서 EntityManager를 꺼낸다
        EntityManager em = emf.createEntityManager();


        // JPA 코드를 구현하는 영역


        em.close(); // 사용이 끝나면 닫아준다
        emf.close(); // 완전히 끝나면 Factory도 닫아준다
    }
}
