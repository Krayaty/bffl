package org.bffl.dao.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.awt.*;

@Getter
@Setter
@AllArgsConstructor
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
