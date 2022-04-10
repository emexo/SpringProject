package com.emexo.spring.jdbc.annotation;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ContactRowMapper implements RowMapper<Contact> {
    public Contact mapRow(ResultSet result, int rowNum) throws SQLException {
        Contact contact = new Contact();
        contact.setId(result.getInt("id"));
        contact.setName(result.getString("name"));
        contact.setAddress(result.getString("address"));
        contact.setTelephone(result.getString("telephone"));
        contact.setEmail(result.getString("email"));
        return contact;
    }
}
