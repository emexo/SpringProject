package com.emexo.spring.jdbc.xml;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ContactRowMapper implements RowMapper<Contact> {

    public Contact mapRow(ResultSet result, int rowNum) throws SQLException {
        Contact contact = new Contact();
        contact.setName(result.getString("name"));
        contact.setEmail(result.getString("email"));
        contact.setAddress(result.getString("address"));
        contact.setTelephone(result.getString("telephone"));
        return contact;
    }
}
