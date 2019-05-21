package Action;

import DAO.LoginDao;
import Table.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;

//登陆模块
public class LoginAction extends ActionSupport {

    private String account;     //登陆账号
    private String password;    //登陆密码
    private LoginDao loginDao;  //登陆Dao

    @Override
    public String execute() {
        User user = loginDao.Login(account, password);
        //user为空,表示账号在数据库中找不到,即账号不存在
        //user的密码为空字符串,表示数据库中密码与用户输入密码不一致,即密码不正确
        //登陆信息正确,在session中保存正在登陆账号的信息,进入系统
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
        //登陆信息中账号、密码不能为空,为空时返回错误显示
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
