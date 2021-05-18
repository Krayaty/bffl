package org.bffl.dbConnector.dao.types.postParamTypes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class POST_UserToGroupAssignment {

    private String group_name;
    private String user_id;
    private Integer end_timestamp;

    public POST_UserToGroupAssignment(String group_name, String user_id, Integer end_timestamp) {
        this.group_name = group_name;
        this.user_id = user_id;
        int currentTime = (int) System.currentTimeMillis() / 1000 + 3600;
        if(end_timestamp < currentTime)
            end_timestamp = currentTime;
        this.end_timestamp = end_timestamp;
    }
}
