package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import db.DbIntegrityException;
import model.dao.CnaeDao;
import model.entities.CNAE;

public class CNAEDAOJDBC implements CnaeDao {

	private Connection conn;
	
	public CNAEDAOJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public CNAE findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
				"SELECT * FROM Cnae WHERE Id = ?");
			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				CNAE obj = new CNAE();
				obj.setId(rs.getInt("Id"));
				obj.setCod(rs.getString("Cod"));
				obj.setDescricao(rs.getString("descricao"));
				return obj;
			}
			return null;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public List<CNAE> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
				"SELECT * FROM Cnae ORDER BY Id");
			rs = st.executeQuery();

			List<CNAE> list = new ArrayList<>();

			while (rs.next()) {
				CNAE obj = new CNAE();
				obj.setId(rs.getInt("Id"));
				obj.setCod(rs.getString("Cod"));
				obj.setDescricao(rs.getString("Descricao"));

				list.add(obj);
			}
			return list;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public void insert(CNAE obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
				"INSERT INTO Cnae " +
				"(cod,Descricao) " +
				"VALUES " +
				"(?,?)",
				Statement.RETURN_GENERATED_KEYS);

			st.setString(1, obj.getCod());
			st.setString(2, obj.getDescricao());

			int rowsAffected = st.executeUpdate();
			
			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					obj.setId(id);
				}
			}
			else {
				throw new DbException("Unexpected error! No rows affected!");
			}
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		} 
		finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void update(CNAE obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
				"UPDATE Cnae " +
				"SET Cod = ?, " +
				"Descricao = ? " +
				"WHERE Id = ?");

			st.setString(1, obj.getCod());
			st.setString(2, obj.getDescricao());
			st.setInt(3, obj.getId());

			st.executeUpdate();
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		} 
		finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
				"DELETE FROM Cnae WHERE Id = ?");

			st.setInt(1, id);

			st.executeUpdate();
		}
		catch (SQLException e) {
			throw new DbIntegrityException(e.getMessage());
		} 
		finally {
			DB.closeStatement(st);
		}
	}
}
