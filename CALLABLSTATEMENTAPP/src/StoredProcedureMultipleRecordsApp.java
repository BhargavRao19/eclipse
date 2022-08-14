import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;
import com.abc.utility.JdbcUtil;
/*DELIMITER $$

CREATE
   
    PROCEDURE `xyz`.``P_GET_PROD_DETAILS_BY_ID``P_GET_PRODS_BY_NAMES``(IN pname1 VARCHAR(20),IN pname2 VARCHAR(20))
    
   
	BEGIN
                SELECT pid,pname,price,quantity FROM products WHERE pname IN(pname1,pname2);
	END$$

DELIMITER ;*/

public class StoredProcedureMultipleRecordsApp {
	//storedProcedure query syntax is:{CALL STORED_PROCEDURENAME(PARAMS)}
	private static final String CALLABLE_QUERY="{CALL P_GET_PRODS_BY_NAMES(?,?)}";
		public static void main(String[] args) {
		//JDBC resources
		String product1 =null;
		String product2 =null;
		Connection connection=null;
		CallableStatement cstmt = null;
		Scanner scanner=null;
		ResultSet resultSet = null;
		
		scanner = new Scanner(System.in);
		try {
			connection = JdbcUtil.getDbConnection();
			
			// Get CALLABLESTATEMENT Object in PRECOMPILED way.
			cstmt = connection.prepareCall(CALLABLE_QUERY);
			
			if(scanner != null) {
			System.out.print("Enter the first product name:: ");
			product1 = scanner.next();
			
			System.out.print("Enter the second product name:: ");
			product2 = scanner.next();
			}
			
			if(cstmt !=null) {
				// Setting the IN PARAM with user defined values
				cstmt.setString(1,product1);
				cstmt.setString(2,product2);
			}
			
			// Executing the CALLABLESTATEMENT
			if(cstmt !=null) {
				
				cstmt.execute();
			}
			//Fetch the result and process the result
			resultSet = cstmt.getResultSet();
			
			System.out.println("PID\tPNAME\tPCOST\tQTY");
			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getString(3)
						+ "\t" + resultSet.getInt(4));
		}
		}catch(SQLException se) {
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {

			if (scanner != null) {
				scanner.close();
			}
			JdbcUtil.close(resultSet, cstmt, connection);
		}
		}
}

