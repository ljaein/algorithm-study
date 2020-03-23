package person;

public class Patient extends Person {
	private String diseaseName;
	private String hospitalId;
	private boolean isCorona;

	public Patient() {

	}

	public Patient(String name, int age, String phone, String diseaseName, String hospitalId, boolean isCorona) {
		super(name, age, phone);
		this.diseaseName = diseaseName;
		this.hospitalId = hospitalId;
		this.isCorona = isCorona;
	}
	
	public Patient(Patient p){ //깊은 복사
		this(p.getName(),p.getAge(),p.getPhone(),p.getDiseaseName(),p.getHospitalId(),p.isCorona);
	}

	public Patient copy(){
		return new Patient(this);
	}
	
	public boolean equals(Object o) {
		Patient p = (Patient) o;
		if (this.getName().equals(p.getName()) && this.getPhone().equals(p.getPhone()))
			return true;
		return false;
	}
	// set에서 멤버 변수를 통해 객체를 비교하기 위해 hashcode 부여
	public int hashCode() { // 소수를 이용하여 멤버 변수의 값이 다르면 다른 해시값 리턴
		int hash = 7;
		hash = 31 * hash + this.getName().hashCode();
		hash = 31 * hash + this.getPhone().hashCode();
		return hash;
	}

	public String getDiseaseName() {
		return diseaseName;
	}

	public void setDiseaseName(String diseaseName) {
		this.diseaseName = diseaseName;
	}

	public String getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(String hospitalId) {
		this.hospitalId = hospitalId;
	}

	public boolean isCorona() {
		return isCorona;
	}

	public void setCorona(boolean isCorona) {
		this.isCorona = isCorona;
	}

}
