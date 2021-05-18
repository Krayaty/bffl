package org.bffl.dbConnector.dao.types.postParamTypes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class POST_AdminToGroupAssignment {

    private String group_name;
    private String user_id;
    private Integer end_timestamp;
    private Boolean admin_flag;

    public POST_AdminToGroupAssignment(String group_name, String user_id, Integer end_timestamp, Boolean admin_flag) {
        this.group_name = group_name;
        this.user_id = user_id;
        this.admin_flag = admin_flag;
        int currentTime = (int) System.currentTimeMillis() / 1000 + 3600;
        if(end_timestamp < currentTime)
            end_timestamp = currentTime;
        this.end_timestamp = end_timestamp;
    }
}
