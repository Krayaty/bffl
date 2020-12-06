package org.bffl.dao.model;

import org.bffl.dao.types.Protocoll;
import org.bffl.dao.types.Security;

import javax.persistence.*;

@Entity
@Table(name = "protocolls")
public class Protocolls {

    @Id
    private Protocoll name;

    @Column
    private Security security;

    @Version
    @Column
    private String version;

}
