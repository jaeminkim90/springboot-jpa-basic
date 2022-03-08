package hellojpa;

import javax.persistence.*;
import java.util.Date;

@Entity // 꼭 넣어야 함 -> JPA가 관리하는 객체로 인식한다. DB 테이블과 맵핑하여 사용한다.
// @Table -> 일반적으로 Table 이름은 Member를 따라가지면 @Table을 이용하여 별도로 지정할 수도 있다
// ex) @Table(name = "MBR")
public class Member {

    @Id // PK 매핑
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "name", nullable = false) // 객체와 DB의 Colum이 다를 경우
    private String username;

    public Member() {
    }

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


}


