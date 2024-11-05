package org.talend.designer.codegen.translators.processing.fields;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.process.BlockCode;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class TExtractPositionalFieldsMainJava
{
  protected static String nl;
  public static synchronized TExtractPositionalFieldsMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TExtractPositionalFieldsMainJava result = new TExtractPositionalFieldsMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
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
  protected final String TEXT_22 = NL;
  protected final String TEXT_23 = " = null;";
  protected final String TEXT_24 = NL + "\t//String field_";
  protected final String TEXT_25 = " = ";
  protected final String TEXT_26 = ".";
  protected final String TEXT_27 = ";" + NL + "\tString field_";
  protected final String TEXT_28 = ";";
  protected final String TEXT_29 = NL + "\tif(field_";
  protected final String TEXT_30 = "==null){" + NL + "\t\tfield_";
  protected final String TEXT_31 = "=\"\";" + NL + "\t}";
  protected final String TEXT_32 = "!=null){// C_01";
  protected final String TEXT_33 = NL + "try{" + NL + "\t";
  protected final String TEXT_34 = " = new ";
  protected final String TEXT_35 = "Struct();";
  protected final String TEXT_36 = NL + "\t\t\t\t";
  protected final String TEXT_37 = NL + "\tjava.util.Map<String,String> newFields_";
  protected final String TEXT_38 = " = new java.util.HashMap<String,String>();";
  protected final String TEXT_39 = NL + "\tnewFields_";
  protected final String TEXT_40 = ".put(\"";
  protected final String TEXT_41 = "\", TalendString.talendTrim(field_";
  protected final String TEXT_42 = ".substring(0," + NL + "\t\tindexs_";
  protected final String TEXT_43 = "[";
  protected final String TEXT_44 = "]>field_";
  protected final String TEXT_45 = ".length()||indexs_";
  protected final String TEXT_46 = "]<0?field_";
  protected final String TEXT_47 = ".length():indexs_";
  protected final String TEXT_48 = "])";
  protected final String TEXT_49 = "," + NL + "     \t\t\t";
  protected final String TEXT_50 = ", ";
  protected final String TEXT_51 = "));";
  protected final String TEXT_52 = NL + "\tif(";
  protected final String TEXT_53 = "<indexs_";
  protected final String TEXT_54 = ".length && indexs_";
  protected final String TEXT_55 = "]>=0 && indexs_";
  protected final String TEXT_56 = "]<= field_";
  protected final String TEXT_57 = ".length()){" + NL + "    \tnewFields_";
  protected final String TEXT_58 = "\"," + NL + "     \t\tTalendString.talendTrim(field_";
  protected final String TEXT_59 = ".substring(indexs_";
  protected final String TEXT_60 = "]," + NL + "     \t\t\tindexs_";
  protected final String TEXT_61 = "));" + NL + " \t}";
  protected final String TEXT_62 = "\", field_";
  protected final String TEXT_63 = "\",field_";
  protected final String TEXT_64 = "]," + NL + "     \t\tindexs_";
  protected final String TEXT_65 = ");" + NL + " \t}";
  protected final String TEXT_66 = NL + "\tString temp_";
  protected final String TEXT_67 = NL + "\t";
  protected final String TEXT_68 = " = newFields_";
  protected final String TEXT_69 = ".get(\"";
  protected final String TEXT_70 = "\");";
  protected final String TEXT_71 = NL + "\ttemp_";
  protected final String TEXT_72 = "\");" + NL + "\tif(temp_";
  protected final String TEXT_73 = "!=null && temp_";
  protected final String TEXT_74 = ".length() > 0) {";
  protected final String TEXT_75 = NL + "\t\t";
  protected final String TEXT_76 = " = temp_";
  protected final String TEXT_77 = ".getBytes();";
  protected final String TEXT_78 = " = ParserUtils.parseTo_Date(temp_";
  protected final String TEXT_79 = ", false);";
  protected final String TEXT_80 = " = ParserUtils.parseTo_";
  protected final String TEXT_81 = "(ParserUtils.parseTo_Number(temp_";
  protected final String TEXT_82 = "(temp_";
  protected final String TEXT_83 = NL + "\t} else {\t\t\t\t\t\t";
  protected final String TEXT_84 = NL + "\t\tthrow new RuntimeException(\"Value is empty for column : '";
  protected final String TEXT_85 = "' in '";
  protected final String TEXT_86 = "' connection, value is invalid or this column should be nullable or have a default value.\");";
  protected final String TEXT_87 = NL + "\t}";
  protected final String TEXT_88 = NL + "\t int filedsum_";
  protected final String TEXT_89 = ".size();" + NL + "\t if(filedsum_";
  protected final String TEXT_90 = " < ";
  protected final String TEXT_91 = "){" + NL + "\t \tthrow new RuntimeException(\"Column(s) missing\");" + NL + "\t } else if(filedsum_";
  protected final String TEXT_92 = " > ";
  protected final String TEXT_93 = ") {" + NL + "\t \tthrow new RuntimeException(\"Too many columns\");" + NL + "\t }";
  protected final String TEXT_94 = NL + "\tnb_line_";
  protected final String TEXT_95 = "++;";
  protected final String TEXT_96 = NL + "}catch(java.lang.Exception ex_";
  protected final String TEXT_97 = "){" + NL + "globalMap.put(\"";
  protected final String TEXT_98 = "_ERROR_MESSAGE\",ex_";
  protected final String TEXT_99 = ".getMessage());";
  protected final String TEXT_100 = NL + "\tthrow(ex_";
  protected final String TEXT_101 = NL + "    ";
  protected final String TEXT_102 = "    ";
  protected final String TEXT_103 = ".errorMessage = ex_";
  protected final String TEXT_104 = ".getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_105 = NL + "\tlog.error(\"";
  protected final String TEXT_106 = " - \" + ex_";
  protected final String TEXT_107 = NL + "    System.err.println(ex_";
  protected final String TEXT_108 = NL + "}";

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

final boolean isLog4jEnabled = "true".equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

String field = ElementParameterParser.getValue(node, "__FIELD__");
boolean ignoreSourceNull="true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__IGNORE_SOURCE_NULL__"));
String pattern = ElementParameterParser.getValue(node, "__PATTERN__");
boolean advanced = ("true").equals(ElementParameterParser.getValue(node, "__ADVANCED_OPTION__"));
List<Map<String, String>> formats =
	(List<Map<String,String>>)ElementParameterParser.getObjectValue( node, "__FORMATS__");

