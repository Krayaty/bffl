package org.bffl.dbConnector.dao.idClasses;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Composite_user_has_group_id implements Serializable {

    @Column
    private String user_id;

    @Column
    private String group_name;

    @Column
    private Timestamp start_timestamp;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Composite_user_has_group_id id1 = (Composite_user_has_group_id) o;
        return (user_id != id1.user_id | group_name != id1.group_name | start_timestamp != id1.start_timestamp) ? false : true;
    }

    @Override
    public int hashCode() {
        int result = this.group_name.hashCode();
        result = 31 * result + this.user_id.hashCode();
        result = 31 * result + this.start_timestamp.hashCode();
        return result;
    }
}
