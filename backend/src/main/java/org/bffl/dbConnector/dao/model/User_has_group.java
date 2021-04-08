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
@Table(name = "user_has_group", schema = "bffl")
public class User_has_group {

    @EmbeddedId
    private Composite_user_has_group_id id;

    @MapsId("user_id")
    @ManyToOne(targetEntity = App_user.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private App_user user_has_group_user;

    @MapsId("group_id")
    @ManyToOne(targetEntity = App_group.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "group_id")
    private App_group user_has_group_group;

    @Column
    private Timestamp start_timestamp;

    @Column
    private Timestamp end_timestamp;

}

