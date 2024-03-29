package com.emexo.spring.jdbc.xml;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class contactDAO {
    JdbcTemplate jdbcTemplate;

    public contactDAO(JdbcTemplate jt) {
        this.jdbcTemplate = jt;
    }

    public int save(String name, String email, String address, String telephone) {
        String sqlInsert = "INSERT INTO contact (name, email, address, telephone)"
                + " VALUES (?, ?, ?, ?)";
        int response = jdbcTemplate.update(sqlInsert, name, email, address, telephone);
        return response;
    }

    public int update(String email, String name) {
        String sqlUpdate = "UPDATE contact set email=? where name=?";
        int response = jdbcTemplate.update(sqlUpdate, email, name);
        return response;
    }

    public List<Contact> getAll() {
        String sqlSelect = "SELECT * FROM contact";
        List<Contact> listContact = jdbcTemplate.query(sqlSelect, new ContactRowMapper());
        return listContact;

    }

    public Contact getById(int id) {
        String sqlSelect = "SELECT * FROM contact where id=?";
        Contact contact = jdbcTemplate.queryForObject(sqlSelect, new ContactRowMapper(), id);
        return contact;

    }
}
