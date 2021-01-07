package org.bffl.dao.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@Entity
@IdClass(CompositeURL_has_tags_Id.class)
@Table(name = "url_has_tags")
public class Url_has_tags {

    @Id
    private String shortURLName;

    @Id
    private int shortURLGroupID;

    @Id
    private String tagName;

}

class CompositeURL_has_tags_Id implements Serializable {

    private String shortURLName;
    private int shortURLGroupID;
    private String tagName;

    public CompositeURL_has_tags_Id() {
    }

    public CompositeURL_has_tags_Id(String shortURLName, int shortURLGroupID, String tagName) {
        this.shortURLName = shortURLName;
        this.shortURLGroupID = shortURLGroupID;
        this.tagName = tagName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompositeURL_has_tags_Id id1 = (CompositeURL_has_tags_Id) o;
        return (shortURLName != id1.shortURLName | shortURLGroupID != id1.shortURLGroupID | tagName != id1.tagName) ? false : true;
    }

    @Override
    public int hashCode() {
        int result = (int) (this.shortURLGroupID ^ (this.shortURLGroupID >>> 32));
        result = 31 * result + this.shortURLName.hashCode();
        result = 31 * result + this.tagName.hashCode();
        return result;
    }
}
