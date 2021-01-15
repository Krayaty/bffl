package org.bffl.dao.types;

import lombok.Getter;
import lombok.Setter;

import java.security.InvalidParameterException;

@Getter
@Setter
public class IP_Adress {

    private int first;

    private int second;

    private int third;

    private int fourth;

    private int port = -1;

    public IP_Adress(String[] ip){

        if(!isValidIp(ip)){
            throw new InvalidParameterException();
        }

        this.first = Integer.parseInt(ip[0]);
        this.second = Integer.parseInt(ip[1]);
        this.third = Integer.parseInt(ip[2]);
        this.fourth = Integer.parseInt(ip[3]);

    }

    public IP_Adress(String[] ip, String port){
        new IP_Adress(ip);

        if(!isValidPort(port)){
            throw new InvalidParameterException();
        }

        this.port = Integer.parseInt(port);
    }

    public String getIP(){
        String res = this.first + "." + this.second + "." + this.third + "." + this.fourth;
        res += (port != -1)? ":" + this.port : "";
        return res;
    }

    public static boolean isValidIp(String[] ip){
        int[] ipParts = new int[ip.length];

        if(ipParts.length != 4){
            return false;
        }

        for(int i = 0; i < ip.length; i++){
            try{
                ipParts[i] = Integer.parseInt(ip[i]);
            } catch(Exception e){
                e.printStackTrace();
                return false;
            }
        }

        if(!(ipParts[0] >= 192 && ipParts[0] <= 233) |
           !(ipParts[1] >= 0 && ipParts[1] <= 255) |
           !(ipParts[2] >= 0 && ipParts[2] <= 255) |
           !(ipParts[3] >= 0 && ipParts[3] <= 255)){

            return false;
        }

        return true;
    }

    public static boolean isValidPort(String port){

        int portNum;
        try{
            portNum = Integer.parseInt(port);
        } catch(Exception e){
            e.printStackTrace();
            return false;
        }

        if(!(portNum >= 0 && portNum <= 65535)){
            return false;
        }

        return true;
    }

}
