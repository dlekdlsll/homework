package com.example.fourthweek2.store;

import lombok.Getter;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Getter
public class MemberId implements Serializable {
    @Column(name = "id")
    private String id;

    @Column(name = "regdate")
    private String regdate;

    public MemberId() {
        Date now = new Date();
        String strId = UUID.randomUUID().toString();
        String now2 = String.format("%tF", now) +" " +String.format("%tT", now);
        this.id = strId;
        this.regdate = now2;
    }

    public MemberId(String id, String regdate) {
        this.id = id;
        this.regdate = regdate;
    }
}
