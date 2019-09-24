package com.eiv;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BeneficiarioMapper implements RowMapper<BeneficiarioEntity> {

    @Override
    public BeneficiarioEntity mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        BeneficiarioEntity result = new BeneficiarioEntity();
        
        result.setId(resultSet.getLong("id"));
        result.setApellido(resultSet.getString("apellido"));
        result.setNombre(resultSet.getString("nombre"));
        result.setDomicilio(resultSet.getString("domicilio"));
        result.setNroCuil(resultSet.getString("cuil"));
        result.setNroDocumento(resultSet.getString("nro_documento"));
        result.setSexo(resultSet.getString("sexo"));
        
        return result;
    }

}
