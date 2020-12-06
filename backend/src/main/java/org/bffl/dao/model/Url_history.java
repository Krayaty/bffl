package org.bffl.dao.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table
public class Url_history {

    @Id
    private String targetURLName;

    @Id
    private String shortURLName;

    @Id
    private int shortURLGroupID;

    @Id
    private Timestamp timestamp;

}
