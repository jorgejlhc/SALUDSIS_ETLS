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

import org.apache.commons.codec.binary.Base64;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import routines.system.JSONObject ;

public class Utils {

    public static String Encode64(String message) {
    	return Base64.encodeBase64String(message.getBytes());
    }
    
    public static String firstNChars(String str, int n) {
        if (str == null) {
            return null;
        }
        return str.substring(0, Math.min(str.length(), n));
    }
    
    public static boolean SendEmailSmtp(String host, String port, String username, String password, String from, String to, String subject, String body) {
    	boolean starttls = true;
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", String.valueOf(starttls));
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setHeader("X-Priority", "1");
            message.setContent(body, "text/html;charset=UTF-8");

            Transport.send(message);
            
            return true;

        } catch (MessagingException e) {
            e.printStackTrace();
        	//throw new RuntimeException(e);
        	return false;  
        }
    }
      
    
    public static String GetAuthHeaderSmsProvider(String authServer, String username, String password, String authEmailServer) throws Exception {
    	
    	if("basic".equals(authEmailServer)) {
    		String data = username + ":" + password ;
    		String encodedString = Utils.Encode64(data);
    		return "Basic " + encodedString;
    		
    	}else if("cloudcitysms".equals(authEmailServer)) {
            try {
                URL url = new URL(authServer);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("POST");
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setDoOutput(true);

                String jsonInputString = "{\"username\": \"" + username + "\", \"password\": \"" + password + "\"}";

                try (DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream())) {
                    byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
                    outputStream.write(input, 0, input.length);
                }

                int responseCode = connection.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String line;
                    StringBuilder response = new StringBuilder();
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }
                    reader.close();

                    String jsonResponse = response.toString();
                    String token = parseTokenFromJson(jsonResponse);

                    if (token != null) {
                        return "Bearer " + token;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw e;
            }
            
            throw new Exception("Error no fue posible autenticarse con proveedor cloudcitySms");
    		
    	}
    	throw new Exception("Error Proveedor de Sms no soportado");
        
    }

    public static String parseTokenFromJson(String jsonResponse) {
 
        try {
            JSONObject jsonObject = new JSONObject(jsonResponse);
            String token = jsonObject.getString("data");
            return token;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
