package org.bffl.dbConnector.dao.idClasses;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.bffl.dbConnector.dao.types.Protocoll;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Composite_available_protocolls_id implements Serializable {

    @Column
    @Enumerated(EnumType.STRING)
    private Protocoll protocoll_name;

    @Column
    private Timestamp timestamp;

    @Column
    private String target_url;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Composite_available_protocolls_id id1 = (Composite_available_protocolls_id) o;
        return (protocoll_name != id1.protocoll_name | timestamp != id1.timestamp | target_url != id1.target_url) ? false : true;
    }

    @Override
    public int hashCode() {
        int result = this.protocoll_name.hashCode();
        result = 31 * result + this.timestamp.hashCode();
        result = 31 * result + this.target_url.hashCode();
        return result;
    }
}
