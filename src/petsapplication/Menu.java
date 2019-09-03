package petsapplication;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import dao.PetDao;
import entity.Pet;

public class Menu {
	private PetDao petDao = new PetDao();
	private Scanner scanner = new Scanner(System.in);
	private List<String> options = Arrays.asList(
			"Display Pets", 
			"Display A Pet", 
			"Create Pet",
			"Create Breed",
			"Create Gender",
			"Delete Pet");
	public void start() {
		String selection = "";
		
		do {
			printMenu();
			selection = scanner.nextLine();
			
			try {
			 if (selection.equals("1")) {
				 displayPets();
				 
			 } else if (selection.equals("2")) {
				 displayPet();
				 
			 } else if (selection.equals("3")) {
				 createPet();
				 
			 } else if (selection.equals("3")) {
				 createBreed();
				 
			 } else if (selection.equals("4")) {
				 createGender();
				 
			 } else if (selection.equals("5")) {
				 deletePet();
			
			 }
			
			 
			 } catch(SQLException e) {
				e.printStackTrace();
			}
			
			
			 System.out.println("Press Enter To Proceed..");
			 scanner.nextLine();
			 
		} while (!selection.equals("-1"));
		
	}
	private void printMenu() {
		System.out.println("Choose an Option:\n------------------------");
		for (int i = 0; i < options.size(); i++) {
			System.out.println(i + 1 + ") " + options.get(i));
			
		}
		
	}
	private void displayPets() throws SQLException {
		List<Pet> pets = petDao.getPets();
		for(Pet pet : pets) {
			System.out.println(pet.getPetId() + ": " + pet.getName() + " " + pet.getBreed() + " " + pet.getGender());
		}
	}
	private void displayPet() throws SQLException {
		System.out.print("Enter Pet ID: ");
		int id = Integer.parseInt(scanner.nextLine());
		Pet pet = petDao.getPetById(id);
		System.out.println(pet.getPetId() + ": " + pet.getName() + " " + pet.getBreed() + " " + pet.getGender());
	}
	private void createPet() throws SQLException {
		System.out.print("Enter Pet Name: ");
		String petName = scanner.nextLine();
		petDao.createNewPet(petName);
	}
	private void createBreed() throws SQLException {
		System.out.print("Enter Breed Name: ");
		String breedName = scanner.nextLine();
		petDao.createNewBreed(breedName);
	}
	private void createGender() throws SQLException {
		System.out.print("Enter Gender Name (Male/Female): ");
		String genderName = scanner.nextLine();
		petDao.createNewGender(genderName);
	}
	private void deletePet() throws SQLException {
		System.out.print("Enter Pet ID to Delete:");
		int id = Integer.parseInt(scanner.nextLine());
		petDao.deletePetById(id);
	
	}
}

