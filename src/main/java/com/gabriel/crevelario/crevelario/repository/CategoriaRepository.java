package com.gabriel.crevelario.crevelario.repository;

import com.gabriel.crevelario.crevelario.models.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.List;
@Repository
public class CategoriaRepository  {


    @Value("${spring.datasource.url}")
    private  String URL;
    @Value("${spring.datasource.username}")
    private String USERNAME;
    @Value("${spring.datasource.password}")
    private String PASSWORD;

   @Autowired
   private JdbcTemplate jdbcTemplate;




    public List<Categoria> findAll() {
       return jdbcTemplate.query("select * from categoria"
       ,(rs, rowNum) -> new Categoria(rs.getInt("id"),rs.getString("nome")));
    }

    public Categoria getById( long id) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl(URL);
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("id", id);
        NamedParameterJdbcTemplate jdbcTemplate2 =  new NamedParameterJdbcTemplate(dataSource);

        return jdbcTemplate2.queryForObject("select * from categoria where id = :id",
                parameters,(rs, rowNum) ->  new Categoria(rs.getInt("id"), rs.getString("nome")));
    }
}
