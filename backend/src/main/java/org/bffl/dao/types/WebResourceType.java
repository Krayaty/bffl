package org.bffl.dao.types;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum WebResourceType {

    WEBPAGE("Webpage"),
    WEBSERVICE("Webservice"),
    OTHER("Other");

    private String msg;

}
