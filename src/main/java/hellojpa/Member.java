package hellojpa;

import javax.persistence.*;
import java.util.Date;

@Entity // 꼭 넣어야 함 -> JPA가 관리하는 객체로 인식한다. DB 테이블과 맵핑하여 사용한다.
// @Table -> 일반적으로 Table 이름은 Member를 따라가지면 @Table을 이용하여 별도로 지정할 수도 있다
@TableGenerator(
        name = "MEMBER_SEQ_GENERATOR",
        table = "MY_SEQUENCES",
        pkColumnValue = "MEMBER_SEQ", allocationSize = 1)

public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE,
            generator = "MEMBER_SEQ_GENERATOR")
    private Long id;

    @Column(name = "name", nullable = false) // 객체와 DB의 Colum이 다를 경우
    private String username;

    public Member() {
    }

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


}


