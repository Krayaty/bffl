package org.bffl.dbConnector.dao.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bffl.dbConnector.dao.idClasses.Composite_url_history_id;

import javax.persistence.*;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "url_history", schema = "bffl")
public class Url_history {

    @EmbeddedId
    private Composite_url_history_id id;

    @MapsId("target_url_name")
    @ManyToOne(targetEntity = Target_url.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "target_url_name")
    private Target_url url_history_target_url;

    @MapsId("short_url_id")
    @ManyToOne(targetEntity = Short_url.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "short_url_id")
    private Short_url url_history_short_url;

}

