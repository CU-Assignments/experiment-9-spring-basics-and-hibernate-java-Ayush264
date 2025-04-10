<hibernate-configuration>
 <session-factory>
   <property name="hibernate.connection.driver_class">com.mysql.cj.jdbc.Driver</property>
   <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/your_database</property>
   <property name="hibernate.connection.username">root</property>
   <property name="hibernate.connection.password">your_password</property>
   <property name="hibernate.dialect">org.hibernate.dialect.MySQL5Dialect</property>
   <property name="hibernate.hbm2ddl.auto">update</property>
   <property name="show_sql">true</property>
   <mapping class="Student"/>
 </session-factory>
</hibernate-configuration>

    import javax.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;

    public Student() {}

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters and Setters
}
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentDAO {
    SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

    public void saveStudent(Student student) {
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();
        session.close();
    }

    public Student getStudent(int id) {
        Session session = factory.openSession();
        Student student = session.get(Student.class, id);
        session.close();
        return student;
    }

    // update, delete, listAll etc.
}

public class MainApp {
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();
        dao.saveStudent(new Student("John", 22));
        Student s = dao.getStudent(1);
        System.out.println("Fetched: " + s.getName());
    }
}
