package MichalSzulierz3A;

public class Pracownik {
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public int getPesel() {
		return pesel;
	}
	public void setPesel(int pesel) {
		this.pesel = pesel;
	}
	public String getPosition() {
		return stand;
	}
	public void setPosition(String stand) {
		this.stand = stand;
	}
	private String name="";
	private String surname="";
	private String gender="";
	private int age=0;
	private int phone=0;
	private int pesel=0;
	private String stand="";
}
