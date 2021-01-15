package org.bffl.dao.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bffl.dao.types.Protocoll;
import org.bffl.dao.types.Security;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "protocolls")
public class Protocolls {

    @Id
    private Protocoll name;

    @Column
    private Security security;

    @Column
    private String version;

}
