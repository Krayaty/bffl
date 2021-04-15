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
@Table(
        name = "short_url",
        schema = "bffl",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"group_id", "custom_suffix"})}
        )
public class Short_url {

    @Id
    private String id;

    @Column
    private int scope;

    @Column
    private String custom_suffix;

    @Column
    private boolean update_flag;

    @Column
    private boolean delete_flag;

    @OneToMany(mappedBy = "url_has_tags_short_url")
    private Set<Url_has_tags> short_url_url_has_tags;

    @ManyToOne(targetEntity = App_group.class, cascade = CascadeType.ALL)
    @JoinColumn(name="group_id", nullable=false)
    private App_group short_url_group;

    @OneToMany(mappedBy = "url_call_short_url", cascade = CascadeType.ALL)
    private Set<Url_call> short_url_url_calls;

    @OneToMany(mappedBy = "url_history_short_url", cascade = CascadeType.ALL)
    private Set<Url_history> short_url_url_histories;

}
