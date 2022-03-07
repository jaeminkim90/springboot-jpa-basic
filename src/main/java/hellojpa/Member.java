package hellojpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity // 꼭 넣어야 함 -> JPA를 사용하는 객체로 인식한다
// @Table -> 일반적으로 Table 이름은 Member를 따라가지면 @Table을 이용하여 별도로 지정할 수도 있다
public class Member {

    @Id // JPA에 PK가 뭔지 알려준다
    private Long id;

    // @Column -> column도 마찬가지로 별도의 이름이 있다면 name 속성을 이용하여 mapping 할 수 있다
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
