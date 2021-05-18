package org.bffl.dbConnector.dao.types.postParamTypes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class POST_Tag {

    private int tag_id;
    private String title;
    private String description;
    private String color;

    public POST_Tag(int tag_id, String title, String description, String color) {
        this.tag_id = tag_id;
        this.title = title;
        this.description = description;
        this.color = color;
    }

    private boolean isColorCode(String color){
        if(color.length() != 6)
            return false;

        for (int i = 0; i < color.length(); i++) {
            if(!isHex(color))
                return false;
        }

        return true;
    }

    private boolean isHex(String color){
        try{
            Long.parseLong(color, 16);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
