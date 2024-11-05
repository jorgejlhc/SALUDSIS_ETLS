package org.talend.designer.codegen.translators.technical;

import java.util.List;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TRESTRequestInMainJava
{
  protected static String nl;
  public static synchronized TRESTRequestInMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TRESTRequestInMainJava result = new TRESTRequestInMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "\t\tif (requestMessage_";
  protected final String TEXT_2 = ".containsKey(\"ERROR\")) { // wrong request received";
  protected final String TEXT_3 = NL + "\t\t\t\t\t\tString wrongCallUri_";
  protected final String TEXT_4 = " = (String) requestMessage_";
  protected final String TEXT_5 = ".get(\"URI\");" + NL + "\t\t\t\t\t\tString wrongCallMethod_";
  protected final String TEXT_6 = ".get(\"VERB\");" + NL + "\t\t\t\t\t\tString wrongCallError_";
  protected final String TEXT_7 = ".get(\"ERROR\");" + NL + "\t\t\t\t\t\tint wrongCallStatus_";
  protected final String TEXT_8 = " = (Integer) requestMessage_";
  protected final String TEXT_9 = ".get(\"STATUS\");" + NL + "" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_10 = " = new ";
  protected final String TEXT_11 = "Struct();" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_12 = ".uri = wrongCallUri_";
  protected final String TEXT_13 = ";" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_14 = ".method = wrongCallMethod_";
  protected final String TEXT_15 = ".error = wrongCallError_";
  protected final String TEXT_16 = ".status = wrongCallStatus_";
  protected final String TEXT_17 = ";";
  protected final String TEXT_18 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_19 = " = null;";
  protected final String TEXT_20 = NL + "\t\t} else { // non-error (not wrong request)" + NL + "" + NL + "\t\t\tString matchedUriPattern_";
  protected final String TEXT_21 = ".get(\"PATTERN\");" + NL + "\t\t\tString matchedFlow_";
  protected final String TEXT_22 = ".get(\"OPERATION\");" + NL + "" + NL + "\t\t\tjava.util.Map<String, Object> params_";
  protected final String TEXT_23 = " =" + NL + "\t\t\t\t(java.util.Map<String, Object>) requestMessage_";
  protected final String TEXT_24 = ".get(\"PARAMS\");";
  protected final String TEXT_25 = NL + "\t\t\t\t\tif (matchedFlow_";
  protected final String TEXT_26 = ".equals(\"";
  protected final String TEXT_27 = "\")) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_28 = "Struct();";
  protected final String TEXT_29 = NL + "\t\t\t\t\t\t\t\tObject bodyObject_";
  protected final String TEXT_30 = " = requestMessage_";
  protected final String TEXT_31 = ".get(\"BODY\");" + NL + "\t\t\t\t\t\t\t\tif (null != bodyObject_";
  protected final String TEXT_32 = ") {" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_33 = NL + "\t\t\t\t\t\t\t\t\t\troutines.system.Document body_";
  protected final String TEXT_34 = " = new routines.system.Document();" + NL + "\t\t\t\t\t\t\t\t\t\tbody_";
  protected final String TEXT_35 = ".setDocument((org.dom4j.Document) bodyObject_";
  protected final String TEXT_36 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_37 = ".body = body_";
  protected final String TEXT_38 = ";" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_39 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_40 = ".body = (";
  protected final String TEXT_41 = ") bodyObject_";
  protected final String TEXT_42 = NL + "\t\t\t\t\t\t\t\t}";
  protected final String TEXT_43 = NL + "\t\t\t\t\t\t\t\tif (params_";
  protected final String TEXT_44 = ".containsKey(\"";
  protected final String TEXT_45 = "\")) {" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_46 = NL + "\t\t\t\t\t\t\t\t\t\troutines.system.Document ";
  protected final String TEXT_47 = "_";
  protected final String TEXT_48 = " = new routines.system.Document();" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_49 = ".setDocument((org.dom4j.Document) params_";
  protected final String TEXT_50 = ".get(\"";
  protected final String TEXT_51 = "\"));" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_52 = ".";
  protected final String TEXT_53 = " = ";
  protected final String TEXT_54 = " = (";
  protected final String TEXT_55 = ") params_";
  protected final String TEXT_56 = "\");" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_57 = NL + "\t\t\t\t\t} else { // non matched flow" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_58 = " = null;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_59 = NL + "\t\t}";
  protected final String TEXT_60 = NL + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_61 = "_URI\", (String) requestMessage_";
  protected final String TEXT_62 = ".get(\"URI\"));" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_63 = "_URI_BASE\", (String) requestMessage_";
  protected final String TEXT_64 = ".get(\"URI_BASE\"));" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_65 = "_URI_ABSOLUTE\", (String) requestMessage_";
  protected final String TEXT_66 = ".get(\"URI_ABSOLUTE\"));" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_67 = "_URI_REQUEST\", (String) requestMessage_";
  protected final String TEXT_68 = ".get(\"URI_REQUEST\"));" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_69 = "_HTTP_METHOD\", (String) requestMessage_";
  protected final String TEXT_70 = ".get(\"VERB\"));" + NL + "" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_71 = "_ATTACHMENT_HEADERS\", requestMessage_";
  protected final String TEXT_72 = ".get(\"ATTACHMENT_HEADERS\"));" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_73 = "_ATTACHMENT_FILENAMES\", requestMessage_";
  protected final String TEXT_74 = ".get(\"ATTACHMENT_FILENAMES\"));" + NL + "" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_75 = "_PRINCIPAL_NAME\", (String) requestMessage_";
  protected final String TEXT_76 = ".get(\"PRINCIPAL_NAME\"));" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_77 = "_CORRELATION_ID\", (String) requestMessage_";
  protected final String TEXT_78 = ".get(\"CorrelationID\"));";
  protected final String TEXT_79 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
