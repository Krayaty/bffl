package org.bffl.dao.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bffl.dao.types.Protocoll;
import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@Entity
@IdClass(CompositeAvailable_protocolls_Id.class)
@Table(name = "available_protocolls")
public class Available_protocolls {

    @Id
    private Protocoll name;

    @Id
    private Timestamp timestamp;

    @Id
    private String targetURLName;

}

class CompositeAvailable_protocolls_Id implements Serializable {

    private Protocoll name;
    private Timestamp timestamp;
    private String targetURLName;

    public CompositeAvailable_protocolls_Id() {
    }

    public CompositeAvailable_protocolls_Id(Protocoll name, Timestamp timestamp, String targetURLName) {
        this.name = name;
        this.timestamp = timestamp;
        this.targetURLName = targetURLName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompositeAvailable_protocolls_Id id1 = (CompositeAvailable_protocolls_Id) o;
        return (name != id1.name | timestamp != id1.timestamp | targetURLName != id1.targetURLName) ? false : true;
    }

    @Override
    public int hashCode() {
        int result = this.name.hashCode();
        result = 31 * result + this.timestamp.hashCode();
        result = 31 * result + this.targetURLName.hashCode();
        return result;
    }
}
