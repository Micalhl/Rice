package me.mical.rice.sql;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SQLInfo {

    public String sqlAddress;
    public int sqlPort;
    public String sqlDatabase;
    public String sqlName;
    public String sqlPassword;

}
