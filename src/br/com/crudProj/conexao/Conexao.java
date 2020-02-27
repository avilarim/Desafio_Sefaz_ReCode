package br.com.crudProj.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	public Conexao() {
			
	}
	public Connection getConexao() {
		try {
			return DriverManager.getConnection("jdc:mysql://localhost:3306/crudProj?Timezone=true&serverTimezone=America/Sao_paulo", "root"," " );
			
		}catch (SQLException e) {
			throw new RuntimeException ("Erro ao conectar ao BD!", e);
			
		}
		
	}
}
