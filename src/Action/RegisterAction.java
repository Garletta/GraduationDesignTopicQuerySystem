package Action;

import DAO.RegisterDao;
import com.opensymphony.xwork2.ActionSupport;

//注册模块
public class RegisterAction extends ActionSupport {

    private String account;
    private String password;
    private String student;
    private RegisterDao registerDao;

    @Override
    public String execute() {
        boolean insert = registerDao.Register(account,password,student);
        if(insert) {
            addActionMessage("注册成功!请返回登陆!");
            return "success";
        } else {
            addActionError("注册失败!账号已注册!");
            return "error";
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
        if(student == null || student.equals("")) {
            this.addFieldError("student","姓名不能为空");
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

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public RegisterDao getRegisterDao() {
        return registerDao;
    }

    public void setRegisterDao(RegisterDao registerDao) {
        this.registerDao = registerDao;
    }
}
