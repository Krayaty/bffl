package org.bffl.dbConnector.dao.types.postParamTypes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShortURLWithTargetAndTags {
    private String group_name;
    private String custom_suffix;
    private int scope;
    private boolean delete_flag;
    private boolean update_flag;
    private String target_url;
    private Integer[] assigned_tag_ids;

    public ShortURLWithTargetAndTags(String group_name,
                                     String custom_suffix,
                                     int scope,
                                     boolean delete_flag,
                                     boolean update_flag,
                                     String target_url,
                                     String[] assigned_tag_ids){

        this.group_name = group_name;
        this.custom_suffix = custom_suffix;
        this.scope = scope;
        this.delete_flag = delete_flag;
        this.update_flag = update_flag;
        this.target_url = target_url;
        this.assigned_tag_ids = new Integer[assigned_tag_ids.length];
        if(this.assigned_tag_ids.length != 0){
            for (int i = 0; i < assigned_tag_ids.length; i++) {
                if(assigned_tag_ids[i] != "" && assigned_tag_ids[i] != " ")
                    this.assigned_tag_ids[i] = Integer.parseInt(assigned_tag_ids[i]);
            }
        }
    }
}
