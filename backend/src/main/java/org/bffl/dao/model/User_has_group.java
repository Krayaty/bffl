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
@IdClass(CompositeUser_has_Group_Id.class)
@Table(name = "user_has_group")
public class User_has_group {

    @Id
    private String userEmail;

    @Id
    private int groupID;

    @Column
    private boolean adminFlag;

}

class CompositeUser_has_Group_Id implements Serializable {

    private String userEmail;
    private int groupID;

    public CompositeUser_has_Group_Id() {
    }

    public CompositeUser_has_Group_Id(String userEmail, int groupID) {
        this.userEmail = userEmail;
        this.groupID = groupID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompositeUser_has_Group_Id id1 = (CompositeUser_has_Group_Id) o;
        return (userEmail != id1.userEmail | groupID != id1.groupID) ? false : true;
    }

    @Override
    public int hashCode() {
        int result = (int) (this.groupID ^ (this.groupID >>> 32));
        result = 31 * result + this.userEmail.hashCode();
        return result;
    }
}
