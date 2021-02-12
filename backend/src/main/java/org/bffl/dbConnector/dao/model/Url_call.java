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
@IdClass(Composite_url_call_id.class)
@Table(name = "url_call", schema = "bffl")
public class Url_call {

    @Id
    private String short_url_id;

    @Id
    private Timestamp timestamp;

    @Id
    private String client_ip;

    @Column
    private String region;

    public int[] clientIpToArray(String ip){
        int[] ipArray = new int[4];
        if(ip.length() > 15) return null;

        String help = "";
        int field = 0;
        for(int i = 0; i < ip.length(); i++){
            if(ip.toCharArray()[i] == '.'){
                ipArray[field] = Integer.parseInt(help);
                if(ipArray[field] < 0 | ipArray[field] > 255) return null;
                field++;
                help = "";
            } else {
                help += ip.toCharArray()[i];
            }
        }

        return ipArray;
    }

    public static boolean isValidIp(int[] ip){

        if(!(ip[0] >= 192 && ip[0] <= 233) |
                !(ip[1] >= 0 && ip[1] <= 255) |
                !(ip[2] >= 0 && ip[2] <= 255) |
                !(ip[3] >= 0 && ip[3] <= 255)){

            return false;
        }

        return true;
    }

}

