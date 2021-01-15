package org.bffl.dao.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.h2.util.HashBase;

import javax.persistence.*;

@NoArgsConstructor
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

    public String getEmail(){
        return this.email;
    }

    public String getFName(){
        return this.fName;
    }

    public String getSName(){
        return this.sName;
    }

    public String getPw(){
        return this.pw;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public void setSName(String sName) {
        this.sName = sName;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }
}
