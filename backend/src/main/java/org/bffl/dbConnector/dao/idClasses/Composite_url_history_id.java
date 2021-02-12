package org.bffl.dbConnector.dao.idClasses;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
public class Composite_url_history_id implements Serializable {

    private String target_url_name;
    private String short_url_id;
    private Timestamp timestamp;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Composite_url_history_id id1 = (Composite_url_history_id) o;
        return (target_url_name != id1.target_url_name | short_url_id != id1.short_url_id | timestamp != id1.timestamp) ? false : true;
    }

    @Override
    public int hashCode() {
        int result = this.short_url_id.hashCode();
        result = 31 * result + this.target_url_name.hashCode();
        result = 31 * result + this.timestamp.hashCode();
        return result;
    }
}
