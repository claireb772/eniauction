package org.eniauction.dal.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionProvider {

	private static DataSource datasource;

	static {
		try {
			Context context = new InitialContext();
			datasource = (DataSource) context.lookup("java:comp/env/jdbc/pool_cnx_eniAuction");
		} catch (NamingException e) {
			e.printStackTrace();
			throw new RuntimeException("Impossible de charger la ressource demandé !");
		}

	}

	/**
	 * Cette méthode retourne une connection opérationnelle issue du pool de
	 * connexion vers la base de données.
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		// piocher une connexion dans le pool de connexions dÃ©fini par le context.xml
		return datasource.getConnection();
	}

}