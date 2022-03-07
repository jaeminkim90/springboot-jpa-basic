package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {
        // Factory 생성 -> 애플리케이션 로딩 시점에 하나만 만든다.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        // Factory에서 EntityManager를 만든다
        // 일괄적인 작업을 수행할 때는 Entity Manager를 꼭 만들어야 한다
        EntityManager em = emf.createEntityManager();

        // JPA는 트랜잭션 범위 안에서 동작한다. 트랜잭션을 얻어야 한다.
        EntityTransaction tx = em.getTransaction();
        tx.begin(); // transaction 시작

        // Member 저장하기

        // 1. 일단 member 인스턴스를 생성한다
        Member member = new Member();
        // 2. Id와 Name을 넣는다
        member.setId(1L);
        member.setName("Hello");

        // 3. member를 저장한다
        em.persist(member);
        tx.commit(); // 트랜잭션 커밋

        em.close(); // 사용이 끝나면 닫아준다
        emf.close(); // 완전히 끝나면 Factory도 닫아준다
    }
}
