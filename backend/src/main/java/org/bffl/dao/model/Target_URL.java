package org.bffl.dao.model;

import org.bffl.dao.types.WebResourceType;

import javax.persistence.*;

@Entity
@Table(name = "target_url")
public class Target_URL {

    @Id
    private String name;

    @Column
    private String owner;

    @Column
    private WebResourceType type;

}
