package br.com.birouskaapi.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.google.gson.Gson;

import br.com.birouskaapi.control.EstadoControl;
import br.com.birouskaapi.model.Estado;

public class ConnectionFactory {
	
	public static Connection getH2Connection() {
		Connection cn = null;

		String url = "jdbc:h2:~/BirouskaApi";
		Properties props = new Properties();
		props.setProperty("user", "sa");

		
		try {
			Class.forName("org.h2.Driver");
			cn = DriverManager.getConnection(url, props);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("Nao foi possivel carregar o driver");
		}

		return cn;
	}


	public static Connection getConnection() {
		Connection cn = null;

		String url = "jdbc:postgresql://127.0.0.1:5432/DB_Cliente";
		Properties props = new Properties();
		props.setProperty("user", "postgres");
		props.setProperty("password", "postgres");

		try {
			Class.forName("org.postgresql.Driver");
			cn = DriverManager.getConnection(url, props);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("Nao foi possivel carregar o driver");
		}

		return cn;
	}

	public static void main(String[] args) throws Exception {

		// Recupera uma conexão com o banco de dados
		Connection con = getConnection();

		// Testa se a conexão é nula
		if (con != null) {
			System.out.println("Conexão obtida com sucesso!" + con);
			con.close();
		}

		EstadoControl estControl = new EstadoControl();

		List<Estado> lstEstado = new ArrayList<Estado>();

		lstEstado = estControl.List();

		for (Estado uf : lstEstado) {

			System.out.println(" UF: " + uf.getUF() + " - NOME: " + uf.getNome());
		}

		Gson gson = new Gson();
		String jsonUF = gson.toJson(lstEstado);
		System.out.println("Estados = " + jsonUF);

	}
}