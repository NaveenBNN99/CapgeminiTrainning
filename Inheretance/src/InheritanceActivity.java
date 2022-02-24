class Employee
{
	long employeeId,employeePhone;
	String employeeName,employeeAddress;
	double basicSalary;
	double specialAllowance=250.80d;
	double Hra=1000.58d;
	public Employee(long employeeId, long employeePhone, String employeeName, String employeeAddress,
			double basicSalary, double specialAllowance, double hra) {
		super();
		this.employeeId = employeeId;
		this.employeePhone = employeePhone;
		this.employeeName = employeeName;
		this.employeeAddress = employeeAddress;
		this.basicSalary = basicSalary;
		this.specialAllowance = specialAllowance;
		Hra = hra;
	}
	public void calculateSalary() {
		double salary =  this.basicSalary + ( this.basicSalary * this.specialAllowance/100) + ( this.basicSalary * this.Hra/100);
		System.out.println("The calculated salary:"+salary);
	}
	public void calculateTransportAllowance() {
		double transportAllowance = (10/100)*this.basicSalary;
		System.out.println("Salary after calculating transport allowance:"+(this.basicSalary-transportAllowance));
		}
	class Manager extends Employee{

		public Manager(long employeeId, String employeeName, String employeeAddress,
				double basicSalary, double specialAllowance, double hra) {
			super(employeeId, employeeId, employeeName, employeeAddress, basicSalary, specialAllowance, hra);
		this.basicSalary=basicSalary;
		}
	}
	class Traniee extends Employee{

		public Traniee(long employeeId,  String employeeName, String employeeAddress,
				double basicSalary, double specialAllowance, double hra) {
			super(employeeId,  employeeId, employeeName, employeeAddress, basicSalary, specialAllowance, hra);
			this.basicSalary=basicSalary;
		}
		
	}
	
	class InheritenceActivity {
		public void main(String args[]) {
			 Manager x= new Manager(126534,237844 ,"Peter", "Chennai,India" , 65000);
				Trainee y= new Trainee(29846,442085 , "Jack", "Mumbai,India", 45000);
				x.calculateSalary();
				y.calculateSalary();
				x.calculateTransportAllowance();
				y.calculateTransportAllowance();
		}
	}
