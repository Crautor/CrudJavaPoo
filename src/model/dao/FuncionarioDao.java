package model.dao;


import model.entities.Funcionario;

import java.util.List;

public interface FuncionarioDao {

    void insert(Funcionario obj);
    void update(Funcionario obj);
    void deleteById(Integer id);
    Funcionario findById(Integer id);
    List<Funcionario> findAll();



}


