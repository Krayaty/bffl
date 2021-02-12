package org.bffl.dbConnector.dao.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bffl.dbConnector.dao.idClasses.Composite_available_protocolls_id;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@IdClass(Composite_available_protocolls_id.class)
@Table(name = "available_protocolls", schema = "bffl")
public class Available_protocolls {

    @Id
    private String protocoll_name;

    @Id
    private Timestamp timestamp;

    @Id
    private String target_url;

}

