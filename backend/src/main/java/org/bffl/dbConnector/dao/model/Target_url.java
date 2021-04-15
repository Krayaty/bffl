package org.bffl.dbConnector.dao.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bffl.dbConnector.dao.types.Protocoll;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "target_url", schema = "bffl")
public class Target_url {

    @Id
    private String name;

    @Column
    private String owner;

    @Column
    private String type;

    @Column
    @Enumerated(EnumType.STRING)
    private Protocoll protocoll_name;

    @OneToMany(mappedBy = "url_history_target_url", cascade = CascadeType.ALL)
    private Set<Url_history> target_url_url_histories;

}
