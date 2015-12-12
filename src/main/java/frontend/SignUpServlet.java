package frontend;

import servlets.AccountService;
import servlets.UserProfile;
import templater.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zak on 14.11.2015.
 */
public class SignUpServlet extends HttpServlet {

    private AccountService accountService;

    public SignUpServlet(AccountService accountService) {
        this.accountService = accountService;
    }
    
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        response.setStatus(HttpServletResponse.SC_OK);
        
        Map<String, Object> pageVariables = new HashMap<String, Object>();
        
        if (accountService.addUser(login, new UserProfile(login, password, ""))) {
            pageVariables.put("signupStatus", "Success add new user <b>" + login + "</b>");
        } else {
            pageVariables.put("signupStatus", "Problem with registration");
        }
        response.getWriter().println(PageGenerator.getPage("signupstatus.html", pageVariables));
    }
}