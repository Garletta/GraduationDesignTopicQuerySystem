package Action;

import DAO.QueryTopicDao;
import Table.Design;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;
import java.util.Map;

//过滤指定毕业设计题目供操作
public class FilterTopicAction extends ActionSupport {

    private String keyword;             //过滤关键字
    private QueryTopicDao queryTopicDao;//查询Dao
    private ArrayList<Design> topics;   //毕业设计题目过滤结果集

    @Override
    public String execute() {
        //如果过滤关键字为空,表示查询数据库中全部毕业设计题目
        //根据关键字查询并返回数据库中负责人姓名、题目名称或所属学院名含有关键字的匹配项
        if(keyword == null || keyword.equals("")) {
            topics = queryTopicDao.QueryAll();
        } else {
            topics = queryTopicDao.QueryByKeyword(keyword);
        }
        Map session = ActionContext.getContext().getSession();
        session.put("topics",topics);   //把过滤结果更新到session
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
