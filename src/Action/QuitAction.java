package Action;

import com.opensymphony.xwork2.ActionContext;

import java.util.Map;

public class QuitAction {

    public String execute() {
        Map session = ActionContext.getContext().getSession();
        session.remove("user"); //删除session中的key为user的数据
        return "success";
    }
}
