package org.bffl.dbConnector.dao.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "app_group", schema = "bffl")
public class App_group {

    @Id
    private String name;

    @Column
    private int max_size;

    @OneToMany(mappedBy="tag_group", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Tag> group_tags;

    @OneToMany(mappedBy="short_url_group", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Short_url> group_short_urls;

    @OneToMany(mappedBy="user_has_group_group", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<User_has_group> group_user_has_groups;

}
