package routines;

/*
 * user specification: the function's comment should contain keys as follows: 1. write about the function's comment.but
 * it must be before the "{talendTypes}" key.
 * 
 * 2. {talendTypes} 's value must be talend Type, it is required . its value should be one of: String, char | Character,
 * long | Long, int | Integer, boolean | Boolean, byte | Byte, Date, double | Double, float | Float, Object, short |
 * Short
 * 
 * 3. {Category} define a category for the Function. it is required. its value is user-defined .
 * 
 * 4. {param} 's format is: {param} <type>[(<default value or closed list values>)] <name>[ : <comment>]
 * 
 * <type> 's value should be one of: string, int, list, double, object, boolean, long, char, date. <name>'s value is the
 * Function's parameter name. the {param} is optional. so if you the Function without the parameters. the {param} don't
 * added. you can have many parameters for the Function.
 * 
 * 5. {example} gives a example for the Function. it is optional.
 */
public class TEST {
 public static byte[] ByteArrayFromFile(String filepath, String estado) {
     if (estado == "Existe") {
    	 try{ 
    			java.io.File file=new java.io.File(filepath);
    			java.io.FileInputStream fis = new java.io.FileInputStream(file);
    			int fileLength = (int) file.length();
    			byte[] incoming_file_data = new byte[fileLength]; // allocate byte array of right size
    			fis.read(incoming_file_data, 0, fileLength ); // read into byte array
    			fis.close();
    		return incoming_file_data; 
    	 }catch(Exception err){
 			err.printStackTrace();return null;
 	}
 }
	return null;
}
}