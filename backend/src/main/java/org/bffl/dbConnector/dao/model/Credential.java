package org.bffl.dbConnector.dao.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
    private String user_id;

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

}
