package Action;

import DAO.AddCollegeToTopicDao;
import DAO.QueryTopicDao;
import Table.Design;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;
import java.util.Map;

//往已有毕业设计题目中录入学院名
public class AddCollegeToTopicAction extends ActionSupport {

    private String student;             //负责人姓名
    private String college;             //学院名
    private AddCollegeToTopicDao addCollegeToTopicDao;//添加学院Dao
    private QueryTopicDao queryTopicDao;//查询Dao
    private ArrayList<Design> topics;   //毕业设计题目查询结果集

    @Override
    public String execute() {
        boolean addCollege = addCollegeToTopicDao.addCollege(student,college);
        //添加学院后更新页面的毕业设计题目展示表
        topics = queryTopicDao.QueryAll();
        Map session = ActionContext.getContext().getSession();
        session.put("topics",topics);
        //addCollege为真,录入成功,数据已更新到数据库
        //addCollege为假,录入失败,在页面显示录入失败等红字提示
        if(addCollege) {
            addActionMessage("录入成功!");
            return "success";
        } else {
            addActionError("录入失败!重复录入或录入信息不合法!");
            return "error";
        }
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public AddCollegeToTopicDao getAddCollegeToTopicDao() {
        return addCollegeToTopicDao;
    }

    public QueryTopicDao getQueryTopicDao() {
        return queryTopicDao;
    }

    public void setQueryTopicDao(QueryTopicDao queryTopicDao) {
        this.queryTopicDao = queryTopicDao;
    }

    public void setAddCollegeToTopicDao(AddCollegeToTopicDao addCollegeToTopicDao) {
        this.addCollegeToTopicDao = addCollegeToTopicDao;
    }
}
