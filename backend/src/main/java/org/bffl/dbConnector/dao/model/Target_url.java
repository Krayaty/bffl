package org.bffl.dbConnector.dao.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "target_url", schema = "bffl")
public class Target_url {

    @Id
    private String name;

    @Column
    private String owner;

    @Column
    private String type;

}
