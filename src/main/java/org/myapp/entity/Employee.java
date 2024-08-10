package org.myapp.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee_tbl")
@Builder
@Getter
@Setter
@ToString
public class Employee {

    @Id
    private Integer id;
    private String name;

}
