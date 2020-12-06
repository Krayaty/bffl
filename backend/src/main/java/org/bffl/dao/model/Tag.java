package org.bffl.dao.model;

import javax.persistence.*;
import java.awt.*;

@Entity
@Table(name = "tag")
public class Tag {

    @Id
    private String name;

    @Column
    private String description;

    @Column
    private Color color;

}
