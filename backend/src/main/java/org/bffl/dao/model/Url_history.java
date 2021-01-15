package org.bffl.dao.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@Entity
@IdClass(CompositeURL_history_Id.class)
@Table
public class Url_history {

    @Id
    private String targetURLName;

    @Id
    private String shortURLName;

    @Id
    private int shortURLGroupID;

    @Id
    private Timestamp timestamp;

}

class CompositeURL_history_Id implements Serializable {

    private String shortURLName;
    private String targetURLName;
    private int shortURLGroupID;
    private Timestamp timestamp;

    public CompositeURL_history_Id() {
    }

    public CompositeURL_history_Id(String shortURLName, String targetURLName, int shortURLGroupID, Timestamp timestamp) {
        this.shortURLName = shortURLName;
        this.targetURLName = targetURLName;
        this.shortURLGroupID = shortURLGroupID;
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompositeURL_history_Id id1 = (CompositeURL_history_Id) o;
        return (shortURLName != id1.shortURLName | targetURLName != id1.targetURLName | shortURLGroupID != id1.shortURLGroupID | timestamp != id1.timestamp) ? false : true;
    }

    @Override
    public int hashCode() {
        int result = (int) (this.shortURLGroupID ^ (this.shortURLGroupID >>> 32));
        result = 31 * result + this.shortURLName.hashCode();
        result = 31 * result + this.targetURLName.hashCode();
        result = 31 * result + this.timestamp.hashCode();
        return result;
    }
}
