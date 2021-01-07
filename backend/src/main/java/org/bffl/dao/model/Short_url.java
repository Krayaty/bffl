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
@IdClass(CompositeShort_URL_Id.class)
@Table(name = "short_url")
public class Short_url {

    @Id
    private String name;

    @Id
    private int groupID;

    @Column
    private int scope;

    @Column
    private String customSuffix;

    @Column
    private boolean updateFlag;

    @Column
    private boolean deleteFlag;

}

class CompositeShort_URL_Id implements Serializable{

    private String name;
    private int groupID;

    public CompositeShort_URL_Id(){}

    public CompositeShort_URL_Id(String name, int groupID){
        this.name = name;
        this.groupID = groupID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompositeShort_URL_Id id1 = (CompositeShort_URL_Id) o;
        return (name != id1.name | groupID != id1.groupID) ? false: true;
    }

    @Override
    public int hashCode() {
        int result = (int) (this.groupID ^ (this.groupID >>> 32));
        result = 31 * result + this.name.hashCode();
        return result;
    }
}

