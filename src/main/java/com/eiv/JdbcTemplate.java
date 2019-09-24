package com.eiv;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class JdbcTemplate {
    private DataSource dataSource;
    
    public JdbcTemplate(DataSource dataSource) {
        this.setDataSource(dataSource);
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    public <T> List<T> query(String sql, RowMapper<T> rowMapper) {
        
        List<T> resultados = new ArrayList<>();
        
        try (Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                T t = rowMapper.mapRow(rs, rs.getRow());
                
                resultados.add(t);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
            throw new RuntimeException(e.getMessage(), e);            
        }
        
        return resultados;
    }
}
