package org.bffl.dbConnector.dao.types;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum WebResourceType {

    WEBPAGE("Webpage"),
    WEBSERVICE("Webservice"),
    OTHER("Other");

    private String msg;

    public String getMsg() {
        return msg;
    }
}
