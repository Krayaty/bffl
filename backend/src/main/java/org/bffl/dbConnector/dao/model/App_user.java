package org.bffl.dbConnector.dao.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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
/*
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail_constraint() {
        return email_constraint;
    }

    public void setEmail_constraint(String email_constraint) {
        this.email_constraint = email_constraint;
    }

    public boolean isEmail_verified() {
        return email_verified;
    }

    public void setEmail_verified(boolean email_verified) {
        this.email_verified = email_verified;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getFederation_link() {
        return federation_link;
    }

    public void setFederation_link(String federation_link) {
        this.federation_link = federation_link;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getRealm_id() {
        return realm_id;
    }

    public void setRealm_id(String realm_id) {
        this.realm_id = realm_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getCreated_timestamp() {
        return created_timestamp;
    }

    public void setCreated_timestamp(long created_timestamp) {
        this.created_timestamp = created_timestamp;
    }

    public String getService_account_client_link() {
        return service_account_client_link;
    }

    public void setService_account_client_link(String service_account_client_link) {
        this.service_account_client_link = service_account_client_link;
    }

    public int getNot_before() {
        return not_before;
    }

    public void setNot_before(int not_before) {
        this.not_before = not_before;
    }*/
}
