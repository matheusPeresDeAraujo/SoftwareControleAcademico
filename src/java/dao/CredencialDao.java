
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Credencial;

public class CredencialDao {
    
    
    public static Credencial autenticacao(Credencial credencial) throws ClassNotFoundException, SQLException{
                Credencial usuRetorno = null;
		String sql = "select * from credencial where usuario = ? and senha = ? ";
		try {
                        
                        Connection con = BD.getConexao();
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, credencial.getUsuario());
			preparador.setString(2, credencial.getSenha());
			// Retorno da consulta em Resultset
			ResultSet resultado = preparador.executeQuery();
			// Se tem registro
			if (resultado.next()) {
				// instancia o objeto Usuario
				usuRetorno = new Credencial();
				usuRetorno.setCodUsuario(resultado.getInt("codusuario"));
				usuRetorno.setUsuario(resultado.getString("usuario"));
				usuRetorno.setSenha(resultado.getString("senha"));
                                usuRetorno.setAcesso(resultado.getString("acesso"));
			}
		} catch (SQLException e) {
			System.out.println("Erro de SQL:" + e.getMessage());
		}
		return usuRetorno;
    }
}
