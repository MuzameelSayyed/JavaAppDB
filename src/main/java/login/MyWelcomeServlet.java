package login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/welcome")
public class MyWelcomeServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public MyWelcomeServlet() {
        super();
    }

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        // Get existing session
        HttpSession session = request.getSession(false);

        String s3 = null;

        if (session != null) {

            s3 = (String) session.getAttribute("email");

        }

        System.out.println("Username : " + s3);

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter pw = response.getWriter();

        pw.println("<!DOCTYPE html>");

        pw.println("<html lang='en'>");

        pw.println("<head>");

        pw.println("<meta charset='UTF-8'>");

        pw.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");

        pw.println("<title>Muzammil Institute - Student Portal</title>");

        // ================= CSS =================

        pw.println("<style>");

        pw.println("* {");
        pw.println("    margin: 0;");
        pw.println("    padding: 0;");
        pw.println("    box-sizing: border-box;");
        pw.println("}");

        pw.println("body {");
        pw.println("    font-family: 'Segoe UI', Arial, sans-serif;");
        pw.println("    background: #f5f7ff;");
        pw.println("    color: #1e293b;");
        pw.println("    min-height: 100vh;");
        pw.println("}");

        // ================= NAVBAR =================

        pw.println(".navbar {");
        pw.println("    height: 72px;");
        pw.println("    background: linear-gradient(135deg, #312e81, #4f46e5);");
        pw.println("    display: flex;");
        pw.println("    align-items: center;");
        pw.println("    justify-content: space-between;");
        pw.println("    padding: 0 6%;");
        pw.println("    color: white;");
        pw.println("    box-shadow: 0 4px 15px rgba(0,0,0,0.12);");
        pw.println("}");

        pw.println(".logo {");
        pw.println("    display: flex;");
        pw.println("    align-items: center;");
        pw.println("    gap: 12px;");
        pw.println("}");

        pw.println(".logo-circle {");
        pw.println("    width: 44px;");
        pw.println("    height: 44px;");
        pw.println("    border-radius: 12px;");
        pw.println("    background: rgba(255,255,255,0.18);");
        pw.println("    display: flex;");
        pw.println("    align-items: center;");
        pw.println("    justify-content: center;");
        pw.println("    font-weight: 800;");
        pw.println("    font-size: 17px;");
        pw.println("}");

        pw.println(".logo h2 {");
        pw.println("    font-size: 20px;");
        pw.println("}");

        pw.println(".logout-btn {");
        pw.println("    color: white;");
        pw.println("    text-decoration: none;");
        pw.println("    padding: 9px 18px;");
        pw.println("    border: 1px solid rgba(255,255,255,0.35);");
        pw.println("    border-radius: 9px;");
        pw.println("    font-size: 13px;");
        pw.println("    transition: 0.3s;");
        pw.println("}");

        pw.println(".logout-btn:hover {");
        pw.println("    background: rgba(255,255,255,0.15);");
        pw.println("}");

        // ================= MAIN =================

        pw.println(".container {");
        pw.println("    max-width: 1100px;");
        pw.println("    margin: 0 auto;");
        pw.println("    padding: 55px 25px;");
        pw.println("}");

        // ================= WELCOME =================

        pw.println(".welcome-banner {");
        pw.println("    background: white;");
        pw.println("    border-radius: 22px;");
        pw.println("    padding: 35px;");
        pw.println("    display: flex;");
        pw.println("    justify-content: space-between;");
        pw.println("    align-items: center;");
        pw.println("    gap: 30px;");
        pw.println("    box-shadow: 0 10px 35px rgba(30,41,100,0.08);");
        pw.println("    border: 1px solid #eef2ff;");
        pw.println("    margin-bottom: 30px;");
        pw.println("}");

        pw.println(".welcome-content h1 {");
        pw.println("    color: #1e1b4b;");
        pw.println("    font-size: 30px;");
        pw.println("    margin-bottom: 10px;");
        pw.println("}");

        pw.println(".welcome-content h1 span {");
        pw.println("    color: #4f46e5;");
        pw.println("}");

        pw.println(".welcome-content p {");
        pw.println("    color: #64748b;");
        pw.println("    font-size: 15px;");
        pw.println("    line-height: 1.7;");
        pw.println("}");

        // ================= USER ICON =================

        pw.println(".user-icon {");
        pw.println("    width: 100px;");
        pw.println("    height: 100px;");
        pw.println("    border-radius: 50%;");
        pw.println("    background: linear-gradient(135deg, #4f46e5, #7c3aed);");
        pw.println("    color: white;");
        pw.println("    display: flex;");
        pw.println("    align-items: center;");
        pw.println("    justify-content: center;");
        pw.println("    font-size: 40px;");
        pw.println("}");

        // ================= SECTION TITLE =================

        pw.println(".section-title {");
        pw.println("    font-size: 21px;");
        pw.println("    color: #1e1b4b;");
        pw.println("    margin-bottom: 18px;");
        pw.println("}");

        // ================= CARDS =================

        pw.println(".cards {");
        pw.println("    display: grid;");
        pw.println("    grid-template-columns: repeat(3, 1fr);");
        pw.println("    gap: 20px;");
        pw.println("}");

        pw.println(".card {");
        pw.println("    background: white;");
        pw.println("    padding: 28px;");
        pw.println("    border-radius: 18px;");
        pw.println("    border: 1px solid #eef2ff;");
        pw.println("    box-shadow: 0 8px 25px rgba(30,41,100,0.06);");
        pw.println("    transition: 0.3s;");
        pw.println("}");

        pw.println(".card:hover {");
        pw.println("    transform: translateY(-5px);");
        pw.println("    box-shadow: 0 15px 30px rgba(30,41,100,0.10);");
        pw.println("}");

        pw.println(".card-icon {");
        pw.println("    font-size: 30px;");
        pw.println("    margin-bottom: 15px;");
        pw.println("}");

        pw.println(".card h3 {");
        pw.println("    color: #1e293b;");
        pw.println("    margin-bottom: 8px;");
        pw.println("}");

        pw.println(".card p {");
        pw.println("    color: #64748b;");
        pw.println("    font-size: 13px;");
        pw.println("    line-height: 1.6;");
        pw.println("}");

        // ================= EMAIL =================

        pw.println(".email-box {");
        pw.println("    margin-top: 25px;");
        pw.println("    padding: 14px 18px;");
        pw.println("    background: #eef2ff;");
        pw.println("    border-radius: 10px;");
        pw.println("    color: #3730a3;");
        pw.println("    font-size: 14px;");
        pw.println("    display: inline-block;");
        pw.println("}");

        // ================= FOOTER =================

        pw.println(".footer {");
        pw.println("    text-align: center;");
        pw.println("    margin-top: 55px;");
        pw.println("    color: #94a3b8;");
        pw.println("    font-size: 12px;");
        pw.println("}");

        // ================= RESPONSIVE =================

        pw.println("@media (max-width: 750px) {");

        pw.println("    .welcome-banner {");
        pw.println("        flex-direction: column-reverse;");
        pw.println("        text-align: center;");
        pw.println("    }");

        pw.println("    .cards {");
        pw.println("        grid-template-columns: 1fr;");
        pw.println("    }");

        pw.println("    .welcome-content h1 {");
        pw.println("        font-size: 25px;");
        pw.println("    }");

        pw.println("}");

        pw.println("</style>");

        pw.println("</head>");

        pw.println("<body>");

        // =====================================================
        // IF USER IS LOGGED IN
        // =====================================================

        if (s3 != null) {

            // ================= NAVBAR =================

            pw.println("<nav class='navbar'>");

            pw.println("<div class='logo'>");

            pw.println("<div class='logo-circle'>MI</div>");

            pw.println("<h2>Muzammil Institute</h2>");

            pw.println("</div>");

            pw.println("<a href='logout' class='logout-btn'>Logout</a>");

            pw.println("</nav>");

            // ================= MAIN CONTAINER =================

            pw.println("<main class='container'>");

            // ================= WELCOME BANNER =================

            pw.println("<div class='welcome-banner'>");

            pw.println("<div class='welcome-content'>");

            pw.println("<h1>Welcome, <span>"
                    + s3
                    + "</span>!</h1>");

            pw.println("<p>");
            pw.println("You have successfully logged into your ");
            pw.println("Muzammil Institute student portal.");
            pw.println("</p>");

            pw.println("<div class='email-box'>");
            pw.println("📧 " + s3);
            pw.println("</div>");

            pw.println("</div>");

            pw.println("<div class='user-icon'>🎓</div>");

            pw.println("</div>");

            // ================= DASHBOARD =================

            pw.println("<h2 class='section-title'>Student Dashboard</h2>");

            pw.println("<div class='cards'>");

            // Card 1

            pw.println("<div class='card'>");

            pw.println("<div class='card-icon'>📚</div>");

            pw.println("<h3>My Courses</h3>");

            pw.println("<p>");
            pw.println("View your enrolled courses, subjects and learning materials.");
            pw.println("</p>");

            pw.println("</div>");

            // Card 2

            pw.println("<div class='card'>");

            pw.println("<div class='card-icon'>📅</div>");

            pw.println("<h3>Class Schedule</h3>");

            pw.println("<p>");
            pw.println("Check your upcoming classes, sessions and important timings.");
            pw.println("</p>");

            pw.println("</div>");

            // Card 3

            pw.println("<div class='card'>");

            pw.println("<div class='card-icon'>🏆</div>");

            pw.println("<h3>My Progress</h3>");

            pw.println("<p>");
            pw.println("Track your learning progress, performance and achievements.");
            pw.println("</p>");

            pw.println("</div>");

            pw.println("</div>");

            // ================= FOOTER =================

            pw.println("<div class='footer'>");

            pw.println("© 2026 Muzammil Institute | Student Portal");

            pw.println("</div>");

            pw.println("</main>");

        } else {

            // =====================================================
            // SESSION EXPIRED
            // =====================================================

            pw.println("<div class='container'>");

            pw.println("<div class='welcome-banner'>");

            pw.println("<div class='welcome-content'>");

            pw.println("<h1>Session Expired</h1>");

            pw.println("<p>");
            pw.println("Your login session has expired.");
            pw.println("Please login again to access the student portal.");
            pw.println("</p>");

            pw.println("<div class='email-box'>");

            pw.println("<a href='login.html' "
                    + "style='color:#3730a3; "
                    + "font-weight:bold; "
                    + "text-decoration:none;'>");

            pw.println("← Back to Login");

            pw.println("</a>");

            pw.println("</div>");

            pw.println("</div>");

            pw.println("<div class='user-icon'>🔒</div>");

            pw.println("</div>");

            pw.println("</div>");

        }

        pw.println("</body>");

        pw.println("</html>");

    }

}
