package routines;
import java.util.*;
import java.io.*;

public class ValidationRules {
	
	public static int CifrasNumero(int n) {
		
		int cifras = 0;
		
		if (n==0){
			cifras =1;
		} else {
			while(n!=0){
				n = n/10;
				cifras++;
			}
		}
		return (cifras);
	}
		
	public static String completarCodigo(int n) {
		
		String valor = String.valueOf(n);
		
		if (valor.length()==1){
			valor="00"+valor;
		}else if(valor.length()==2){
			valor="0"+valor;
		}
		return (valor);
	}
	
}	