package telusko.HibDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
    	AlienName an=new AlienName();
    	an.setFname("ajay");
    	an.setMname("singh");
    	an.setLname("yadav");
    	
    	Alien al=new Alien();
    	al.setAid(104);
    	al.setAname(an);
    	al.setAcolor("pink");
    	
    	
    	Configuration con=new Configuration().configure().addAnnotatedClass(Alien.class);
    	
    	SessionFactory sf=con.buildSessionFactory();
    	
    	Session session=sf.openSession();

    	Transaction tx=session.beginTransaction();
   session.save(al);
    	
     tx.commit();
     System.out.println(al);
    }
}
