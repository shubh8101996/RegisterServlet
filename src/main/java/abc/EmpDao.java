package abc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmpDao {

	public int registerEmployee(EmpBean bean) throws ClassNotFoundException, SQLException {

		EmpBean ee = new EmpBean();
		
		Class.forName("oracle.jdbc.driver.OracleDriver");

		String Insert = "INSERT INTO emp"
				+ "(Emp_Name,Emp_ID,Emp_Department,Emp_Position,Hire_Date,Emp_Salary) VALUES" + "(?,?,?,?,?,?);";

		int result = 0;
		
		String dbURL = "jbdc:oracle:thin:@localhost:1521:orcl";
		String username = "system";
		String password = "tiger";

		Connection connection = DriverManager.getConnection(dbURL, username, password);
		System.out.println("Connected Successfully Database ");
		int time = DriverManager.getLoginTimeout();
		System.out.println(time);

		PreparedStatement preparedStatement = connection.prepareStatement(Insert);
		preparedStatement.setString(1, ee.getEmpName());
		preparedStatement.setString(2, ee.getEmpID());
		preparedStatement.setString(3, ee.getEmpDemp());
		preparedStatement.setString(4, ee.getEmpPosition());
		preparedStatement.setString(5, ee.getEmpHireDate());
		preparedStatement.setLong(6, ee.getEmpSalary());

		System.out.println(preparedStatement);
		result = preparedStatement.executeUpdate();
		
		
		connection.close();

		return result;

	}

}
