package uz.hibernateapp.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "db_student")
@Setter
@Getter
public class StudentEntity extends BaseEntity{
    @Column(name = "firstName")
    private String firstName;

    @Column(name = "secondName")
    private String secondName;

    @Column(name = "middleName")
    private String middlename;
}
