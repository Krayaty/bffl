package org.bffl.dao.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bffl.dao.types.WebResourceType;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
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
