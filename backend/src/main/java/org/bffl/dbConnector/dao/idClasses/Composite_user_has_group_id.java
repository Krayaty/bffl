package org.bffl.dbConnector.dao.idClasses;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
public class Composite_user_has_group_id implements Serializable {

    private String user_id;
    private String group_id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Composite_user_has_group_id id1 = (Composite_user_has_group_id) o;
        return (user_id != id1.user_id | group_id != id1.group_id) ? false : true;
    }

    @Override
    public int hashCode() {
        int result = this.group_id.hashCode();
        result = 31 * result + this.user_id.hashCode();
        return result;
    }
}
