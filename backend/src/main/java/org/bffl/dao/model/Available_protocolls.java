package org.bffl.dao.model;

import org.bffl.dao.types.Protocoll;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "available_protocolls")
public class Available_protocolls {

    @Id
    private Protocoll name;

    @Id
    private Timestamp timestamp;

    @Id
    private String targetURLName;

}
