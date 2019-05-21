package Action;

import DAO.EntryTopicDao;
import com.opensymphony.xwork2.ActionSupport;

//录入新的毕业设计题目
public class EntryTopicAction extends ActionSupport {

    private String student; //新题目负责人姓名
    private String topic;   //新题目名称
    private String college; //新题目所属学院
    private EntryTopicDao entryTopicDao;//新题目录入Dao

    @Override
    public String execute() {
        boolean entry = entryTopicDao.EntryTopic(student,topic,college);
        //entry为真,表示录入成功
        //entry为假,表示录入失败,重复录入
        if(entry) {
            addActionMessage("录入成功,请返回上一层菜单.");
            return "success";
        } else {
            addActionError("重复录入!");
            return "error";
        }
    }

    @Override
    public void validate() {
        super.validate();
        //录入新题目信息中负责人姓名、毕业设计题目不能为空,为空时返回错误显示
        if(student == null || student.equals("")) {
            this.addFieldError("student","负责人不能为空!");
        }
        if(topic == null || topic.equals("")) {
            this.addFieldError("topic","毕业设计题目不能为空!");
        }
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public EntryTopicDao getEntryTopicDao() {
        return entryTopicDao;
    }

    public void setEntryTopicDao(EntryTopicDao entryTopicDao) {
        this.entryTopicDao = entryTopicDao;
    }
}
