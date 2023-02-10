/**
 * 
 */
package com.jpasupport.repository;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jpasupport.dto.TableDetailsDTO;
import com.jpasupport.rowmapper.TableDetailsRowMapper;


/**
 * @author 002ZX2744
 *
 */

@Repository
public class SchemaDetailsRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<TableDetailsDTO> getTableList() {
		String query = "SELECT table_name FROM INFORMATION_SCHEMA.tables";
		return jdbcTemplate.query(query, new TableDetailsRowMapper());
	}
}
