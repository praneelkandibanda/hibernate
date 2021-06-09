package com.cg.hibernate_employee;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

 

public class Main {
    public static void main(String[] args) {

 

        // using hibernate/jpa api - we will persist the employee object in emp table
        // Step 1: loading the hibernate configuration file
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernet.cfg.xml").build();

 

        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

 

        // Step 2: obtaining SessionFactory object
        SessionFactory factory = meta.getSessionFactoryBuilder().build();

 

        Session session = factory.openSession();

 

        Transaction t = session.beginTransaction();
//Save an employee entity object in database
        Employee employee = new Employee();
        employee.setId(3);
        employee.setName("Rama");
        employee.setEmail("ram@cg.com");        
         session.save(employee);

 

         //Fetch an employee record from db
  Employee emp = session.get(Employee.class, 1);
       System.out.println(emp);

 

        // Delete an employee record/row from db
        String sql = "DELETE FROM Employee WHERE ID = 10";
        Query query = session.createQuery(sql);
        int n = query.executeUpdate();
        if(n == 0 ) {
            System.out.println("not deleted!!");
        }else {
            System.out.println("deled one record!!");
        }

 

        // Update an employee record in db
        // first we need to fetch the mapped object from db which we want to update
        Employee emp1= session.get(Employee.class,1);
        emp1.setName("Hello");
        emp1.setEmail("hello@cg.com");

 

        session.persist(employee);
        t.commit();

 

        System.out.println("employee object saved!!");
    }
}
