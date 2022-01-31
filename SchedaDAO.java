package it.contrader.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.contrader.model.Scheda;
import it.contrader.model.User;
import it.contrader.utils.ConnectionSingleton;

public class SchedaDAO implements DAO<Scheda> {

	private final String QUERY_ALL = "SELECT * FROM scheda";
	private final String QUERY_CREATE = "INSERT INTO scheda (user_id, tipo_esercizio, num_ripetizioni) VALUES (?,?,?)";
	private final String QUERY_READ = "SELECT * FROM scheda WHERE id_scheda=?";
	private final String QUERY_UPDATE = "UPDATE scheda SET user_id=?, tipo_esercizio=?, num_ripetizioni=? WHERE id_scheda=?";
	private final String QUERY_DELETE = "DELETE FROM scheda WHERE id_scheda=?";

	public SchedaDAO() {

	}

	@Override
	public List<Scheda> getAll() {
		List<Scheda> schedaList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Scheda scheda;
			while (resultSet.next()) {
				int id_scheda = resultSet.getInt("id_scheda");
				int user_id = resultSet.getInt("user_id");
				String tipo_esercizio = resultSet.getString("tipo_esercizio");
				int num_ripetizioni = resultSet.getInt("num_ripetizioni");
				scheda= new Scheda(user_id, tipo_esercizio, num_ripetizioni); 
				scheda.setId_scheda(id_scheda);
				schedaList.add(scheda);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return schedaList;
	}

	public boolean insert(Scheda schedaToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setInt(1, schedaToInsert.getUser_id());
			preparedStatement.setString(2, schedaToInsert.getTipo_esercizio());
			preparedStatement.setInt(3, schedaToInsert.getNum_ripetizioni());
			System.out.println(preparedStatement.toString());
			preparedStatement.execute();
			return true;
		} catch (SQLException e){
			System.out.println(e.toString());
			return false;
		}

	}	


	@Override
	public Scheda read(int id_scheda) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, id_scheda);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			int user_id;
			String tipo_esercizio;
			int num_ripetizioni;

			user_id = resultSet.getInt("user_id");
			tipo_esercizio = resultSet.getString("tipo_esercizio");
			num_ripetizioni = resultSet.getInt("num_ripetizioni");
			Scheda scheda = new Scheda(user_id, tipo_esercizio, num_ripetizioni);
			scheda.setId_scheda(resultSet.getInt("id_scheda"));

			return scheda;
		} catch (SQLException e) {
			return null;
		}
		}
	

	@Override
	public boolean update(Scheda schedaToUpdate) {
		System.out.println(schedaToUpdate.toString());
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (schedaToUpdate.getId_scheda() == 0)
			return false;

		Scheda schedaRead = read(schedaToUpdate.getId_scheda());
		System.out.println(schedaRead.toString());
			try {

				if (schedaToUpdate.getUser_id() == 0 ) {
					schedaToUpdate.setUser_id(schedaRead.getUser_id());
					System.out.println("1");
					}
				
				if (schedaToUpdate.getTipo_esercizio() == null || schedaToUpdate.getTipo_esercizio().equals("")) {
					schedaToUpdate.setTipo_esercizio(schedaRead.getTipo_esercizio());
				}

				if (schedaToUpdate.getNum_ripetizioni() == 0) {
					schedaToUpdate.setNum_ripetizioni(schedaRead.getNum_ripetizioni());
				}
				
System.out.println("sono nel dao");
			
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setInt(1, schedaToUpdate.getUser_id());
				preparedStatement.setString(2, schedaToUpdate.getTipo_esercizio());
				preparedStatement.setInt(3, schedaToUpdate.getNum_ripetizioni());
				preparedStatement.setInt(4, schedaToUpdate.getId_scheda());
System.out.println(preparedStatement.toString());
				int a = preparedStatement.executeUpdate();
				if (a > 0)
					return true;
				else
					return false;

			} catch (SQLException e) {
				System.out.println(e.toString());
				return false;
			}
		


	}

	public boolean delete(int id_scheda) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, id_scheda);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;

		} catch (SQLException e) {
		}
		return false;
	}

	
}