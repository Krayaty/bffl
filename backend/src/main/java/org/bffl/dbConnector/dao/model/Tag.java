package org.bffl.dbConnector.dao.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(
        name = "tag",
        schema = "bffl",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"group_name", "id"})}
        )
public class Tag {

    @Id
    private int id;

    @Column
    private String title;

    @Column
    private String description;

    @Column(length = 6)
    @Type(type = "char")
    private String color;

    @ManyToOne(targetEntity = App_group.class, cascade = CascadeType.ALL)
    @JoinColumn(name="group_name", nullable=false)
    private App_group tag_group;

    @OneToMany(mappedBy = "url_has_tags_tag", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Url_has_tag> tag_url_has_tags;

}
