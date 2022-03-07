package hellojpa;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity // 꼭 넣어야 함 -> JPA를 사용하는 객체로 인식한다
public class Member {

    @Id // JPA에 PK가 뭔지 알려준다
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
