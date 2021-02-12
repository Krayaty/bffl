package org.bffl.dbConnector.dao.types;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Protocoll {
    HTTP("HTTP", Security.NOT_ENCRYPTED),
    HTTPS("HTTPS", Security.ENCRYPTED),
    SMB("SMB", Security.ENCRYPTED),
    FTP("FTP", Security.NOT_ENCRYPTED),
    SFTP("SFTP", Security.ENCRYPTED);

    private String bez;
    private Security security;

    public String getBez() {
        return bez;
    }

    public Security getSecurity() {
        return security;
    }
}
