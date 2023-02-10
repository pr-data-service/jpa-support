/**
 * 
 */
package com.jpasupport.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.jpasupport.dto.TableDetailsDTO;

/**
 * @author 002ZX2744
 *
 */
public class TableDetailsRowMapper implements RowMapper<TableDetailsDTO> {

	@Override
	public TableDetailsDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		TableDetailsDTO dto = new TableDetailsDTO();

        dto.setName(rs.getString("table_name"));

        return dto;
	}

}
