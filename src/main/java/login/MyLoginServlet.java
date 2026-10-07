package login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MyLoginServlet
 */
@WebServlet("/login")
public class MyLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		try {
			Class c =Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XEPDB1","system","oracle");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println(e);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String s1 = request.getParameter("email");
			String s2 = request.getParameter("password");
			
			
			System.out.println("Username : " + s1);
			System.out.println("Password : " + s2);
			
			
			PreparedStatement pstmt = con.prepareStatement("select * from uinfo where email=? and pword = ?");
			pstmt.setString(1, s1);
			pstmt.setString(2, s2);
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				
				HttpSession session = request.getSession();

			    session.setAttribute("email", s1);

			    response.sendRedirect(
			        request.getContextPath() + "/welcome"
			    );
			    
			}else {
				response.setContentType("text/html");
				response.setCharacterEncoding("UTF-8");

				PrintWriter pw = response.getWriter();

				pw.println("<!DOCTYPE html>");

				pw.println("<html lang='en'>");

				pw.println("<head>");

				pw.println("<meta charset='UTF-8'>");

				pw.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");

				pw.println("<title>Login Failed - Muzammil Institute</title>");

				pw.println("<style>");

				pw.println("* {");

				pw.println("    margin: 0;");

				pw.println("    padding: 0;");

				pw.println("    box-sizing: border-box;");

				pw.println("}");

				pw.println("body {");

				pw.println("    font-family: Arial, sans-serif;");

				pw.println("    min-height: 100vh;");

				pw.println("    display: flex;");

				pw.println("    align-items: center;");

				pw.println("    justify-content: center;");

				pw.println("    background: linear-gradient(135deg, #312e81, #7c3aed);");

				pw.println("}");

				pw.println(".error-card {");

				pw.println("    width: 90%;");

				pw.println("    max-width: 430px;");

				pw.println("    background: white;");

				pw.println("    padding: 45px 35px;");

				pw.println("    border-radius: 24px;");

				pw.println("    text-align: center;");

				pw.println("    box-shadow: 0 20px 50px rgba(0,0,0,0.2);");

				pw.println("}");

				pw.println(".error-icon {");

				pw.println("    width: 80px;");

				pw.println("    height: 80px;");

				pw.println("    margin: 0 auto 25px;");

				pw.println("    border-radius: 50%;");

				pw.println("    background: #fee2e2;");

				pw.println("    color: #dc2626;");

				pw.println("    font-size: 42px;");

				pw.println("    display: flex;");

				pw.println("    align-items: center;");

				pw.println("    justify-content: center;");

				pw.println("}");

				pw.println("h1 {");

				pw.println("    color: #1e1b4b;");

				pw.println("    font-size: 27px;");

				pw.println("    margin-bottom: 15px;");

				pw.println("}");

				pw.println("p {");

				pw.println("    color: #64748b;");

				pw.println("    font-size: 15px;");

				pw.println("    line-height: 1.7;");

				pw.println("    margin-bottom: 30px;");

				pw.println("}");

				pw.println(".back-btn {");

				pw.println("    display: inline-block;");

				pw.println("    padding: 15px 30px;");

				pw.println("    background: linear-gradient(135deg, #4f46e5, #7c3aed);");

				pw.println("    color: white;");

				pw.println("    text-decoration: none;");

				pw.println("    border-radius: 12px;");

				pw.println("    font-weight: bold;");

				pw.println("    font-size: 15px;");

				pw.println("    transition: 0.3s;");

				pw.println("}");

				pw.println(".back-btn:hover {");

				pw.println("    transform: translateY(-2px);");

				pw.println("    box-shadow: 0 8px 20px rgba(79,70,229,0.3);");

				pw.println("}");

				pw.println(".footer {");

				pw.println("    margin-top: 25px;");

				pw.println("    font-size: 12px;");

				pw.println("    color: #94a3b8;");

				pw.println("}");

				pw.println("</style>");

				pw.println("</head>");

				pw.println("<body>");

				pw.println("<div class='error-card'>");

				pw.println("<div class='error-icon'>✕</div>");

				pw.println("<h1>Login Failed</h1>");

				pw.println("<p>");

				pw.println("    Invalid email or password.<br>");

				pw.println("    Please check your credentials and try again.");

				pw.println("</p>");

				pw.println("<a href='" + request.getContextPath()
				        + "/login.html' class='back-btn'>");

				pw.println("    ← Back to Login");

				pw.println("</a>");

				pw.println("<div class='footer'>");

				pw.println("    Muzammil Institute<br>");

				pw.println("    Student Portal");

				pw.println("</div>");

				pw.println("</div>");

				pw.println("</body>");

				pw.println("</html>");
			    
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println(e);;
		}
		
	}

}
