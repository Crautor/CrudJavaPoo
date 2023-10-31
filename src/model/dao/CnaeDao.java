package model.dao;

import java.util.List;

import model.entities.CNAE;

public interface CnaeDao {

	void insert(CNAE obj);
	void update(CNAE obj);
	void deleteById(Integer id);
	CNAE findById(Integer id);
	List<CNAE> findAll();
}
