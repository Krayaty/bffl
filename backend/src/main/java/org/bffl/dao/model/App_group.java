package org.bffl.dao.model;

import javax.persistence.*;

@Entity
@Table(name = "app_group")
public class App_group {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String name;

    @Column
    private int maxSize;

}
