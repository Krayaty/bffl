package org.bffl.dbConnector.dao.idClasses;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
public class Composite_url_has_tags_id implements Serializable {

    private String short_url_id;
    private String tag_name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Composite_url_has_tags_id id1 = (Composite_url_has_tags_id) o;
        return (short_url_id != id1.short_url_id | tag_name != id1.tag_name) ? false : true;
    }

    @Override
    public int hashCode() {
        int result = this.short_url_id.hashCode();
        result = 31 * result + this.tag_name.hashCode();
        return result;
    }
}
