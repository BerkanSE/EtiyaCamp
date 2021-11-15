package workShop;

public class Customer {
	private int id;
	private String nationalIdentity;
	private String firstName;
	private String lastName;
	private String city;
	
	public Customer() {
		super();
	}
	
	public Customer(int id, String nationalIdentity, String firstName, String lastName, String city) {
		super();
		this.id = id;
		this.nationalIdentity = nationalIdentity;
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNationalIdentity() {
		return nationalIdentity;
	}

	public void setNationalIdentity(String nationalIdentity) {
		this.nationalIdentity = nationalIdentity;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	
}
