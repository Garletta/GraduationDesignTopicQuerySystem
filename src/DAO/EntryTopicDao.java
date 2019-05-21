package DAO;

import Table.Design;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

//录入新的毕业设计题目Dao
public class EntryTopicDao {

    private Design design;  //一个Design对象
    private SessionFactory sessionFactory;  //session工厂对象

    //用sessionFactory打开一个session,然后根据账号传参查询数据库
    //如果查询到题目负责人已存在,表示重复录入(我们规定每个人只能有一个毕业设计题目)
    //数据库中不存在该题目,开启一个事务并把该新题目写入数据库
    public boolean EntryTopic(String student, String topic, String college) {
        Session session = sessionFactory.openSession();
        design = session.get(Design.class,student);
        if(design != null && design.getStudent().equals(student)) {
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
