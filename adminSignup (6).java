package pack;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class adminSigup extends HttpServlet{
	PreparedStatement ps;
	Connection con;
	ResultSet rs;
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws IOException,ServletException {
		PrintWriter out = res.getWriter();
		String name = req.getParameter("username");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		boolean valid = false;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql:///EventManagementSys","root","abcd");
			while(rs.next()){
				if(pass.equals(rs.getString("fname"))){
					valid = true;
					break;
				}
			}
			if(valid){
				out.print("<html><font color=red>");
				out.print("already exists");
				out.print("</font></html>");
				RequestDispatcher rd = req.getRequestDispatcher("practice.html");
			rd.include(req,res);
			}
			else{
			ps = con.prepareStatement("insert into opinion values(?, ?, ?)");
			ps.setString(1,fname);
			ps.setString(2,learn);
			ps.setString(3,eat);
			ps.executeUpdate();
			out.print("inserted succesfully");
			}
		}
		catch(Exception e){
			out.print("exception is caught");
		}
	}
}