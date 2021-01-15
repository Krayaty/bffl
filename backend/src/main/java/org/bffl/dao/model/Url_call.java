package org.bffl.dao.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bffl.dao.types.IP_Adress;
import javax.persistence.*;
import java.sql.Timestamp;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@Entity
@IdClass(CompositeURL_call_Id.class)
@Table(name = "url_call")
public class Url_call {

    @Id
    private String shortURLName;

    @Id
    private int shortURLGroupID;

    @Id
    private Timestamp timestamp;

    @Id
    private String ip;

    @Column
    private String rgion;

}

class CompositeURL_call_Id implements Serializable{

    private String shortURLName;
    private int shortURLGroupID;
    private Timestamp timestamp;
    private String ip;

    public CompositeURL_call_Id(){}

    public CompositeURL_call_Id(String shortURLName, int shortURLGroupID, Timestamp timestamp, String ip){
        this.shortURLName = shortURLName;
        this.shortURLGroupID = shortURLGroupID;
        this.timestamp = timestamp;
        this.ip = ip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompositeURL_call_Id id1 = (CompositeURL_call_Id) o;
        return (shortURLName != id1.shortURLName | shortURLGroupID != id1.shortURLGroupID | timestamp != id1.timestamp | ip != id1.ip) ? false: true;
    }

    @Override
    public int hashCode() {
        int result = (int) (this.shortURLGroupID ^ (this.shortURLGroupID >>> 32));
        result = 31 * result + this.shortURLName.hashCode();
        result = 31 * result + this.timestamp.hashCode();
        result = 31 * result + this.ip.hashCode();
        return result;
    }
}
