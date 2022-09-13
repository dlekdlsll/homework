package com.example.fourthweek2.store;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name="member")
public class Member implements Serializable {
    private static final long serialVersionUID = 810457109758530244L;

    @Id
    @Column(name="id")
    private String id;

    @Id
    @Column(name="date")
    private Date date;

    @Column(name="name")
    private String name;

    @Column(name="address")
    private String address;

    @Column(name="phoneNumber")
    private String phoneNumber;
}
