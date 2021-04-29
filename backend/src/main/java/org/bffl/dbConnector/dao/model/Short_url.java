package org.bffl.dbConnector.dao.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(
        name = "short_url",
        schema = "bffl",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"group_name", "custom_suffix"})}
        )
public class Short_url {

    @Id
    private int id;

    @Column
    private int scope;

    @Column
    private String custom_suffix;

    @Column
    private boolean update_flag;

    @Column
    private boolean delete_flag;

    @Column
    private Timestamp create_timestamp;

    @OneToMany(mappedBy = "url_has_tags_short_url")
    @JsonIgnore
    private Set<Url_has_tag> short_url_url_has_tags;

    @ManyToOne(targetEntity = App_group.class, cascade = CascadeType.ALL)
    @JoinColumn(name="group_name", nullable=false)
    private App_group short_url_group;

    @OneToMany(mappedBy = "url_call_short_url", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Url_call> short_url_url_calls;

    @OneToMany(mappedBy = "url_history_short_url", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Assigned_target> short_url_assigned_targets;

}
