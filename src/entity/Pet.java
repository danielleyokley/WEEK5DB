package entity;


public class Pet {

	private int petId;

	private String name;
	private String breed;
	private String gender;
	
	public Pet(int petId, String name, String breed, String gender) {
		this.setPetId(petId);
		this.setName(name);
		this.setBreed(breed);
		this.setGender(gender);
		
	}

	public int getPetId() {
		return petId;
	}

	public void setPetId(int petId) {
		this.petId = petId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}