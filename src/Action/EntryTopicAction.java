package Action;

import DAO.EntryTopicDao;
import com.opensymphony.xwork2.ActionSupport;

//录入新的毕业设计题目
public class EntryTopicAction extends ActionSupport {

    private String student;
    private String topic;
    private String college;
    private EntryTopicDao entryTopicDao;

    @Override
    public String execute() {
        boolean entry = entryTopicDao.EntryTopic(student,topic,college);
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
