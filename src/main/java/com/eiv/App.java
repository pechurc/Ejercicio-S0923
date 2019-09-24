package com.eiv;

import java.util.List;

import javax.sql.DataSource;

public class App {

    private static DataSource dataSource;
    
    static {
        dataSource = new PoolProvider().getDataSource();
    }
    
    public static void main(String[] args) {
        App app = new App();
        app.run();
    }
    
    public void run() {
        JdbcTemplate template = new JdbcTemplate(dataSource);
   
        List<BeneficiarioEntity> beneficiarioEntities = 
                template.query("SELECT * FROM beneficiarios", new BeneficiarioMapper());
        
        beneficiarioEntities.forEach(beneficiario -> {
            System.out.println(beneficiario);            
        });
    }

}
