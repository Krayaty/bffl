package org.bffl.dbConnector.dao.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bffl.dbConnector.dao.idClasses.Composite_assigned_target_id;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "assigned_target", schema = "bffl")
public class Assigned_target {

    @EmbeddedId
    private Composite_assigned_target_id id;

    @Column
    private String url;

    @MapsId("short_url_id")
    @ManyToOne(targetEntity = Short_url.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "short_url_id")
    private Short_url url_history_short_url;

}

