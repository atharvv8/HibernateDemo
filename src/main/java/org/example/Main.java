package org.example;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

    public void insert()
    {
        Student s1 = new Student();
        s1.setAge(25);
        s1.setsName("Ram");
        s1.setRollNo(11);


        //We will use hibernate to save data in database
        //Note that we have already included dependencies in maven

        //Create session
        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(org.example.Student.class);
        cfg.configure();
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();

        Transaction transaction = session.beginTransaction();
//        session.save(s1);  It is depricated now. so we use session.persist()
        session.persist(s1);
        transaction.commit();
        session.close();
        sf.close();
        System.out.println(s1);
    }
    public void fetch()
    {
        Student s2 = null;

        //Create session
        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(org.example.Student.class);
        cfg.configure();
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();

        s2 = session.get(Student.class, 20); // Using primary key and data type


        session.close();
        sf.close();
//        System.out.println(s2);
        System.out.println(s2.getsName());
    }
    public void update()
    {
        //first create the object of the row which you want to update in table
        Student s3 = new Student();
        s3.setAge(26); //Updated age is written here
        s3.setsName("Ram");
        s3.setRollNo(11);

        //Create session
        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(org.example.Student.class);
        cfg.configure();
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();

        Transaction transaction = session.beginTransaction(); // Since updating is a transaction we need to use transaction and commit
        session.merge(s3); // If data is present, it will update it.. if data is not present then it will just insert it in table
        transaction.commit();

        session.close();
        sf.close();
//        System.out.println(s2);

    }
    public void delete()
    {
        //We can fetch and delete

        //Create session
        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(org.example.Student.class);
        cfg.configure();
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();


        //first fetch
        Student s4 = null;
        s4 = session.get(Student.class, 11);
        Transaction transaction = session.beginTransaction();

        session.remove(s4); // If data is present, it will update it.. if data is not present then it will just insert it in table
        transaction.commit();

        session.close();
        sf.close();
    }
    public static void main(String[] args) {
        Main ob = new Main();
      ob.insert();
//        ob.fetch();
//        ob.update();
//        ob.delete();
    }
}