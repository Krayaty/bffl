package org.bffl.dbConnector.dao.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.bffl.dbConnector.dao.types.Protocoll;
import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "protocolls", schema = "bffl")
public class Protocolls {

    @Id
    private String name;

    @Column
    private String security;

    @Column
    private String version;

    public Protocolls(Protocoll p, String version) {
        this.name = p.getBez();
        this.security = p.getSecurity().getMsg();
        this.version = version;
    }

    public void setP(Protocoll p) {
        this.name = p.getBez();
        this.security = p.getSecurity().getMsg();
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
