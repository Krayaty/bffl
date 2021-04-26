package org.bffl.dbConnector.dao.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_entity", schema = "public")
public class App_user {

    @Id
    private String id;

    @Column
    private String email;

    @Column
    private String email_constraint;

    @Column
    private boolean email_verified;

    @Column
    private boolean enabled;

    @Column
    private String federation_link;

    @Column
    private String first_name;

    @Column
    private String last_name;

    @Column
    private String realm_id;

    @Column
    private String username;

    @Column
    private long created_timestamp;

    @Column
    private String service_account_client_link;

    @Column
    private int not_before;

    @OneToMany(mappedBy="user_has_group_user", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<User_has_group> user_user_has_groups;

    @OneToMany(mappedBy="credential_user", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Credential> user_credentials;

}
