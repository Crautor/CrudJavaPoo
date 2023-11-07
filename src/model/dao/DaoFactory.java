package model.dao;

import db.DB;
import model.dao.impl.EixoDaoJDBC;
import model.dao.impl.EnderecoDaoJDBC;
import model.dao.impl.CNAEDAOJDBC;
import model.dao.impl.FuncionarioDaoJDBC;


public class DaoFactory {

	
	public static EixoDao createEixoDao() {
		return new EixoDaoJDBC(DB.getConnection());
	}
	public static EnderecoDao createEnderecoDao() { return new EnderecoDaoJDBC(DB.getConnection());}
	public static CnaeDao createCnaeDao() { return new CNAEDAOJDBC(DB.getConnection());}
	public static FuncionarioDao createFuncionarioDao() { return new FuncionarioDaoJDBC(DB.getConnection());}

}
