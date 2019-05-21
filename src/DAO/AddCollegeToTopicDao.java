package DAO;

import Table.Design;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

//往已有毕业设计题目中录入学院名Dao
public class AddCollegeToTopicDao {

    private Design design;  //一个Design对象
    private SessionFactory sessionFactory;  //session工厂对象

    //用sessionFactory打开一个session,然后根据账号传参查询数据库
    //如果查询到的题目学院名称和传参相同,表示重复录入,返回false
    //否则开启一个事务并更新学院名,返回true
    public boolean addCollege(String student, String college) {
        Session session = sessionFactory.openSession();
        design = session.get(Design.class, student);
        if(design.getCollege().equals(college)) {
            session.close();
            return false;
        } else {
            design.setCollege(college);
            Transaction ts = session.beginTransaction();
            session.saveOrUpdate(design);
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
