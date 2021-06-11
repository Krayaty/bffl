package org.bffl.dbConnector.dao.types.postParamTypes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class POST_ModificationFlag {

    private int short_url_id;
    private boolean flag;

}
