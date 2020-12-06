package org.bffl.dao.model;

import org.bffl.dao.types.IP_Adress;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "url_call")
public class Url_call {

    @Id
    private String shortURLName;

    @Id
    private String shortURLGroupID;

    @Id
    private Timestamp timestamp;

    @Id
    private String ip;

    @Column
    private String rgion;

}
