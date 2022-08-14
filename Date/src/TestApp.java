import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class TestApp {

	public static void main(String[] args) throws IOException, ParseException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("enter the dob in the following format(dd-MM-yyyy):");
		String dob = br.readLine();
		
		//Converting String Object to util.Date object
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date uDob = sdf1.parse(dob);
		
		//Converting String Object to sql.date Object
		 long l = uDob.getTime();
		 Date sDob = new java.sql.Date(l);
		 System.out.println("SQLDATE DOB:"+sDob);
		 
		 //Setting the input values
	}

}


	
	
	 
	 