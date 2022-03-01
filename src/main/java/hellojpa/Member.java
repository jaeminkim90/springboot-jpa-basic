package hellojpa;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity // 이걸 꼭 넣어야 함. JPA를 사용한다는 것을 명시한다
public class Member {

    @Id
    private Long id;
    private String name;
    //Getter, Setter ...


    public Member() {
    }

    public Member(Long id, String name) {
        this.id = id;
        this.name = name;
    }


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
