package Filter;

import Table.User;

import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//登陆检查过滤器
@WebFilter(urlPatterns = {"/graduation.jsp","/addCollegeToTopic.jsp","/entryTopic.jsp","/queryTopic.jsp","/showTopic.jsp","/query.action","/entry.action","/addCollege.action"})
public class LoginFilter implements javax.servlet.Filter {

    public void destroy() {
    }

    public void doFilter(javax.servlet.ServletRequest req, javax.servlet.ServletResponse resp, javax.servlet.FilterChain chain) throws javax.servlet.ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if(user == null || user.getStudent().equals("")) {
            request.getRequestDispatcher("/login.jsp").forward(req, resp);
        } else {
            chain.doFilter(req, resp);
        }
    }

    public void init(javax.servlet.FilterConfig config) throws javax.servlet.ServletException {

    }

}
