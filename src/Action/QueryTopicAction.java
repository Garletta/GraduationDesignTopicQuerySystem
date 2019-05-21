package Action;

import DAO.QueryTopicDao;
import Table.Design;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;
import java.util.Map;

//按关键字查询毕业设计题目
public class QueryTopicAction extends ActionSupport {

    private String keyword;             //查询关键字
    private QueryTopicDao queryTopicDao;//查询Dao
    private ArrayList<Design> topics;   //毕业设计题目查询结果集

    @Override
    public String execute() {
        topics = queryTopicDao.QueryByKeyword(keyword);
        //查询结果集为空,表示查询不到匹配关键字的任何毕业设计题目
        //把结果集添加到session
        if(topics == null) {
            addActionError("查询不到相关毕业设计题目!");
            return "error";
        } else {
            Map session = ActionContext.getContext().getSession();
            session.put("topics",topics);
            return "success";
        }
    }

    @Override
    public void validate() {
        super.validate();
        if(keyword == null && keyword.equals("")) {
            this.addFieldError("keyword","查询输入不能为空!");
        }
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public QueryTopicDao getQueryTopicDao() {
        return queryTopicDao;
    }

    public void setQueryTopicDao(QueryTopicDao queryTopicDao) {
        this.queryTopicDao = queryTopicDao;
    }
}