String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER);

boolean trim = ("true").equals(ElementParameterParser.getValue(node, "__TRIM__"));

String dieOnErrorStr = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
boolean dieOnError = (dieOnErrorStr!=null&&!("").equals(dieOnErrorStr))?("true").equals(dieOnErrorStr):false;

String checkNumStr = ElementParameterParser.getValue(node, "__CHECK_FIELDS_NUM__");
boolean checkNum = (checkNumStr!=null&&!("").equals(checkNumStr))?("true").equals(checkNumStr):false; 

IConnection inConn = null;
List< ? extends IConnection> inConns = node.getIncomingConnections();
if(inConns!=null){
    for (IConnection conn : inConns) {
    	if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
    		inConn = conn;
    		break;
    	}
    }
}

String rejectConnName = "";
List<IMetadataColumn> rejectColumnList = null;
List<? extends IConnection> rejectConns = node.getOutgoingConnections("REJECT");
if(rejectConns != null && rejectConns.size() > 0) {
    IConnection rejectConn = rejectConns.get(0);
    rejectColumnList = rejectConn.getMetadataTable().getListColumns();
    rejectConnName = rejectConn.getName();
}

IConnection outConn = null;
String firstConnName = "";
List< ? extends IConnection> outConns = node.getOutgoingSortedConnections();
if(outConns!=null){
    for (IConnection conn : outConns) {
    	if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
    		outConn = conn;
    		firstConnName = outConn.getName();
    		break;
    	}
    }
}

if(outConns!=null){
    for (IConnection conn : outConns) {
    	if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_22);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_23);
    
    	}
    }
}

//get field column
if(inConn!=null){
	IMetadataTable inputMetadataTable = inConn.getMetadataTable();
	for (IMetadataColumn inputCol : inputMetadataTable.getListColumns()) {
		if(inputCol.getLabel().equals(field)){

    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_26);
    stringBuffer.append(field);
    stringBuffer.append(trim?".trim()":"");
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_26);
    stringBuffer.append(field);
    stringBuffer.append(TEXT_28);
    
			if(!ignoreSourceNull){

    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    
			}else{

    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    
				List<BlockCode> blockCodes = new java.util.ArrayList<BlockCode>(1);
				blockCodes.add(new BlockCode("C_01"));
				((org.talend.core.model.process.AbstractNode) node).setBlocksCodeToClose(blockCodes);
			}
			break;
		}
	}
}

