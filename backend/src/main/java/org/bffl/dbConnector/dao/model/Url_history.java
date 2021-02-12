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
@IdClass(Composite_url_history_id.class)
@Table(name = "url_history", schema = "bffl")
public class Url_history {

    @Id
    private String target_url_name;

    @Id
    private String short_url_id;

    @Id
    private Timestamp timestamp;

}

