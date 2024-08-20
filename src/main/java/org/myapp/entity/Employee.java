package org.myapp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employee_tbl")
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    /**
     * FetchType.LAZY means when selecting the employee, access card not fetching in initial state.
     * when selecting the access card of employee, it will be fetch.
     */
    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)//persist access card when persisting the employee
    AccessCard accessCard;

}
