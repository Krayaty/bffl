package org.bffl.dao.model;

import javax.persistence.*;

@Entity
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
