package br.com.crudProj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.com.crudProj.conexao.Conexao;
import br.com.crudProj.model.Usuario;

public class UserDao {

	private Connection connection;
	public void inserir(Usuario usuario) {
		try {
			this.connection = new Conexao().getConexao();
			PreparedStatement stmt = connection.prepareStatement("insert into usuario(nome,senha,email)values (?,?,?)");
			PreparedStatement stmt_telefone = connection.prepareStatement("insert into telefone (ddd,numero,tipo)values (?,?,?)");
			stmt.setString(1,usuario.getNome());
			stmt.setString(2,usuario.getSenha());
			stmt.setString(3,usuario.getEmail());
			stmt_telefone.setInt(1,usuario.getTelefone().getDdd());
			stmt_telefone.setString(2,usuario.getTelefone().getNumero());
			stmt_telefone.setString(3,usuario.getTelefone().getTipo());
			stmt_telefone.setInt(4,usuario.getTelefone().getId_usuario());
			this.connection.close();
			System.out.println("dados gravados ok!");
			
			
				
				
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		
		
	}
}
