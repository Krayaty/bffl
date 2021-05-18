package org.bffl.dbConnector.dao.types.postParamTypes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class POST_UserToGroupAssignmentWithoutTimestamp {

    private String group_name;
    private String user_id;

}
