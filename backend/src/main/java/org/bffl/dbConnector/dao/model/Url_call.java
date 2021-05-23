package org.bffl.dbConnector.dao.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bffl.dbConnector.dao.idClasses.Composite_url_call_id;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "url_call", schema = "bffl")
public class Url_call {

    @EmbeddedId
    private Composite_url_call_id id;

    @MapsId("short_url_id")
    @ManyToOne(targetEntity = Short_url.class, cascade = CascadeType.ALL)
    @JoinColumn(name="short_url_id", nullable=false)
    private Short_url url_call_short_url;

}

