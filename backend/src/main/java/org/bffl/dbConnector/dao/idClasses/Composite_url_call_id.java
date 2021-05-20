package org.bffl.dbConnector.dao.idClasses;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Arrays;

@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Composite_url_call_id implements Serializable {

    @Column
    private int short_url_id;

    @Column
    private Timestamp call_timestamp;

    @Column
    private String client_ip;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Composite_url_call_id id1 = (Composite_url_call_id) o;
        return (short_url_id != id1.short_url_id | call_timestamp != id1.call_timestamp | client_ip != id1.client_ip) ? false : true;
    }

    @Override
    public int hashCode() {
        int result = this.short_url_id;
        result = 31 * result + this.call_timestamp.hashCode();
        result = 31 * result + this.client_ip.hashCode();
        return result;
    }
}
