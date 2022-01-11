package com.test.botscrew.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "LECTOR")
@Getter
@Setter
@NoArgsConstructor
@Entity
public class LectorEntity {

    @Id
    @GeneratedValue
    @Column(name = "lector_id")
    private Long id;

    private String name;

    private int salary;

    @Enumerated(EnumType.STRING)
    private LectorDegree degree;

    @ManyToMany(mappedBy = "lectorsList", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<DepartmentEntity> departmentsList = new ArrayList<>();

    public LectorEntity(String name, int salary, LectorDegree degree, List<DepartmentEntity> departmentsList) {
        this.name = name;
        this.salary = salary;
        this.degree = degree;
        this.departmentsList = departmentsList;
    }
}
