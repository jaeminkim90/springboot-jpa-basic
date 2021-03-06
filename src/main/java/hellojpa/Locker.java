package hellojpa;

import javax.persistence.*;

@Entity
public class Locker {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToOne
    private Member member;
}
