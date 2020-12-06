package org.bffl.dao.model;

import javax.persistence.*;

@Entity
@Table(name = "url_has_tags")
public class Url_has_tags {

    @Id
    private String shortURLName;

    @Id
    private String shortURLGroupID;

    @Id
    private String tagName;

}
