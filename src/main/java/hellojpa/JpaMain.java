package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {

        // 만드는 순간 DB 연결까지 완료 됨
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        // EntityManager는 자바 컬렉션처럼 객체를 대신 저장해주는 역할을 한다고 생각하면 좋다
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        tx.begin(); // 트랜잭션 시작

        try {

            // 비영속
            Member member = new Member();
            member.setId(101L);
            member.setName("HelloJPA");

            // 영속
            System.out.println(" === BEFORE ===");
            em.persist(member);
            System.out.println(" === AFTER ===");

            Member findMember = em.find(Member.class, 101L);

            System.out.println("findMember.id = " + findMember.getId());
            System.out.println("findMember.name = " + findMember.getName());

            tx.commit(); // 트랜잭션 저장 -> 영속성 컨텍스트에서 DB에 쿼리가 날라간다

        } catch (Exception e) {
            tx.rollback();
        } finally {
            // code
            em.close();
        }
        emf.close();
    }
}

