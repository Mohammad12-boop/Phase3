package phase3;


public class MartyrRecord implements Comparable<MartyrRecord> { //Class martyr :

	private String name;
	private int age;
	private String location;
	private String district;
	private String gender;

	public MartyrRecord() {

		this.name = "";
		setAge(0);
		this.location = "";
		this.district = "";
		setGender("");
	}

	public MartyrRecord(String name, int age, String location, String district, String gender) {

		this.name = name;
		setAge(age);
		this.location = location;
		this.district = district;
		setGender(gender);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {

		if (age >=0 && age <=120)
			this.age = age;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {

		if (gender.equalsIgnoreCase("M") || gender.equalsIgnoreCase("F")) {

			this.gender = gender;
		}

	}

	@Override
	public String toString() {

		return "Martyr [name=" + name + ", age=" + age + ", location=" + location + ", district="
				+ district + ", gender=" + gender + "]\n";
	}

	@Override
	public int compareTo(MartyrRecord o) {

		if (this.district.toUpperCase().compareTo(o.district.toUpperCase()) == 0) {

			return this.name.toUpperCase().compareTo(o.name.toUpperCase());
		}

		return this.district.toUpperCase().compareTo(o.district.toUpperCase());
	}

	public boolean equals(Object o) {

		if (o instanceof MartyrRecord) {

			return this.name.equalsIgnoreCase(((MartyrRecord)o).name);
		}

		return false;
	}

}
