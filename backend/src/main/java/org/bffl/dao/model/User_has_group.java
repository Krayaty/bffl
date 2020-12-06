package org.bffl.dao.model;

import javax.persistence.*;

@Entity
@Table(name = "user_has_group")
public class User_has_group {

    @Id
    private String userEmail;

    @Id
    private int groupID;

    @Column
    private boolean adminFlag;

}
