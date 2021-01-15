package org.bffl.dao.types;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Security {
    ENCRYPTED("encrypted"),
    NOT_ENCRYPTED("not encrypted");

    private String msg;
}
