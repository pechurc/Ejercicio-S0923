package com.eiv;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class PoolProvider implements DataSourceProvider {
    
    @Override
    public DataSource getDataSource() {        
        HikariConfig config = new HikariConfig("/hikari.properties");        
        HikariDataSource ds = new HikariDataSource(config);        
        return ds;
    }
}
