package model.dao.impl;

import db.DB;
import db.DbException;
import db.DbIntegrityException;

import model.dao.FuncionarioDao;

import model.entities.Funcionario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDaoJDBC implements FuncionarioDao {

    private Connection conn;

    public FuncionarioDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public Funcionario findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(
                    "SELECT * FROM funcionario WHERE funcionario_id = ?");
            st.setInt(1, id);
            rs = st.executeQuery();
            if (rs.next()) {
                Funcionario obj = new Funcionario();
                obj.setId(rs.getInt("funcionario_id"));
                obj.setNome(rs.getString("nome"));
                obj.setNumeroRegistro(rs.getInt("numeroRegistro"));
                obj.setTurno(rs.getString("turno"));
                obj.setCPF(rs.getString("CPF"));
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
    public List<Funcionario> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(
                    "SELECT * FROM Funcionario ORDER BY funcionario_id");
            rs = st.executeQuery();

            List<Funcionario> list = new ArrayList<>();

            while (rs.next()) {
                Funcionario obj = new Funcionario();
                obj.setId(rs.getInt("funcionario_id"));
                obj.setNome(rs.getString("nome"));
                obj.setNumeroRegistro(rs.getInt("numeroRegistro"));
                obj.setTurno(rs.getString("turno"));
                obj.setCPF(rs.getString("CPF"));

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
    public void insert(Funcionario obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "INSERT INTO Funcionario " +
                            "(nome,numeroRegistro,turno,CPF) " +
                            "VALUES " +
                            "(?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);

            st.setString(1, obj.getNome());
            st.setInt(2, obj.getNumeroRegistro());
            st.setString(3, obj.getTurno());
            st.setString(4, obj.getCPF());

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
    public void update(Funcionario obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "UPDATE Funcionario " +
                            "SET nome = ?, " +
                            "numeroRegistro = ?, " +
                            "turno = ?," +
                            "CPF = ?" +
                            "WHERE funcionario_id = ?");

            st.setString(1, obj.getNome());
            st.setInt(2, obj.getNumeroRegistro());
            st.setString(3, obj.getTurno());
            st.setString(4, obj.getCPF());
            st.setInt(5, obj.getId());
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
                    "DELETE FROM Funcionario WHERE funcionario_id = ?");

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