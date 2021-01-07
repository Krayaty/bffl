package org.bffl.dao.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.h2.util.HashBase;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "app_user")
public class App_user {

    @Id
    private String email;

    @Column
    private String fName;

    @Column
    private String sName;

    @Column
    private String pw;

}
