interface LibraryInterfaceDemo{
	void registerAccount();
	void requestBook();
}

class KidUser implements LibraryInterfaceDemo{
	int age;
	String bookType;
	public void setAge(int age) {
		this.age = age;
	}
	public void setBookType(String bookType) {
		this.bookType = bookType;
	}
	public void registerAccount() {
		if(this.age>12) {System.out.println("Sorry, Age must be less than 12 to register as a kid");}
		else {System.out.println("You have successfully registered under a Kids Account");} 
	}
	public void requestBook() {
		if(this.bookType.equals("Kids")) {
			System.out.println("Book Issued successfully, please return the book within 10 days");
			}
		else {
			System.out.println("Oops, you are allowed to take only kids books");
			}
	}
}
class AdultUser implements LibraryInterfaceDemo{
	int age;
	String bookType;
	public void setAge(int age) {
		this.age = age;
	}
	public void setBookType(String bookType) {
		this.bookType = bookType;
	}
	public void registerAccount() {
		if(this.age<=12) {
			System.out.println("Sorry, Age must be greater than 12 to register as an adult");
			}
		else {
			System.out.println("You have successfully registered under an Adult Account");
			} 
	}
	public void requestBook() {
		if(this.bookType.equals("Fiction")) {
			System.out.println("Book Issued successfully, please return the book within 7 days");}
		else {
			System.out.println("Oops, you are allowed to take only adult Fiction books");
			}
	}
}
 public class LibraryInterfaceDemo {
	public void main(String[] args) {
		KidUser k = new KidUser();
		k.setAge(10);
		k.registerAccount();
		k.setBookType("Kids");
		k.requestBook();
		k.setAge(18);
		k.registerAccount();
		k.setBookType("Fiction");
		k.requestBook();
		AdultUser a = new AdultUser();
		a.setAge(5);
		a.registerAccount();
		a.setBookType("Kids");
		a.requestBook();
		a.setAge(23);
		a.setBookType("Fiction");
		a.requestBook();
	}
}
