package routines;
import java.sql.Blob;

public class ConvertBlob {
	
    /**
     * helloExample: not return value, only print "hello" + message.
     * 
     * 
     * {talendTypes} String
     * 
     * {Category} User Defined
     * 
     * {param} string("world") input: The string need to be printed.
     * 
     * {example} helloExemple("world") # hello world !.
     */
	public static byte[] ByteArrayColumn(Object filepath) {
		try{ 

		Blob blob = (Blob) filepath;

		int blobLength = (int) blob.length(); 
		byte[] blobAsBytes = blob.getBytes(1, blobLength);

		//release the blob and free up memory. (since JDBC 4.0)
		blob.free();

		return blobAsBytes;
		}catch(Exception err){
		err.printStackTrace();return null;
		}
		}
}
