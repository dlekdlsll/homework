package com.example.fourthweek2.store;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

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
        this.id = strId;
        this.regdate = String.format("%tF", now);
    }
}
