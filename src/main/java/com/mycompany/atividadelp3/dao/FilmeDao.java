/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atividadelp3.dao;

import com.mycompany.atividadelp3.bean.Filme;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class FilmeDao implements Dao<Integer, Filme>{
    protected Connection con;

    public FilmeDao(Connection con) {
        this.con = con;
    }

    @Override
    public void create(Filme entity) {
        String sql = "INSERT INTO filme(nome, ano, duracao, foto, sinopse, estilo_id) VALUES (?, ?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement query = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            query.setString(1, entity.getNome());
            query.setString(2, entity.getAno());
            query.setInt(3, entity.getDuracao());
            query.setString(4, entity.getFoto());
            query.setString(5, entity.getSinopse());
            query.setInt(3, entity.getEstilo().getId());
            query.executeUpdate();
            
            ResultSet rs = query.getGeneratedKeys();
            
            if(rs.next()){
                int id = rs.getInt("id");
                entity.setId(id);
            }
            query.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Filme retrieve(Integer pk) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Filme entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Integer pk) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Filme> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
