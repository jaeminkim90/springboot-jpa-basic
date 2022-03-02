package hellojpa;

import javax.persistence.*;
import java.util.Date;

@Entity // 이걸 꼭 넣어야 함. JPA를 사용한다는 것을 명시한다
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private String id; // PK 맵핑

    @Column(name = "USERNAME")
    private String username;

//    @Column(name = "TEAM_ID")
//    private Long teamId;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
    }
}
