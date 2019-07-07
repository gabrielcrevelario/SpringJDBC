package com.gabriel.crevelario.crevelario.repository;

import com.gabriel.crevelario.crevelario.models.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class CategoriaRepository  {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Categoria> findAll() {
       return jdbcTemplate.query("select * from categoria"
       ,(rs, rowNum) -> new Categoria(rs.getInt("id"),rs.getString("nome")));
    }

    public Categoria getById(long id) {
        return jdbcTemplate.queryForObject("select * from categoria where id = ? ",
                new Object[]{id},(rs, rowNum) ->  new Categoria(rs.getInt("id"), rs.getString("nome")));
    }
}
