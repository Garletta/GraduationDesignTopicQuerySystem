package DAO;

import Table.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

//登陆模块
public class LoginDao {

    private User user;  //一个User对象
    private SessionFactory sessionFactory;  //session工厂对象

    //用sessionFactory打开一个session,然后根据账号传参查询数据库
    //查询不到的匹配项,表示账号不存在,返回空
    //查询到匹配项,但密码与传参不一致,把得到的对象密码置空串返回
    //成功查询到匹配项并且密码正确,返回查询结果对象
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
