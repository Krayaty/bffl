package org.bffl.dbConnector.dao.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bffl.dbConnector.dao.idClasses.Composite_user_has_group_id;

import java.sql.Timestamp;
import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@IdClass(Composite_user_has_group_id.class)
@Table(name = "user_has_group", schema = "bffl")
public class User_has_group {

    @Id
    private String user_id;

    @Id
    private String group_id;

    @Column
    private Timestamp start_timestamp;

    @Column
    private Timestamp end_timestamp;

}

