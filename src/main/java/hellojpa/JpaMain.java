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

            // 저장하는 코드


            Team team = new Team();
            team.setName("TeamA");
            em.persist(team); // persist가 되면 PK가 항상 셋팅 된다

            Member member = new Member();
            member.setUsername("member1");
            member.setTeam(team);
            em.persist(member);

            em.flush();
            em.clear();


            // member의 소속 팀을 알고 싶을 때
            Member findMember = em.find(Member.class, member.getId());
            Team findTeam = findMember.getTeam();
            System.out.println("findTeam = " + findTeam);


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
