package DAO;

import Table.Design;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

//录入新的毕业设计题目Dao
public class EntryTopicDao {

    private Design design;
    private SessionFactory sessionFactory;

    public boolean EntryTopic(String student, String topic, String college) {
        Session session = sessionFactory.openSession();
        design = session.get(Design.class,student);
        if(design != null && design.getTopic().equals(topic)) {
            session.close();
            return false;
        } else {
            Transaction ts = session.beginTransaction();
            design = new Design();
            design.setStudent(student);
            design.setTopic(topic);
            design.setCollege(college);
            session.save(design);
            ts.commit();
            session.close();
            return true;
        }
    }

    public Design getDesign() {
        return design;
    }

    public void setDesign(Design design) {
        this.design = design;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
