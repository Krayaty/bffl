package org.bffl.dbConnector.dao.idClasses;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Composite_assigned_target_id implements Serializable {

    @Column
    private int short_url_id;

    @Column
    private Timestamp assign_timestamp;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Composite_assigned_target_id id1 = (Composite_assigned_target_id) o;
        return (short_url_id != id1.short_url_id | assign_timestamp != id1.assign_timestamp) ? false : true;
    }

    @Override
    public int hashCode() {
        int result = this.short_url_id;
        result = 31 * result + this.assign_timestamp.hashCode();
        return result;
    }
}
