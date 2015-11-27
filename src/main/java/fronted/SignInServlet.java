package fronted;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import servlets.AccountService;

/**
 * Created by zak on 14.11.2015.
 */
public class SignInServlet {

    private String login = "";

    public SignInServlet(AccountService accountService) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {
        Map<String, Object> pageVariables = new HashMap<String,Object>();
        pageVariables.put("lastLogin", login == null ? "" : login);
        response.getWriter().println("");

    }
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {

    }
}
