package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Pet;

public class PetDao {

	private Connection connection;
	private final String GET_PETS_QUERY = "Select * FROM pets";
	private final String GET_PET_BY_ID_QUERY = "SELECT * FROM pets WHERE id = ?";
	private final String CREATE_NEW_PET_QUERY = "INSERT INTO pets(name) VALUES(?)";
	private final String CREATE_NEW_BREED_QUERY = "INSERT INTO pets(breed) VALUES(?)";
	
	private final String CREATE_PET_GENDER_QUERY = "INSERT INTO pets(gender) VALUES(?)";
	private final String DELETE_PET_BY_ID_QUERY = "DELETE FROM pets WHERE id = ?";
		
	
	public PetDao() {
		connection = DBconnection.getConnection();
		
		
	}
	public List<Pet> getPets() throws SQLException {
		ResultSet rs = connection.prepareStatement(GET_PETS_QUERY).executeQuery();
		List<Pet> pets = new ArrayList<Pet>();
		
		while (rs.next()) {
			pets.add(populatePet(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
		}
		return pets;
	}
	
	public Pet getPetById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_PET_BY_ID_QUERY);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		rs.next(); //puts us on to first row
		return populatePet(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
	
	}
	public void createNewPet(String petName) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_NEW_PET_QUERY); 
		ps.setString(1, petName);
		ps.executeUpdate();
		
	}
	public void createNewBreed(String breedName) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_NEW_BREED_QUERY); 
		ps.setString(1, breedName);
		ps.executeUpdate();
	}
		public void createNewGender(String genderName) throws SQLException {
			PreparedStatement ps = connection.prepareStatement(CREATE_PET_GENDER_QUERY); 
			ps.setString(1, genderName);
			ps.executeUpdate();
	}
	public void deletePetById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_PET_BY_ID_QUERY);
		ps.setInt(1, id);
		ps.executeUpdate();
	}
	private Pet populatePet(int id, String name, String breed, String gender) {
		// TODO Auto-generated method stub
		return new Pet(id, name, breed, gender);
}
}