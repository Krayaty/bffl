package org.bffl.dbConnector.dao.types.postParamTypes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class POST_Group {

    private String group_name;
    private int max_size;

    public POST_Group(String group_name, int max_size) {
        this.group_name = group_name;
        if(max_size < 1)
            max_size = 1;
        this.max_size = max_size;
    }
}
