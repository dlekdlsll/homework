package com.example.fourthweek2.store;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="member")
public class Member{

    @EmbeddedId
    private MemberId id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Builder
    public Member(String name, String phoneNumber, String address) {
        this.id = new MemberId();
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
}