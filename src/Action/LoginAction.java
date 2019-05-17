package Action;

import DAO.LoginDao;
import Table.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;

//登陆模块
public class LoginAction extends ActionSupport {

    private String account;
    private String password;
    private LoginDao loginDao;

    @Override
    public String execute() {
        User user = loginDao.Login(account, password);
        if(user == null) {
            addActionError("账号不存在!");
            return "error";
        } else if(user.getPassword().equals("")) {
            addActionError("密码不正确!");
            return "error";
        } else{
            Map session = ActionContext.getContext().getSession();
            session.put("user",user);
            return "success";
        }
    }

    @Override
    public void validate() {
        super.validate();
        if(account == null || account.equals("")) {
            this.addFieldError("account","账号不能为空");
        }
        if(password == null || password.equals("")) {
            this.addFieldError("password","密码不能为空");
        }
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LoginDao getLoginDao() {
        return loginDao;
    }

    public void setLoginDao(LoginDao loginDao) {
        this.loginDao = loginDao;
    }
}
