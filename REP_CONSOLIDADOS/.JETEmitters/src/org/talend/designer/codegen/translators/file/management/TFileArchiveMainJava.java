package org.talend.designer.codegen.translators.file.management;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import java.util.List;
import java.util.Map;

public class TFileArchiveMainJava
{
  protected static String nl;
  public static synchronized TFileArchiveMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileArchiveMainJava result = new TFileArchiveMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "\t";
  protected final String TEXT_2 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_3 = " - Retrieving records from the datasource.\");" + NL + "\t\t\t";
  protected final String TEXT_4 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_5 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_6 = " - Retrieved records count: \"+ globalMap.get(\"";
  protected final String TEXT_7 = "_NB_LINE\") + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_8 = " - Written records count: \" + nb_line_";
  protected final String TEXT_9 = NL + "\t\t\t\tfinal StringBuffer log4jSb_";
  protected final String TEXT_10 = " = new StringBuffer();" + NL + "\t\t\t";
  protected final String TEXT_11 = " - Retrieving the record \" + (nb_line_";
  protected final String TEXT_12 = ") + \".\");" + NL + "\t\t\t";
  protected final String TEXT_13 = " - Writing the record \" + nb_line_";
  protected final String TEXT_14 = " + \" to the file.\");" + NL + "\t\t\t";
  protected final String TEXT_15 = " - Processing the record \" + nb_line_";
  protected final String TEXT_16 = " + \".\");" + NL + "\t\t\t";
  protected final String TEXT_17 = " - Processed records count: \" + nb_line_";
  protected final String TEXT_18 = NL + "                log.error(message_";
  protected final String TEXT_19 = ");";
  protected final String TEXT_20 = NL + "                System.err.println(message_";
  protected final String TEXT_21 = NL;
  protected final String TEXT_22 = NL + "\t\tString sourceFile_";
  protected final String TEXT_23 = " = ";
  protected final String TEXT_24 = ";" + NL + "\t";
  protected final String TEXT_25 = NL + NL + "    if (java.nio.file.Files.notExists(java.nio.file.Paths.get(sourceFile_";
  protected final String TEXT_26 = "), java.nio.file.LinkOption.NOFOLLOW_LINKS)){" + NL + "        throw new java.io.FileNotFoundException(sourceFile_";
  protected final String TEXT_27 = " + \" (The system cannot find the path specified)\");" + NL + "    }" + NL + "" + NL + "    String zipFile_";
  protected final String TEXT_28 = ";" + NL + "    " + NL + "    com.talend.compress.zip.Zip zip_";
  protected final String TEXT_29 = " = new com.talend.compress.zip.Zip(sourceFile_";
  protected final String TEXT_30 = ", zipFile_";
  protected final String TEXT_31 = ");" + NL + "    zip_";
  protected final String TEXT_32 = ".setOverwriteExistTargetZip(";
  protected final String TEXT_33 = ");" + NL + "\tzip_";
  protected final String TEXT_34 = ".setMakeTargetDir(";
  protected final String TEXT_35 = ".setCompressLevel(";
  protected final String TEXT_36 = ".setArchiveFormat(\"";
  protected final String TEXT_37 = "\");" + NL + "\tzip_";
  protected final String TEXT_38 = ".setAllFiles(";
  protected final String TEXT_39 = ");" + NL + "\t" + NL + "\t";
  protected final String TEXT_40 = "  " + NL + "    \t//build filename pattern filter" + NL + "\t    String[] patterns_";
  protected final String TEXT_41 = " = new String[";
  protected final String TEXT_42 = "];" + NL + "    \t";
  protected final String TEXT_43 = NL + "\t        patterns_";
  protected final String TEXT_44 = "[";
  protected final String TEXT_45 = "] = ";
  protected final String TEXT_46 = ";";
  protected final String TEXT_47 = NL + "  \t\tStringBuilder sbf_";
  protected final String TEXT_48 = " = new StringBuilder(); " + NL + "        sbf_";
  protected final String TEXT_49 = ".append(\"(\");" + NL + "        for (int i_";
  protected final String TEXT_50 = " = 0 ; i_";
  protected final String TEXT_51 = " < patterns_";
  protected final String TEXT_52 = ".length ; i_";
  protected final String TEXT_53 = "++) {" + NL + "            sbf_";
  protected final String TEXT_54 = ".append(patterns_";
  protected final String TEXT_55 = "[i_";
  protected final String TEXT_56 = "].replaceAll(\"\\\\.\", \"\\\\\\\\.\").replaceAll(\"\\\\*\", \".*\"));" + NL + "            if(i_";
  protected final String TEXT_57 = " != patterns_";
  protected final String TEXT_58 = ".length-1) sbf_";
  protected final String TEXT_59 = ".append(\"|\");" + NL + "        }        " + NL + "        sbf_";
  protected final String TEXT_60 = ".append(\")\");" + NL + "        final String maskStr_";
  protected final String TEXT_61 = " = new String(sbf_";
  protected final String TEXT_62 = ".toString());" + NL + "        " + NL + "        //apply the filter" + NL + "       \tzip_";
  protected final String TEXT_63 = ".setNamePatternFilter(maskStr_";
  protected final String TEXT_64 = ");" + NL + "\t";
  protected final String TEXT_65 = NL + "\t\tzip_";
  protected final String TEXT_66 = ".setSyncFlush(";
  protected final String TEXT_67 = NL + "\t   zip_";
  protected final String TEXT_68 = ".setContainSubDir(";
  protected final String TEXT_69 = ");" + NL + "\t   zip_";
  protected final String TEXT_70 = ".setEncoding(";
  protected final String TEXT_71 = ".setZip64Mode(\"";
  protected final String TEXT_72 = "\");" + NL + "\t   zip_";
  protected final String TEXT_73 = ".setEncrypted(";
  protected final String TEXT_74 = ");" + NL + "\t\t        " + NL + "\t   ";
  protected final String TEXT_75 = NL + "\t    " + NL + "\t   ";
  protected final String TEXT_76 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_77 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_78 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_79 = "; ";
  protected final String TEXT_80 = NL + "\t    " + NL + "\t   zip_";
  protected final String TEXT_81 = ".setPassword(decryptedPassword_";
  protected final String TEXT_82 = ");" + NL + "\t   ";
  protected final String TEXT_83 = NL + "\t      zip_";
  protected final String TEXT_84 = ".setUseZip4jEncryption(true);" + NL + "" + NL + "\t      ";
  protected final String TEXT_85 = NL + "\t\t     zip_";
  protected final String TEXT_86 = ".setEncryptionMethod(\"AES\");" + NL + "\t         zip_";
  protected final String TEXT_87 = ".setAesKeyStrength(";
  protected final String TEXT_88 = ");" + NL + "\t      ";
  protected final String TEXT_89 = NL + "\t   \t  zip_";
  protected final String TEXT_90 = ".setEncryptionMethod(\"ZIP_STANDARD\");" + NL + "\t   \t  ";
  protected final String TEXT_91 = NL + "\t\t  zip_";
  protected final String TEXT_92 = ".setUseZip4jEncryption(false);" + NL + "\t   ";
  protected final String TEXT_93 = NL + "  " + NL + "  " + NL + "   globalMap.put(\"";
  protected final String TEXT_94 = "_ARCHIVE_FILEPATH\",zipFile_";
  protected final String TEXT_95 = ");" + NL + "   " + NL + "   globalMap.put(\"";
  protected final String TEXT_96 = "_ARCHIVE_FILENAME\", new java.io.File(zipFile_";
  protected final String TEXT_97 = ").getName());" + NL + "" + NL + "   zip_";
  protected final String TEXT_98 = ".doZip();" + NL;
  protected final String TEXT_99 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	//this util class use by set log4j debug paramters
	class DefaultLog4jFileUtil {
	
