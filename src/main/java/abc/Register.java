package abc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmpDao dao;



	@Override
	public void init() throws ServletException {

		dao = new EmpDao();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		String empName = request.getParameter("name");
		String employeeID = request.getParameter("employee-id");
		String empDepartment = request.getParameter("department");
		String empposition = request.getParameter("position");
		String HireDate = request.getParameter("hire-date");
		String empSalary = request.getParameter("salary");

		long myLong = Long.parseLong(empSalary);

		EmpBean bean = new EmpBean();

		bean.setEmpName(empName);
		bean.setEmpID(employeeID);
		bean.setEmpDemp(empDepartment);
		bean.setEmpHireDate(HireDate);
		bean.setEmpPosition(empposition);
		bean.setEmpSalary(myLong);

		try {
			dao.registerEmployee(bean);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        response.sendRedirect("employeedetails.html");

	}

}