//set original columns
List<IMetadataColumn> newColumnList = new ArrayList<IMetadataColumn>();
if(outConn!=null && inConn!=null){

    stringBuffer.append(TEXT_33);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_35);
    
	IMetadataTable outputMetadataTable = outConn.getMetadataTable();
	IMetadataTable inputMetadataTable = inConn.getMetadataTable();
	for (IMetadataColumn outputCol : outputMetadataTable.getListColumns()) {
		if(outputCol.getLabel().equals(field)){
			continue;
		}
		boolean isOirginalColumn = false;
		for (IMetadataColumn inputCol : inputMetadataTable.getListColumns()) {
			JavaType stringType =  JavaTypesManager.getJavaTypeFromId(inputCol.getTalendType());
			if( outputCol.getLabel().equals( inputCol.getLabel()) ){
				isOirginalColumn = true;
				

    stringBuffer.append(TEXT_36);
    stringBuffer.append(outConn.getName());
    stringBuffer.append(TEXT_26);
    stringBuffer.append(outputCol.getLabel());
    stringBuffer.append(TEXT_25);
    stringBuffer.append(inConn.getName());
    stringBuffer.append(TEXT_26);
    stringBuffer.append(inputCol.getLabel());
    stringBuffer.append(TEXT_28);
    
				break;
				}
		    }
		
		if(!isOirginalColumn){
			if(!("").equals(rejectConnName)&&rejectConnName.equals(firstConnName)
				&& (outputCol.getLabel().equals("errorMessage") || outputCol.getLabel().equals("errorCode"))){
			}else{
				newColumnList.add(outputCol);
			}
		}
	}


    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    
	if(advanced){
		for(int i=0; i<formats.size(); i++){
			Map<String,String> tmp = formats.get(i);
			if(i==0){

    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(tmp.get("COLUMN"));
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(trim?".trim()":"");
    stringBuffer.append(TEXT_49);
    stringBuffer.append(tmp.get("PADDING_CHAR"));
    stringBuffer.append(TEXT_50);
    stringBuffer.append(tmp.get("ALIGN"));
    stringBuffer.append(TEXT_51);
    
			}else{

    stringBuffer.append(TEXT_52);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(i-1);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(i-1);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(tmp.get("COLUMN"));
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(i-1);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(trim?".trim()":"");
    stringBuffer.append(TEXT_49);
    stringBuffer.append(tmp.get("PADDING_CHAR"));
    stringBuffer.append(TEXT_50);
    stringBuffer.append(tmp.get("ALIGN"));
    stringBuffer.append(TEXT_61);
    
			}
		}
	}else{
		for(int i=0;i<newColumnList.size();i++){
			IMetadataColumn tmp = newColumnList.get(i);
			if(i==0){

    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(tmp.getLabel());
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(trim?".trim()":"");
    stringBuffer.append(TEXT_19);
    
			}else{

    stringBuffer.append(TEXT_52);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(i-1);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(i-1);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(tmp.getLabel());
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(i-1);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(trim?".trim()":"");
    stringBuffer.append(TEXT_65);
    
			}
		}
	}

    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    
	for(IMetadataColumn column:newColumnList){
		String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
		JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
		String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
    
		if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT){

    stringBuffer.append(TEXT_67);
    stringBuffer.append(outConn.getName());
    stringBuffer.append(TEXT_26);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_70);
    
		}else{ 

    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    
			if(javaType == JavaTypesManager.BYTE_ARRAY){ 

    stringBuffer.append(TEXT_75);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    
			}else if(javaType == JavaTypesManager.DATE) {
				if(checkNum){

    stringBuffer.append(TEXT_75);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_79);
    
				}else{

    stringBuffer.append(TEXT_75);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_19);
    
				}
			}else if(advancedSeparator && JavaTypesManager.isNumberType(javaType)) { 

    stringBuffer.append(TEXT_75);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_80);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_50);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_51);
    
			} else {

    stringBuffer.append(TEXT_75);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_80);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    
			}

    stringBuffer.append(TEXT_83);
    
			String defaultValue = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate, column.getDefault());
			if(defaultValue == null) {

    stringBuffer.append(TEXT_84);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_86);
    
			} else {

    stringBuffer.append(TEXT_75);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(defaultValue );
    stringBuffer.append(TEXT_28);
    
			}

    stringBuffer.append(TEXT_87);
    
		}
	}
	
	if(checkNum) {

    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(newColumnList.size() );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(newColumnList.size() );
    stringBuffer.append(TEXT_93);
    
	}
	
	if(!("").equals(rejectConnName) && rejectConnName.equals(firstConnName)){

    stringBuffer.append(TEXT_67);
    stringBuffer.append(outConn.getName() );
    stringBuffer.append(TEXT_23);
    
	}

    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    
	log4jFileUtil.logCurrentRowNumberInfo();

    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    
	if(dieOnError){

    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    
	}else{
		if(!("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {

    stringBuffer.append(TEXT_67);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_35);
    
            for(IMetadataColumn column : outConn.getMetadataTable().getListColumns()) {

    stringBuffer.append(TEXT_101);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_25);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_28);
    
			}

    stringBuffer.append(TEXT_102);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_23);
    
		} else if(("").equals(rejectConnName)){
			if(isLog4jEnabled) {

    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_99);
    
			}

    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_23);
    
		} else if(rejectConnName.equals(firstConnName)){

    stringBuffer.append(TEXT_67);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_28);
    
		}
	}

    stringBuffer.append(TEXT_108);
    
}

    stringBuffer.append(TEXT_22);
    return stringBuffer.toString();
  }
}
