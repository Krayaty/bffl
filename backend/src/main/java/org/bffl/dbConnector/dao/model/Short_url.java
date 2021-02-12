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
@Table(name = "short_url", schema = "bffl")
public class Short_url {

    @Id
    private String id;

    @Column
    private String group_id;

    @Column
    private int scope;

    @Column
    private String custom_suffix;

    @Column
    private boolean update_flag;

    @Column
    private boolean delete_flag;

}
