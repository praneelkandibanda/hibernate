package com.cg.hibernate_employee;

	
	import javax.persistence.Column;

	import javax.persistence.Entity;
	
	import javax.persistence.Id;
	import javax.persistence.Table;

	 

	@Entity
	@Table(name = "employee") //if the entity class name and table name is same then @Table can be skipped
	public class Employee{

	 

	    @Id
	    private int id;
	    @Column
	    private String name;
	    @Column
	    private String email;

	 

	    public Employee() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

	 

	    public int getId() {
	        return id;
	    }

	 

	    public void setId(int id) {
	        this.id = id;
	    }

	 

	    public String getName() {
	        return name;
	    }

	 

	    public void setName(String name) {
	        this.name = name;
	    }

	 

	    public String getEmail() {
	        return email;
	    }

	 

	    public void setEmail(String email) {
	        this.email = email;
	    }

	 

	    @Override
	    public String toString() {
	        return "Employee [id=" + id + ", name=" + name + ", email=" + email + "]";
	    }

}
