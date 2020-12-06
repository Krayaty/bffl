package org.bffl.dao.model;

import org.h2.util.HashBase;

import javax.persistence.*;

@Entity
@Table(name = "app_user")
public class App_user {

    @Id
    private String email;

    @Column
    private String fName;

    @Column
    private String sName;

    @Column
    private String pw;

}
