package org.bffl.dbConnector.dao.types.postParamTypes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class POST_TagToShortURLAssignment {

    private int tag_id;
    private  int short_url_id;

}
