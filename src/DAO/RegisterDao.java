package DAO;

import Table.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

//注册模块
public class RegisterDao {

    private User user;
    private SessionFactory sessionFactory;

    public boolean Register(String account, String password, String student) {
        Session session = sessionFactory.openSession();
        user = session.get(User.class, account);
        if(user == null) {
            Transaction ts = session.beginTransaction();
            user = new User();
            user.setAccount(account);
            user.setPassword(password);
            user.setStudent(student);
            session.save(user);
            ts.commit();
            session.close();
            return true;
        } else {
            session.close();
            return false;
        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
