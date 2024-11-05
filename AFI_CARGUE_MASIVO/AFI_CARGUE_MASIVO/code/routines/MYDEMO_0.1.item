package routines;


import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Blob;
import java.nio.file.Files;



public class MYDEMO {
public static byte[] ByteArrayFromFile(String filepath) {
	try{ 
		
		java.io.File file=new java.io.File(filepath);
		java.io.FileInputStream fis = new java.io.FileInputStream(file);
		int fileLength = (int) file.length();
		byte[] incoming_file_data = new byte[fileLength]; // allocate byte array of right size
		fis.read(incoming_file_data, 0, fileLength ); // read into byte array
		fis.close();
		//System.out.println(incoming_file_data.length+"");
	return incoming_file_data;
		}catch(Exception err){
			//err.printStackTrace();
			//err.wait();
			return null;
	}
}


public static byte[] ByteArrayFromFile1(String filepath) {
	try{ 
		
		Path path = Paths.get(filepath);
		byte[] data = Files.readAllBytes(path);
		
	return data;
		}catch(Exception err){
			//err.printStackTrace();
			//err.wait();
			return null;
	}
}



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
	


public static String FileNameFromFile(String filepath) {
	try{ 
		Path p = Paths.get(filepath);
		String file = p.getFileName().toString();
			
	return file;
	}catch(Exception err){
	err.printStackTrace();return null;
	}
	}

public static String FileExtenFromFile(String filepath) {
	try{ 
		Path p = Paths.get(filepath);
		String file = p.getFileName().toString();
		String file1 = file.substring (file.lastIndexOf(".") + 1).toLowerCase();	
	return file1;
	}catch(Exception err){
	err.printStackTrace();return null;
	}
	}
}