package org.bffl.dbConnector.dao.idClasses;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
public class Composite_url_call_id implements Serializable {

    private String short_url_id;
    private Timestamp timestamp;
    private int[] client_ip;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Composite_url_call_id id1 = (Composite_url_call_id) o;
        return (short_url_id != id1.short_url_id | timestamp != id1.timestamp | client_ip != id1.client_ip) ? false : true;
    }

    @Override
    public int hashCode() {
        int result = this.short_url_id.hashCode();
        result = 31 * result + this.timestamp.hashCode();
        result = 31 * result + this.client_ip.hashCode();
        return result;
    }
}
