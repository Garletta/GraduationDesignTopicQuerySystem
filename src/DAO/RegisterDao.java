package DAO;

import Table.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

//注册模块
public class RegisterDao {

    private User user;  //一个User对象
    private SessionFactory sessionFactory;  //session工厂对象

    //用sessionFactory打开一个session,然后根据账号传参查询数据库
    //查询不到的匹配项,允许注册该新账号,开启一个事务并把新账号的数据写入数据库,返回true
    //查询到匹配项,表示账号已存在,注册失败,返回false
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
