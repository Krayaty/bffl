package org.bffl.dao.types;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Protocoll {
    HTTP("HTTP", Security.NOT_ENCRYPTED),
    HTTPS("HTTPS", Security.ENCRYPTED),
    SMB("SMB", Security.ENCRYPTED),
    FTP("FTP", Security.NOT_ENCRYPTED),
    SFTP("SFTP", Security.ENCRYPTED);

    private String bez;
    private Security security;

}
