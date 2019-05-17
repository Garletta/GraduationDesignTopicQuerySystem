package DAO;

import Table.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

//登陆模块
public class LoginDao {

    private User user;
    private SessionFactory sessionFactory;

    public User Login(String account, String password) {
        Session session = sessionFactory.openSession();
        user = session.get(User.class, account);
        session.close();
        if(user == null) {
            return null;
        } else if(!user.getPassword().equals(password)) {
            user.setPassword("");
        }
        return user;
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
