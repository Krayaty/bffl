package org.bffl.dbConnector.dao.types.postParamTypes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class POST_TargetUrl {
    private String target_url;
    private int short_url_id;
}
