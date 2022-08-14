import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

import com.abc.utility.JdbcUtil;

/*DELIMITER $$

CREATE
    
    PROCEDURE `xyz`.`P_GET_PROD_DETAILS_BY_ID`(IN id INT,OUT NAME VARCHAR(20),OUT cost INT,OUT qty INT)
    
	BEGIN
	        SELECT pname,price,quantity INTO NAME,cost,qty FROM product WHERE pid =id;

	END$$`products`

DELIMITER ;*/
public class SelectStoredProcedureApp {
	//storedProcedure query syntax is:{CALL STORED_PROCEDURENAME(PARAMS)}
private static final String CALLABLE_QUERY="{CALL P_GET_PROD_DETAILS_BY_ID(?,?,?,?)}";
	public static void main(String[] args) {
	//JDBC resources
	String pid =null;
	Connection connection=null;
	CallableStatement cstmt = null;
	Scanner scanner=null;
	
	scanner = new Scanner(System.in);
	try {
		connection = JdbcUtil.getDbConnection();
		// Get CALLABLESTATEMENT Object in PRECOMPILED way.
				cstmt = connection.prepareCall(CALLABLE_QUERY);
		if(scanner != null) {
		System.out.print("Enter the value of product id:: ");
		pid = scanner.next();
		}
		
		if(cstmt !=null) {
			// Setting the IN PARAM with user defined values
			cstmt.setInt(1,Integer.parseInt(pid));
		}
		if(cstmt !=null) {
			// Setting the OUT PARAM with JDBC dataTypes
			cstmt.registerOutParameter(2,Types.VARCHAR);
			cstmt.registerOutParameter(3,Types.INTEGER);
			cstmt.registerOutParameter(4,Types.INTEGER);
			
		}
		// Executing the CALLABLESTATEMENT
		if(cstmt !=null) {
			
			cstmt.execute();
		}
		
		if(cstmt !=null) {
			System.out.println("The name of the product is:: "+cstmt.getString(2));
			System.out.println("The cost of the product is:: "+cstmt.getInt(3));
			System.out.println("The quantity of the product is:: "+cstmt.getInt(4));
		}
	}
		catch(SQLException se) {
		if (se.getErrorCode() == 1403)
			System.out.println("Record not found for the given id :: " + pid);
		else
			se.printStackTrace();
		}
	catch(Exception e) {
		e.printStackTrace();
	}
	finally {

		if (scanner != null) {
			scanner.close();
		}

		JdbcUtil.close(null, cstmt, connection);
	}
}
}

