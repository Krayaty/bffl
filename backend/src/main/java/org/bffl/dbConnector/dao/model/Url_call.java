package org.bffl.dbConnector.dao.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bffl.dbConnector.dao.idClasses.Composite_url_call_id;

import javax.persistence.*;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "url_call", schema = "bffl")
public class Url_call {

    @EmbeddedId
    private Composite_url_call_id id;

    @MapsId("short_url_id")
    @ManyToOne(targetEntity = Short_url.class, cascade = CascadeType.ALL)
    @JoinColumn(name="short_url_id", nullable=false)
    private Short_url url_call_short_url;

    @Column
    private String region;

    public static boolean isValidIp(String sIp){
        int[] ip = {
          Integer.parseInt(sIp.substring(0,3)),
          Integer.parseInt(sIp.substring(3,6)),
          Integer.parseInt(sIp.substring(6,9)),
          Integer.parseInt(sIp.substring(9,12)),
        };

        if(!(ip[0] >= 192 && ip[0] <= 233) |
                !(ip[1] >= 0 && ip[1] <= 255) |
                !(ip[2] >= 0 && ip[2] <= 255) |
                !(ip[3] >= 0 && ip[3] <= 255)){

            return false;
        }

        return true;
    }

}

