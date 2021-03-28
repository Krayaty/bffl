package org.bffl.dbConnector.dao.types;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Security {
    ENCRYPTED("encrypted"),
    NOT_ENCRYPTED("not encrypted");

    private String msg;

}
