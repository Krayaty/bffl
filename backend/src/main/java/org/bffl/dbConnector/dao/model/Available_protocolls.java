package org.bffl.dbConnector.dao.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bffl.dbConnector.dao.idClasses.Composite_available_protocolls_id;
import org.bffl.dbConnector.dao.types.Protocoll;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "available_protocolls", schema = "bffl")
public class Available_protocolls {

    @EmbeddedId
    private Composite_available_protocolls_id id;

    @MapsId("target_url")
    @ManyToOne(targetEntity = Target_url.class, cascade = CascadeType.ALL)
    @JoinColumn(name="target_url", nullable=false)
    private Target_url available_protocolls_target_url;

}

