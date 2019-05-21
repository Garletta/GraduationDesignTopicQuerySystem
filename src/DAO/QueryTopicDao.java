package DAO;

import Table.Design;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.ArrayList;

//按关键字查询毕业设计题目
public class QueryTopicDao {

    private ArrayList<Design> topics;   //查询毕业设计题目结果集
    private SessionFactory sessionFactory;  //session工厂对象

    //用sessionFactory打开一个session,然后根据账号传参查询数据库
    //根据关键字查询并返回数据库中负责人姓名、题目名称或所属学院名含有关键字的匹配项
    public ArrayList<Design> QueryByKeyword(String keyword) {
        Session session = sessionFactory.openSession();
        String HQL = "from Design where concat(student,topic,college) like :keyword";
        Query query = session.createQuery(HQL);
        query.setParameter("keyword","%" + keyword + "%");
        topics = (ArrayList<Design>) query.list();
        session.close();
        return topics;
    }

    //查询并返回数据库中全部毕业设计题目
    public ArrayList<Design> QueryAll() {
        Session session = sessionFactory.openSession();
        String HQL = "from Design ";
        Query query = session.createQuery(HQL);
        topics = (ArrayList<Design>) query.list();
        session.close();
        return topics;
    }

    public ArrayList<Design> getTopics() {
        return topics;
    }

    public void setTopics(ArrayList<Design> topics) {
        this.topics = topics;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
