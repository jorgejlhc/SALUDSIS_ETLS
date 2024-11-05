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
public class ValidateRows {

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
    public static double ValidateNull(Double rows) {
    	int i = 0;
        if (rows == null) {
            i = 0;
        }
        else
        {
        	i = 1;
        }       
        return i;
    }
    
    public static double ValidateNull(Integer rows, int toint) {
    	int i = 0;
        if (rows == null) {
            i = 0;
        }
        else
        {
        	i = 1;
        }       
        return i;
    }

    public static double ValidateNull(Double valor, Double pcups, Double pceco, String Sigla, Double valorCups) {
    	    	
    	double valorC = valorCups;
    	
        if ((valor == null) || (pcups == null) || (pceco == null)) {
           return valorC;
        }
        if (Sigla == null){
        	return valorCups;
        }
        if (Sigla.equals("DEP"))
        {   
        	valorC = (valor*(pcups/100))+valorCups;        	
        }               
        
        return valorC;              
    }     
    
    public static double ValidateDistESM(Double pceco, Double pcups, Double valor, Integer esm,Integer esm2, String sigla )
    {
    	double  valorC = 0;

    	if (pceco == null || pcups == null || valor == null || esm == null || esm2 == null)
    	{
    		return 0;
    	}
    	
    	if (esm != esm2){
    		return 0;
    	}
    	if (!sigla.equals("DEP"))
    	{
    		return 0;
    	}
    	valorC = valor * (pceco/100)*(pcups/100);
    	
    	return valorC;
    } 
    
    
    public static double ValidateNull2(Double valor, Double pcups, Double pceco, String Sigla, Double valorCups) {
    	
    	double valorC = valorCups;
    	
        if ((valor == null) || (pcups == null) || (pceco == null)) {
           return valorC;
        }
        if (Sigla == null){
        	return valorCups;
        }
        if (Sigla.equals("GGRL"))
        {                   
        	valorC = (valor*(pcups/100))+valorCups;
        	
        
        }   
        
        
        
        return valorC;              
    }     
    
    public static double ValidateDistESM2(Double pceco, Double pcups, Double valor, Integer esm,Integer esm2, String sigla )
    {
    	double  valorC = 0;
    	
    	if (pceco == null || pcups == null || valor == null || esm == null || esm2 == null)
    	{
    		return 0;
    	}
    	
    	if (esm != esm2){
    		return 0;
    	}
    	if (!sigla.equals("GGRL"))
    	{
    		return 0;
    	}    	
    	valorC = valor * (pceco/100)*(pcups/100);
    	
    	return valorC;
    } 
    
    
}
