package org.bffl.dbConnector.dao.types.postParamTypes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class POST_ShortURL {

    private int short_url_id;
    private String custom_suffix;
    private int scope;
    private Boolean delete_flag;
    private Boolean update_flag;
    private String target_url;

}
