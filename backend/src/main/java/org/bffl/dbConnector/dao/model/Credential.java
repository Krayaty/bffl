package org.bffl.dbConnector.dao.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "credential", schema = "public")
public class Credential {

    @Id
    private String id;

    @Column
    private String type;

    @Column
    private long created_date;

    @Column
    private String user_label;

    @Column
    private String secret_data;

    @Column
    private String credential_data;

    @Column
    private int priority;

    @ManyToOne(targetEntity = App_user.class, cascade = CascadeType.ALL)
    @JoinColumn(name="user_id", nullable=false)
    private App_user credential_user;

}
