package org.bffl.dbConnector.dao.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tag", schema = "bffl")
public class Tag {

    @Id
    private String name;

    @Column
    private String description;

    @Column
    private String color;

    @ManyToOne(targetEntity = App_group.class, cascade = CascadeType.ALL)
    @JoinColumn(name="group_id", nullable=false)
    private App_group tag_group;

    @OneToMany(mappedBy = "url_has_tags_tag", cascade = CascadeType.ALL)
    private Set<Url_has_tags> tag_url_has_tags;

}
