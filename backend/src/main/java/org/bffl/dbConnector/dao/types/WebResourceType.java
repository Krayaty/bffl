package org.bffl.dbConnector.dao.types;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum WebResourceType {

    WEBPAGE("Website"),
    WEBSERVICE("Webservice"),
    OTHER("Other");

    private String msg;

}
