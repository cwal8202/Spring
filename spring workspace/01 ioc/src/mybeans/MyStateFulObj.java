package mybeans;

public class MyStateFulObj {
	private String name;
	private int number;
	
	public MyStateFulObj() {}
	public MyStateFulObj(String name, int number) {
		super();
		this.name = name;
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return "MyStateFulObj [name=" + name + ", number=" + number + "]";
	}
}
