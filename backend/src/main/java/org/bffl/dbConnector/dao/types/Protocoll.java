package org.bffl.dbConnector.dao.types;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Protocoll {
    HTTP("HTTP", Security.NOT_ENCRYPTED),
    HTTPS("HTTPS", Security.ENCRYPTED),
    SMB("SMB", Security.ENCRYPTED),
    FTP("FTP", Security.NOT_ENCRYPTED),
    SFTP("SFTP", Security.ENCRYPTED);

    private String bez;
    private Security security;

}
