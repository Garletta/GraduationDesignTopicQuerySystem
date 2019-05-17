package Action;

import DAO.QueryTopicDao;
import Table.Design;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;
import java.util.Map;

//过滤指定毕业设计题目供操作
public class FilterTopicAction extends ActionSupport {

    private String keyword;
    private QueryTopicDao queryTopicDao;
    private ArrayList<Design> topics;

    @Override
    public String execute() {
        if(keyword == null || keyword.equals("")) {
            topics = queryTopicDao.QueryAll();
        } else {
            topics = queryTopicDao.QueryByKeyword(keyword);
        }
        Map session = ActionContext.getContext().getSession();
        session.put("topics",topics);
        return "success";
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
