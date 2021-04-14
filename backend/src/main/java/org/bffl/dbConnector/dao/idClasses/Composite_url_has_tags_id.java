package org.bffl.dbConnector.dao.idClasses;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Composite_url_has_tags_id implements Serializable {

    @Column
    private String short_url_id;

    @Column
    private String tag_id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Composite_url_has_tags_id id1 = (Composite_url_has_tags_id) o;
        return (short_url_id != id1.short_url_id | tag_id != id1.tag_id) ? false : true;
    }

    @Override
    public int hashCode() {
        int result = this.short_url_id.hashCode();
        result = 31 * result + this.tag_id.hashCode();
        return result;
    }
}
