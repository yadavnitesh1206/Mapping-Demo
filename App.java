package telusko.MappingDemo;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       
    	Laptop lp=new Laptop();
    	Laptop lp2=new Laptop();
    	Student st=new Student();
    	lp.setLid(101);
    	lp.setLname("HP");
    	lp2.setLid(102); 
    	lp2.setLname("Dell");
    	ArrayList<Laptop> al=new ArrayList<Laptop>();
    	al.add(lp);
    	al.add(lp2);
    	st.setRollno(1);
    	st.setName("ram");
    	st.setMarks(200);
    	st.setLaptops(al);
    	lp.setStud(st);
    	
    	
    	Configuration con=new Configuration().configure().addAnnotatedClass(Laptop.class).addAnnotatedClass(Student.class);
    	SessionFactory sf=con.buildSessionFactory();
    	Session session=sf.openSession();
    	Transaction tx=session.beginTransaction();
    	session.save(lp);
    	session.save(st);
    	tx.commit();
    	
    }
}
