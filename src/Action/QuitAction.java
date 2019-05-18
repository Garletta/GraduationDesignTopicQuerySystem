package Action;

import com.opensymphony.xwork2.ActionContext;

import java.util.Map;

public class QuitAction {

    public String execute() {
        Map session = ActionContext.getContext().getSession();
        session.remove("user");
        return "success";
    }
}