cid = cid.replaceAll("_In", "");

List<IMetadataTable> metadatas = node.getMetadataList();
if (null != metadatas && 0 < metadatas.size()) {
	IMetadataTable metadata = metadatas.get(0);
	if (null != metadata) { 
    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    
			List<? extends IConnection> connsAll = node.getOutgoingSortedConnections();
			if (null != connsAll && !connsAll.isEmpty()) {
				for (IConnection conn : connsAll) {
					if (!conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
						continue;
					}
					String connectionName = conn.getName();
					if ("WRONG_CALLS".equals(conn.getConnectorName())) { // "WRONG_CALL" flow

    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    
					} else { // not "WRONG_CALL" flow

    stringBuffer.append(TEXT_18);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_19);
    
					} // "WRONG_CALLS".equals(conn.getConnectorName()
				} // for (IConnection conn : connsAll)
			} // if (null != connsAll && !connsAll.isEmpty())

    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    
			List<? extends IConnection> conns = node.getOutgoingSortedConnections();
			if (null != conns && !conns.isEmpty()) {
				for (IConnection conn : conns) {
					if (!conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
						continue;
					}

					String connectionName = conn.getName();

					if ("WRONG_CALLS".equals(conn.getConnectorName())) { 
    stringBuffer.append(TEXT_18);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_19);
    
						continue;
					}

    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_28);
    
						for (IMetadataColumn connColumn : conn.getMetadataTable().getListColumns()) {
							String columnName = connColumn.getLabel();
							String parameterName = columnName;
							// try to extract parameter name from comment field
							if (null != connColumn.getComment()){
							    java.util.regex.Matcher m = java.util.regex.Pattern.compile(".*\\((.*?)\\).*").matcher(connColumn.getComment());
							    if (m.find()) {
							        parameterName = m.group(1);
							    } 
							}
							String schemaFieldType = connColumn.getTalendType();
							String restParameterType = (connColumn.getComment() == null || connColumn.getComment().indexOf("(") < 0)? connColumn.getComment():connColumn.getComment().substring(0, connColumn.getComment().indexOf("("));
							if (restParameterType == null || restParameterType.trim().length() == 0) {
								restParameterType = "";
							}

							if ("body".equals(columnName) && "".equals(restParameterType)) {

    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
     if ("id_Document".equals(schemaFieldType)) { 
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
     } else { 
    stringBuffer.append(TEXT_39);
     String javaTypeFull = JavaTypesManager.getTypeToGenerate(schemaFieldType, true); 
    stringBuffer.append(TEXT_39);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_40);
    stringBuffer.append( javaTypeFull);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
     } 
    stringBuffer.append(TEXT_42);
    
							} else {
								restParameterType = ("".equals(restParameterType)) ? "PATH" : restParameterType.trim().toUpperCase();
								String parameterKey = restParameterType + ":" + parameterName + ":" + schemaFieldType;

    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(parameterKey);
    stringBuffer.append(TEXT_45);
     if ("id_Document".equals(schemaFieldType)) { 
    stringBuffer.append(TEXT_46);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(parameterKey);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
     } else { 
    stringBuffer.append(TEXT_39);
     String javaTypeFull = JavaTypesManager.getTypeToGenerate(schemaFieldType, true); 
    stringBuffer.append(TEXT_39);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_54);
    stringBuffer.append( javaTypeFull);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(parameterKey);
    stringBuffer.append(TEXT_56);
     } 
    stringBuffer.append(TEXT_42);
    
							} // if ("body".equals(columnName) && "".equals(restParameterType))
						} // for (IMetadataColumn connColumn : conn.getMetadataTable().getListColumns())

    stringBuffer.append(TEXT_57);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_58);
    
				} // for (IConnection conn : conns)
			} // if (null != conns && !conns.isEmpty())

    stringBuffer.append(TEXT_59);
    
	} // end of if (null != metadata)
} // end of if (null != metadatas && 0 < metadatas.size())

    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(TEXT_79);
    return stringBuffer.toString();
  }
}
