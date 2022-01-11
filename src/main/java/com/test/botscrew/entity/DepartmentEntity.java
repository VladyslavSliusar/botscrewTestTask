package com.test.botscrew.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "DEPARTMENT")
@Getter
@Setter
@Entity
@NoArgsConstructor
public class DepartmentEntity {
    @Id
    @GeneratedValue
    @Column(name = "department_id")
    private Long id;

    private String name;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable (name = "department_lector",
    joinColumns = @JoinColumn(name = "department_id"),
    inverseJoinColumns = @JoinColumn(name = "lector_id"))
    private List<LectorEntity> lectorsList = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "lector_id")
    private LectorEntity head;

    public DepartmentEntity(String name, List<LectorEntity> lectorsList, LectorEntity head) {
        this.name = name;
        this.lectorsList = lectorsList;
        this.head = head;
    }
}
