public class Student {
	public long number;
	public String name;
	public String surname;

	public Student(long number, String name, String surname) {

		String a = name, b = surname;
		this.number = number;

		if (name != null && name.length() < 10) {
			for (int i = 0; i < 10 - name.length(); i++) {
				a = "." + a;
			}
		}

		this.name = a;

		if (surname != null && surname.length() < 10) {

			for (int i = 0; i < 10 - surname.length(); i++) {
				b = "." + b;
			}

		}
		this.surname = b;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

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

}