package com.example.fourthweek2.store;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Data
public class MemberId implements Serializable {
    @Column(name = "id")
    private String id;

    @Column(name = "regdate")
    private Date regdate;

    public MemberId() {
        this.id = UUID.randomUUID().toString();
        this.regdate = new Date();
    }
}
