package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

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

        try {
//
            Member member1 = new Member();
            member1.setUsername("A");

            Member member2 = new Member();
            member2.setUsername("B");

            Member member3 = new Member();
            member3.setUsername("C");

            System.out.println("====================");

//            em.persist(member1);
//            em.persist(member2);
//            em.persist(member3);

            System.out.println("member1 = " + member1);
            System.out.println("member2 = " + member2);
            System.out.println("member3 = " + member3);

            System.out.println("======================");




            // SQL은 commit 단계에서 처리된다.
            tx.commit();

        } catch (Exception e) {
            // 정상적일 때는 commit을 하고, 문제가 생겼을 때는 rollback한다
            tx.rollback();
        } finally {
            // 작업이 모두 종료되면 엔티티 매니저를 close 처리한다
            // 엔티티 매니저를 닫아주는 것이 중요하다. DB커넥션을 물고 동작한다.
            em.close(); // 사용이 끝나면 닫아준다
        }
        // 전체 작업이 끝나면 factory도 닫아준다
        emf.close(); // 완전히 끝나면 Factory도 닫아준다
    }

    private static Member jpaFind(EntityManager em) {
        // member 조회하기
        Member findMember = em.find(Member.class, 1L);// member를 찾아온다

        return findMember;
    }

    // Member 저장하기
    private static void jpaExecute(EntityManager em, EntityTransaction tx) {

        // 1. 일단 member 인스턴스를 생성한다
        Member member = new Member();
        // 2. Id와 Name을 넣는다

        // 3. member를 저장한다
        em.persist(member);
        tx.commit(); // 트랜잭션 커밋
    }
}
