package hellojpa;

import javax.persistence.*;
import java.util.Date;

@Entity // 꼭 넣어야 함 -> JPA가 관리하는 객체로 인식한다. DB 테이블과 맵핑하여 사용한다.
// @Table -> 일반적으로 Table 이름은 Member를 따라가지면 @Table을 이용하여 별도로 지정할 수도 있다
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;

//    @Column(name = "TEAM_ID")
//    private Long teamId; // DB에 맞춘 모델링 방식으로, teamId를 직접 넣는다

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEAM_ID") // 객체를 참조하기 위해 조인해야 하는 ID를 넣는다
    private Team team;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;

        // member에 team을 세팅하는 시점에 team에도 member를 세팅한다
        team.getMembers().add(this);
    }
}


