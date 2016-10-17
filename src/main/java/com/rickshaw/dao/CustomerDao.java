package com.rickshaw.dao;

import com.rickshaw.domain.Customer;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Shahnaz on 10/16/2016.
 */
@Repository
public class CustomerDao {

    private NamedParameterJdbcTemplate jdbcTemplate;

 /*   @Autowired
    public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
*/
    @Autowired
    public CustomerDao(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Customer> getCustomerByName() {

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("firstname", "Curly");

        return jdbcTemplate.query("select * from customer where firstname = :firstname", params, new RowMapper<Customer>() {

            public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
               Customer customer = new Customer();

                customer.setId(rs.getInt("id"));
                customer.setFirstname(rs.getString("firstname"));
                customer.setLastname(rs.getString("lastname"));
                customer.setEmail(rs.getString("email"));
                customer.setPassword(rs.getString("password"));

                return customer;
            }
        });
    }
}