		INode node = null;
	    String cid = null;
 		boolean isLog4jEnabled = false;
 		String label = null;
 		
 		public DefaultLog4jFileUtil(){
 		}
 		public DefaultLog4jFileUtil(INode node) {
 			this.node = node;
 			this.cid = node.getUniqueName();
 			this.label = cid;
			this.isLog4jEnabled = ("true").equals(org.talend.core.model.process.ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
 		}
 		
 		public void setCid(String cid) {
 			this.cid = cid;
 		}
 		
		//for all tFileinput* components 
		public void startRetriveDataInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_3);
    
			}
		}
		
		public void retrievedDataNumberInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
			}
		}
		
		public void retrievedDataNumberInfoFromGlobalMap(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    
			}
		}
		
		//for all tFileinput* components 
		public void retrievedDataNumberInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
			}
		}
		
		public void writeDataFinishInfo(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    
			}
		}
		
 		//TODO delete it and remove all log4jSb parameter from components
		public void componentStartInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node,boolean hasIncreased) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(hasIncreased?"":"+1");
    stringBuffer.append(TEXT_12);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node) {
			debugRetriveData(node,true);
		}
		
		//TODO rename or delete it
		public void debugWriteData(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    
			}
		}
		
		public void logCurrentRowNumberInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    
			}
		}
		
		public void logDataCountInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    
			}
		}

        public void logErrorMessage() {
            if(isLog4jEnabled){
            
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
            } else {
            
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
            }
        }
	}
	
	final DefaultLog4jFileUtil log4jFileUtil = new DefaultLog4jFileUtil((INode)(((org.talend.designer.codegen.config.CodeGeneratorArgument)argument).getArgument()));
	
    stringBuffer.append(TEXT_21);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();

	String directory = ElementParameterParser.getValue(node, "__SOURCE__");
	String zipFile = ElementParameterParser.getValue(node, "__TARGET__");
	String level = ElementParameterParser.getValue(node, "__LEVEL__");
	boolean mkDir = ("true").equals(ElementParameterParser.getValue(node, "__MKDIR__"));
	boolean isAllFile = ("true").equals(ElementParameterParser.getValue(node, "__ALL_FILES__"));
	boolean subDir = ("true").equals(ElementParameterParser.getValue(node, "__SUB_DIRECTROY__"));
	boolean overwrite = ("true").equals(ElementParameterParser.getValue(node, "__OVERWRITE__"));
	String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
	boolean isEncrypted = ("true").equals(ElementParameterParser.getValue(node, "__ENCRYPT_FILES__"));

	List<Map<String, String>> masks = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__MASK__");

	String zip64Mode = ElementParameterParser.getValue(node, "__ZIP64_MODE__");
	String encryptMethod = ElementParameterParser.getValue(node, "__ENCRYPT_METHOD__");
	int aesKeyStrength = "AES_STRENGTH_256".equals(ElementParameterParser.getValue(node, "__AES_KEY_STRENGTH__"))?3:1;


	String archiveFormat = ElementParameterParser.getValue(node, "__ARCHIVE_FORMAT__");
	String sourceFile = ElementParameterParser.getValue(node, "__SOURCE_FILE__");

	boolean isSyncFlush = "true".equals(ElementParameterParser.getValue(node, "__USE_SYNC_FLUSH__"));

	log4jFileUtil.componentStartInfo(node);
	if ("zip".equals(archiveFormat) || ("tgz".equals(archiveFormat))) {
	
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(directory );
    stringBuffer.append(TEXT_24);
    
	}else{
	
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(sourceFile );
    stringBuffer.append(TEXT_24);
    
	}
	
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(zipFile );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(overwrite);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(mkDir);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(level );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(archiveFormat);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(isAllFile);
    stringBuffer.append(TEXT_39);
     
	if (!isAllFile) {
    
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(masks.size());
    stringBuffer.append(TEXT_42);
    
	    for(int i=0 ; i < masks.size() ; i++) {
	        Map<String, String> line = masks.get(i);
        
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(line.get("FILEMASK"));
    stringBuffer.append(TEXT_46);
    
	    }
	    
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
     
	}
	if("gzip".equals(archiveFormat) || ("tgz".equals(archiveFormat))){
	
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(isSyncFlush);
    stringBuffer.append(TEXT_64);
    
	}else if ("zip".equals(archiveFormat)) {
	
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(subDir);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(zip64Mode);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(isEncrypted);
    stringBuffer.append(TEXT_74);
    
	   String passwordFieldName = "__PASSWORD__";
	   
    stringBuffer.append(TEXT_75);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_19);
    } else {
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_79);
    }
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    
	   if(!"JAVA_ENCRYPT".equals(encryptMethod)){
	   
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    
		  if("ENC_METHOD_AES".equals(encryptMethod)){
		  
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(aesKeyStrength);
    stringBuffer.append(TEXT_88);
    
	   	  }else if("ENC_METHOD_STANDARD".equals(encryptMethod)){
	   	  
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    
	   	  }
	   	}else{
	   	
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    
	   }
   }
   
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(TEXT_99);
    return stringBuffer.toString();
  }
}
