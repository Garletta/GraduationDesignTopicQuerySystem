package Action;

import DAO.RegisterDao;
import com.opensymphony.xwork2.ActionSupport;

//注册模块
public class RegisterAction extends ActionSupport {

    private String account;         //注册账号
    private String password;        //注册密码
    private String student;         //注册人用户名
    private RegisterDao registerDao;//注册Dao

    @Override
    public String execute() {
        boolean insert = registerDao.Register(account,password,student);
        //insert为真,表示注册成功,新账号已成功加入数据库
        //insert为假,表示注册失败,正在注册的账号在数据库中已存在,即已被注册
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
        //注册信息中账号、密码、姓名不能为空,为空时返回错误显示
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
