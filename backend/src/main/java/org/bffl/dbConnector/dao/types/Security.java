package org.bffl.dbConnector.dao.types;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Security {
    ENCRYPTED("encrypted"),
    NOT_ENCRYPTED("not encrypted");

    private String msg;

    public String getMsg() {
        return msg;
    }
}
