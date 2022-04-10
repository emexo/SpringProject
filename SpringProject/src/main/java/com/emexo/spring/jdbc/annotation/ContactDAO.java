package com.emexo.spring.jdbc.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ContactDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int saveContact(Contact contact){
        String sql = "INSERT INTO contact (name, email, address, telephone) VALUES (?, ?, ?, ?)";
        int response = jdbcTemplate.update(sql,contact.getName(), contact.getEmail(), contact.getAddress(), contact.getTelephone());

        return response;
    }

    public int updateContact(Contact contact){
        String sql = "UPDATE contact set email=? where id=?";
        int response = jdbcTemplate.update(sql,contact.getEmail(), contact.getId());
        return response;
    }

    public int deleteContact(Contact contact){
        String sql = "DELETE from contact where id=?";
        int response = jdbcTemplate.update(sql, contact.getId());
        return response;
    }

    public List<Contact> getContacts(){
        String sql = "select * from contact";
         return  jdbcTemplate.query(sql, new ContactRowMapper());
    }

    public Contact getContactById(int id){
        String sql = "select * from contact where id=?";
        return  jdbcTemplate.queryForObject(sql, new ContactRowMapper(), id);
    }
}
