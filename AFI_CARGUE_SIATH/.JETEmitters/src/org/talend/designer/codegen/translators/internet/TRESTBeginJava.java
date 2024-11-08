package org.talend.designer.codegen.translators.internet;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import java.util.Map;
import java.util.List;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;

public class TRESTBeginJava
{
  protected static String nl;
  public static synchronized TRESTBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TRESTBeginJava result = new TRESTBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + "                if(log.is";
  protected final String TEXT_4 = "Enabled())";
  protected final String TEXT_5 = NL + "            log.";
  protected final String TEXT_6 = "(\"";
  protected final String TEXT_7 = " - \" ";
  protected final String TEXT_8 = " + (";
  protected final String TEXT_9 = ") ";
  protected final String TEXT_10 = ");";
  protected final String TEXT_11 = NL + "            if (log.isDebugEnabled()) {" + NL + "                class BytesLimit65535_";
  protected final String TEXT_12 = "{" + NL + "                    public void limitLog4jByte() throws Exception{" + NL + "                    StringBuilder ";
  protected final String TEXT_13 = " = new StringBuilder();";
  protected final String TEXT_14 = NL + "                    ";
  protected final String TEXT_15 = ".append(\"Parameters:\");";
  protected final String TEXT_16 = NL + "                            ";
  protected final String TEXT_17 = ".append(\"";
  protected final String TEXT_18 = "\" + \" = \" + String.valueOf(";
  protected final String TEXT_19 = ").substring(0, 4) + \"...\");     ";
  protected final String TEXT_20 = "\" + \" = \" + ";
  protected final String TEXT_21 = NL + "                        ";
  protected final String TEXT_22 = ".append(\" | \");";
  protected final String TEXT_23 = NL + "                    } " + NL + "                } " + NL + "            new BytesLimit65535_";
  protected final String TEXT_24 = "().limitLog4jByte();" + NL + "            }";
  protected final String TEXT_25 = NL + "            StringBuilder ";
  protected final String TEXT_26 = " = new StringBuilder();    ";
  protected final String TEXT_27 = ".append(";
  protected final String TEXT_28 = ".";
  protected final String TEXT_29 = NL + "                    if(";
  protected final String TEXT_30 = " == null){";
  protected final String TEXT_31 = ".append(\"<null>\");" + NL + "                    }else{";
  protected final String TEXT_32 = ");" + NL + "                    }   ";
  protected final String TEXT_33 = NL + "                ";
  protected final String TEXT_34 = ".append(\"|\");";
  protected final String TEXT_35 = NL + "\t";
  protected final String TEXT_36 = NL + "\tString endpoint_";
  protected final String TEXT_37 = " = ";
  protected final String TEXT_38 = ";" + NL + "\t" + NL + "\tString trustStoreFile_";
  protected final String TEXT_39 = " = System.getProperty(\"javax.net.ssl.trustStore\");" + NL + "\tString trustStoreType_";
  protected final String TEXT_40 = " = System.getProperty(\"javax.net.ssl.trustStoreType\");" + NL + "\tString trustStorePWD_";
  protected final String TEXT_41 = " = System.getProperty(\"javax.net.ssl.trustStorePassword\");" + NL + "\t" + NL + "\tString keyStoreFile_";
  protected final String TEXT_42 = " = System.getProperty(\"javax.net.ssl.keyStore\");" + NL + "\tString keyStoreType_";
  protected final String TEXT_43 = " = System.getProperty(\"javax.net.ssl.keyStoreType\");" + NL + "\tString keyStorePWD_";
  protected final String TEXT_44 = " = System.getProperty(\"javax.net.ssl.keyStorePassword\");" + NL + "\t" + NL + "\tcom.sun.jersey.api.client.config.ClientConfig config_";
  protected final String TEXT_45 = " = new com.sun.jersey.api.client.config.DefaultClientConfig();" + NL + "\t" + NL + "\t// APPINT-33909: add entitiy providers (for OSGi deployment)" + NL + "\tconfig_";
  protected final String TEXT_46 = ".getClasses().add(com.sun.jersey.core.impl.provider.entity.StringProvider.class);" + NL + "\tconfig_";
  protected final String TEXT_47 = ".getClasses().add(com.sun.jersey.core.impl.provider.entity.ByteArrayProvider.class);" + NL + "\tconfig_";
  protected final String TEXT_48 = ".getClasses().add(com.sun.jersey.core.impl.provider.entity.FileProvider.class);" + NL + "\tconfig_";
  protected final String TEXT_49 = ".getClasses().add(com.sun.jersey.core.impl.provider.entity.InputStreamProvider.class);" + NL + "\tconfig_";
  protected final String TEXT_50 = ".getClasses().add(com.sun.jersey.core.impl.provider.entity.DataSourceProvider.class);" + NL + "\tconfig_";
  protected final String TEXT_51 = ".getClasses().add(com.sun.jersey.core.impl.provider.entity.MimeMultipartProvider.class);" + NL + "\tconfig_";
  protected final String TEXT_52 = ".getClasses().add(com.sun.jersey.core.impl.provider.entity.FormProvider.class);" + NL + "\tconfig_";
  protected final String TEXT_53 = ".getClasses().add(com.sun.jersey.core.impl.provider.entity.ReaderProvider.class);" + NL + "\tconfig_";
  protected final String TEXT_54 = ".getClasses().add(com.sun.jersey.core.impl.provider.entity.DocumentProvider.class);" + NL + "\tconfig_";
  protected final String TEXT_55 = ".getClasses().add(com.sun.jersey.core.impl.provider.entity.StreamingOutputProvider.class);" + NL + "\t" + NL + "\tjavax.net.ssl.SSLContext ctx_";
  protected final String TEXT_56 = " = javax.net.ssl.SSLContext.getInstance(\"SSL\");" + NL + "\t" + NL + "\tjavax.net.ssl.TrustManager[] tms_";
  protected final String TEXT_57 = " = null;" + NL + "\tif(trustStoreFile_";
  protected final String TEXT_58 = "!=null && trustStoreType_";
  protected final String TEXT_59 = "!=null){" + NL + "\t\tchar[] password_";
  protected final String TEXT_60 = " = null;" + NL + "\t\tif(trustStorePWD_";
  protected final String TEXT_61 = "!=null)" + NL + "\t\t\tpassword_";
  protected final String TEXT_62 = " = trustStorePWD_";
  protected final String TEXT_63 = ".toCharArray();" + NL + "\t\tjava.security.KeyStore trustStore_";
  protected final String TEXT_64 = " = java.security.KeyStore.getInstance(trustStoreType_";
  protected final String TEXT_65 = ");" + NL + "\t\ttrustStore_";
  protected final String TEXT_66 = ".load(new java.io.FileInputStream(trustStoreFile_";
  protected final String TEXT_67 = "), password_";
  protected final String TEXT_68 = ");" + NL + "\t\t" + NL + "\t\tjavax.net.ssl.TrustManagerFactory tmf_";
  protected final String TEXT_69 = " = javax.net.ssl.TrustManagerFactory.getInstance(javax.net.ssl.KeyManagerFactory.getDefaultAlgorithm());" + NL + "        tmf_";
  protected final String TEXT_70 = ".init(trustStore_";
  protected final String TEXT_71 = ");" + NL + "        tms_";
  protected final String TEXT_72 = " = tmf_";
  protected final String TEXT_73 = ".getTrustManagers();" + NL + "\t}" + NL + "\t" + NL + "\tjavax.net.ssl.KeyManager[] kms_";
  protected final String TEXT_74 = " = null;" + NL + "\tif(keyStoreFile_";
  protected final String TEXT_75 = "!=null && keyStoreType_";
  protected final String TEXT_76 = " = null;" + NL + "\t\tif(keyStorePWD_";
  protected final String TEXT_77 = " = keyStorePWD_";
  protected final String TEXT_78 = ".toCharArray();" + NL + "\t\tjava.security.KeyStore keyStore_";
  protected final String TEXT_79 = " = java.security.KeyStore.getInstance(keyStoreType_";
  protected final String TEXT_80 = ");" + NL + "\t\tkeyStore_";
  protected final String TEXT_81 = ".load(new java.io.FileInputStream(keyStoreFile_";
  protected final String TEXT_82 = ");" + NL + "\t\t" + NL + "\t\tjavax.net.ssl.KeyManagerFactory kmf_";
  protected final String TEXT_83 = " = javax.net.ssl.KeyManagerFactory.getInstance(javax.net.ssl.KeyManagerFactory.getDefaultAlgorithm());" + NL + "        kmf_";
  protected final String TEXT_84 = ".init(keyStore_";
  protected final String TEXT_85 = ",password_";
  protected final String TEXT_86 = ");" + NL + "        kms_";
  protected final String TEXT_87 = " = kmf_";
  protected final String TEXT_88 = ".getKeyManagers();" + NL + "\t}" + NL + "\t" + NL + "    ctx_";
  protected final String TEXT_89 = ".init(kms_";
  protected final String TEXT_90 = ", tms_";
  protected final String TEXT_91 = " , null);" + NL + "    config_";
  protected final String TEXT_92 = ".getProperties().put(com.sun.jersey.client.urlconnection.HTTPSProperties.PROPERTY_HTTPS_PROPERTIES," + NL + "                new com.sun.jersey.client.urlconnection.HTTPSProperties(new javax.net.ssl.HostnameVerifier() {" + NL + "" + NL + "                    public boolean verify(String hostName, javax.net.ssl.SSLSession session) {" + NL + "                        return true;" + NL + "                    }" + NL + "                }, ctx_";
  protected final String TEXT_93 = "));" + NL + "" + NL + "\tcom.sun.jersey.api.client.Client restClient_";
  protected final String TEXT_94 = " = com.sun.jersey.api.client.Client.create(config_";
  protected final String TEXT_95 = ");" + NL + "\t" + NL + "\tjava.util.Map<String, Object> headers_";
  protected final String TEXT_96 = " = new java.util.HashMap<String, Object>();" + NL + "\t";
  protected final String TEXT_97 = NL + "    \theaders_";
  protected final String TEXT_98 = ".put(";
  protected final String TEXT_99 = ",";
  protected final String TEXT_100 = ");" + NL + "\t";
  protected final String TEXT_101 = NL + "\t" + NL + "\tObject transfer_encoding_";
  protected final String TEXT_102 = " = headers_";
  protected final String TEXT_103 = ".get(\"Transfer-Encoding\");" + NL + "\tif(transfer_encoding_";
  protected final String TEXT_104 = "!=null && \"chunked\".equals(transfer_encoding_";
  protected final String TEXT_105 = ")) {" + NL + "\t\trestClient_";
  protected final String TEXT_106 = ".setChunkedEncodingSize(4096);" + NL + "\t}" + NL + "\t" + NL + "\tcom.sun.jersey.api.client.WebResource restResource_";
  protected final String TEXT_107 = ";" + NL + "\tif(endpoint_";
  protected final String TEXT_108 = "!=null && !(\"\").equals(endpoint_";
  protected final String TEXT_109 = ")){" + NL + "\t\trestResource_";
  protected final String TEXT_110 = " = restClient_";
  protected final String TEXT_111 = ".resource(endpoint_";
  protected final String TEXT_112 = ");" + NL + "\t}else{" + NL + "\t\tthrow new IllegalArgumentException(\"url can't be empty!\");" + NL + "\t}" + NL + "\t" + NL + "\tcom.sun.jersey.api.client.ClientResponse errorResponse_";
  protected final String TEXT_113 = " = null;" + NL + "\tString restResponse_";
  protected final String TEXT_114 = " = \"\";" + NL + "\ttry{" + NL + "\t\t";
  protected final String TEXT_115 = NL + "\t\tcom.sun.jersey.api.client.WebResource.Builder builder_";
  protected final String TEXT_116 = " = null;" + NL + "\t\tfor(java.util.Map.Entry<String, Object> header_";
  protected final String TEXT_117 = " : headers_";
  protected final String TEXT_118 = ".entrySet()) {" + NL + "\t\t\tif(builder_";
  protected final String TEXT_119 = " == null) {" + NL + "\t\t\t\tbuilder_";
  protected final String TEXT_120 = " = restResource_";
  protected final String TEXT_121 = ".header(header_";
  protected final String TEXT_122 = ".getKey(), header_";
  protected final String TEXT_123 = ".getValue());" + NL + "\t\t\t} else {" + NL + "\t\t\t\tbuilder_";
  protected final String TEXT_124 = ".getValue());" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_125 = NL + "\t\t\tif(builder_";
  protected final String TEXT_126 = "!=null) {" + NL + "\t\t\t\trestResponse_";
  protected final String TEXT_127 = " = builder_";
  protected final String TEXT_128 = ".get(String.class);" + NL + "\t\t\t} else {" + NL + "\t\t\t\trestResponse_";
  protected final String TEXT_129 = ".get(String.class);" + NL + "\t\t\t} " + NL + "\t\t\t" + NL + "\t\t";
  protected final String TEXT_130 = ".post(String.class,";
  protected final String TEXT_131 = ");" + NL + "\t\t\t} else {" + NL + "\t\t\t\trestResponse_";
  protected final String TEXT_132 = ");" + NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_133 = ".put(String.class,";
  protected final String TEXT_134 = ".delete(String.class);" + NL + "\t\t\t} else {" + NL + "\t\t\t\trestResponse_";
  protected final String TEXT_135 = ".delete(String.class);" + NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_136 = NL + "\t}catch (com.sun.jersey.api.client.UniformInterfaceException ue) {" + NL + "globalMap.put(\"";
  protected final String TEXT_137 = "_ERROR_MESSAGE\",ue.getMessage());" + NL + "        errorResponse_";
  protected final String TEXT_138 = " = ue.getResponse();" + NL + "    }" + NL + "\t";
  protected final String TEXT_139 = NL + "\t// for output" + NL + "\t";
  protected final String TEXT_140 = "\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_141 = " = new ";
  protected final String TEXT_142 = "Struct();" + NL + "\t\t\t\tif(errorResponse_";
  protected final String TEXT_143 = "!=null){" + NL + "\t\t\t\t\t";
  protected final String TEXT_144 = ".ERROR_CODE = errorResponse_";
  protected final String TEXT_145 = ".getStatus();" + NL + "\t\t\t\t\tif(";
  protected final String TEXT_146 = ".ERROR_CODE!=204){" + NL + "\t\t\t\t\t    ";
  protected final String TEXT_147 = ".Body = errorResponse_";
  protected final String TEXT_148 = ".getEntity(String.class);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}else{" + NL + "\t\t\t\t\t";
  protected final String TEXT_149 = ".Body = restResponse_";
  protected final String TEXT_150 = ";" + NL + "\t\t\t\t}" + NL + "\t\t\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    
class BasicLogUtil{
    protected String cid  = "";
    protected org.talend.core.model.process.INode node = null;
    protected boolean log4jEnabled = false;
    private String logID = "";
    
    private BasicLogUtil(){}
    
    public BasicLogUtil(org.talend.core.model.process.INode node){
        this.node = node;
        String cidx = this.node.getUniqueName();
        this.cid = cidx;
        this.log4jEnabled = ("true").equals(org.talend.core.model.process.ElementParameterParser.getValue(this.node.getProcess(), "__LOG4J_ACTIVATE__"));
        this.log4jEnabled = this.log4jEnabled &&
                            this.node.getComponent().isLog4JEnabled() && !"JOBLET".equals(node.getComponent().getComponentType().toString());
        this.logID = this.cid;
    }
    
    public String var(String varName){
        return varName + "_" + this.cid;
    }
	
	public String varForTableName(String varName, String dbmsId) {
		if ("id_MSSQL".equals(dbmsId) || cid.startsWith("tMSSQL")) {
			return "\"[\" +" + var(varName) + " + \"]\"";
		} else if ("ibmdb2_id".equals(dbmsId) || "redshift_id".equals(dbmsId) || "postgres_id".equals(dbmsId) || cid.startsWith("tDB2") || 
			cid.startsWith("tRedshift") || cid.startsWith("tGreenplum")){
			return new StringBuilder().append("\"\\\"\" +").append(var(varName)).append("+ \"\\\"\"").toString();
		} else {
			return var(varName);
		}
	}
    public String str(String content){
        return "\"" + content + "\"";
    }
    
    public void info(String... message){
        log4j("info", message);
    }
    
    public void debug(String... message){
        log4j("debug", message);
    }
    
    public void warn(String... message){
        log4j("warn", message);
    }
    
    public void error(String... message){
        log4j("error", message);
    }
    
    public void fatal(String... message){
        log4j("fatal", message);
    }
    
    public void trace(String... message){
        log4j("trace", message);
    }
    java.util.List<String> checkableList = java.util.Arrays.asList(new String[]{"info", "debug", "trace"});     
    public void log4j(String level, String... messages){
        if(this.log4jEnabled){
            if(checkableList.contains(level)){
            
    stringBuffer.append(TEXT_3);
    stringBuffer.append(level.substring(0, 1).toUpperCase() + level.substring(1));
    stringBuffer.append(TEXT_4);
    
            }
            
    stringBuffer.append(TEXT_5);
    stringBuffer.append(level);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(logID);
    stringBuffer.append(TEXT_7);
    for(String message : messages){
    stringBuffer.append(TEXT_8);
    stringBuffer.append(message);
    stringBuffer.append(TEXT_9);
    }
    stringBuffer.append(TEXT_10);
    
        }
    }
    
    public boolean isActive(){
        return this.log4jEnabled;
    }
}

class LogUtil extends BasicLogUtil{
    
    private LogUtil(){
    }
    
    public LogUtil(org.talend.core.model.process.INode node){
        super(node);
    }
    
    public void startWork(){
        debug(str("Start to work."));
    }
    
    public void endWork(){
        debug(str("Done."));
    }
    
    public void logIgnoredException(String exception){
        warn(exception);
    }
    
    public void logPrintedException(String exception){
        error(exception);
    }
    
    public void logException(String exception){
        fatal(exception);
    }
    
    public void logCompSetting(){
    
    
        if(log4jEnabled){
        
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_13);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_15);
    
                    java.util.Set<org.talend.core.model.process.EParameterFieldType> ignoredParamsTypes = new java.util.HashSet<org.talend.core.model.process.EParameterFieldType>(); 
                    ignoredParamsTypes.addAll(
                        java.util.Arrays.asList(
                            org.talend.core.model.process.EParameterFieldType.SCHEMA_TYPE,
                            org.talend.core.model.process.EParameterFieldType.LABEL,
                            org.talend.core.model.process.EParameterFieldType.EXTERNAL,
                            org.talend.core.model.process.EParameterFieldType.MAPPING_TYPE,
                            org.talend.core.model.process.EParameterFieldType.IMAGE,
                            org.talend.core.model.process.EParameterFieldType.TNS_EDITOR,
                            org.talend.core.model.process.EParameterFieldType.WSDL2JAVA,
                            org.talend.core.model.process.EParameterFieldType.GENERATEGRAMMARCONTROLLER,
                            org.talend.core.model.process.EParameterFieldType.GENERATE_SURVIVORSHIP_RULES_CONTROLLER,
                            org.talend.core.model.process.EParameterFieldType.REFRESH_REPORTS,
                            org.talend.core.model.process.EParameterFieldType.BROWSE_REPORTS,
                            org.talend.core.model.process.EParameterFieldType.PALO_DIM_SELECTION,
                            org.talend.core.model.process.EParameterFieldType.GUESS_SCHEMA,
                            org.talend.core.model.process.EParameterFieldType.MATCH_RULE_IMEX_CONTROLLER,
                            org.talend.core.model.process.EParameterFieldType.MEMO_PERL,
                            org.talend.core.model.process.EParameterFieldType.DBTYPE_LIST,
                            org.talend.core.model.process.EParameterFieldType.VERSION,
                            org.talend.core.model.process.EParameterFieldType.TECHNICAL,
                            org.talend.core.model.process.EParameterFieldType.ICON_SELECTION,
                            org.talend.core.model.process.EParameterFieldType.JAVA_COMMAND,
                            org.talend.core.model.process.EParameterFieldType.TREE_TABLE,
                            org.talend.core.model.process.EParameterFieldType.VALIDATION_RULE_TYPE,
                            org.talend.core.model.process.EParameterFieldType.DCSCHEMA,
                            org.talend.core.model.process.EParameterFieldType.SURVIVOR_RELATION,
                            org.talend.core.model.process.EParameterFieldType.REST_RESPONSE_SCHEMA_TYPE
                            )
                    );
                    for(org.talend.core.model.process.IElementParameter ep : org.talend.core.model.utils.NodeUtil.getDisplayedParameters(node)){
                        if(!ep.isLog4JEnabled() || ignoredParamsTypes.contains(ep.getFieldType())){
                            continue;
                        }
                        String name = ep.getName();
                        if(org.talend.core.model.process.EParameterFieldType.PASSWORD.equals(ep.getFieldType())){
                            String epName = "__" + name + "__";
                            String password = "";
                            if(org.talend.core.model.process.ElementParameterParser.canEncrypt(node, epName)){
                                password = org.talend.core.model.process.ElementParameterParser.getEncryptedValue(node, epName);
                            }else{
                                String passwordValue = org.talend.core.model.process.ElementParameterParser.getValue(node, epName);
                                if (passwordValue == null || "".equals(passwordValue.trim())) {// for the value which empty
                                    passwordValue = "\"\"";
                                } 
                                password = "routines.system.PasswordEncryptUtil.encryptPassword(" + passwordValue + ")";
                            } 
                            
    stringBuffer.append(TEXT_16);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(password);
    stringBuffer.append(TEXT_19);
    
                        }else{
                            String value = org.talend.core.model.utils.NodeUtil.getNormalizeParameterValue(node, ep);
                            if(value.length()>10000){
                            value = org.talend.core.model.utils.NodeUtil.replaceCRLFInMEMO_SQL(value);
                            }
                            
    stringBuffer.append(TEXT_16);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_10);
    
                        }   
                        
    stringBuffer.append(TEXT_21);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_22);
    
                    }
                    debug(var("log4jParamters")); 
                    
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    
        } 
        
    
    } 
    
    //no use for now, because we log the data by rowStruct
    public void traceData(String rowStruct, java.util.List<org.talend.core.model.metadata.IMetadataColumn> columnList, String nbline){
        if(log4jEnabled){
        
    stringBuffer.append(TEXT_25);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_26);
    
            for(org.talend.core.model.metadata.IMetadataColumn column : columnList){
                org.talend.core.model.metadata.types.JavaType javaType = org.talend.core.model.metadata.types.JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                String columnName = column.getLabel();
                boolean isPrimit = org.talend.core.model.metadata.types.JavaTypesManager.isJavaPrimitiveType(column.getTalendType(), column.isNullable());
                if(isPrimit){
                
    stringBuffer.append(TEXT_14);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_27);
    stringBuffer.append(rowStruct);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_10);
    
                }else{
                
    stringBuffer.append(TEXT_29);
    stringBuffer.append(rowStruct);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_31);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_27);
    stringBuffer.append(rowStruct);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_32);
    
                }
                
    stringBuffer.append(TEXT_33);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_34);
    
            }
        }
        trace(str("Content of the record "), nbline, str(": "), var("log4jSb"));
        
    
    }
}

class LogHelper{
    
    java.util.Map<String, String> pastDict = null;
    
    public LogHelper(){
        pastDict = new java.util.HashMap<String, String>();
        pastDict.put("insert", "inserted");
        pastDict.put("update", "updated");
        pastDict.put("delete", "deleted");
        pastDict.put("upsert", "upserted");
    }   
    
    public String upperFirstChar(String data){ 
        return data.substring(0, 1).toUpperCase() + data.substring(1);
    }
    
    public String toPastTense(String data){
        return pastDict.get(data);
    }
}
LogHelper logHelper = new LogHelper();

LogUtil log = null;

    stringBuffer.append(TEXT_35);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	log = new LogUtil(node);
	
	String url = ElementParameterParser.getValue(node,"__URL__");
	String method = ElementParameterParser.getValue(node,"__METHOD__");
	List<Map<String, String>> headers = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__HEADERS__");
	        
	String body = ElementParameterParser.getValue(node,"__BODY__");
	body = body.replaceAll("[\r\n]", " ");
	
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(url);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
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
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    
    for (int i = 0; i < headers.size(); i++) {
        Map<String, String> line = headers.get(i);
		
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append( line.get("NAME") );
    stringBuffer.append(TEXT_99);
    stringBuffer.append( line.get("VALUE") );
    stringBuffer.append(TEXT_100);
    
    }
    
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    log.info(log.str("Prepare to send request to rest server."));
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    
		if("GET".equals(method)){
		
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    
		}else if("POST".equals(method)){
		
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(body);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(body);
    stringBuffer.append(TEXT_132);
    
		}else if("PUT".equals(method)){
		
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(body);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(body);
    stringBuffer.append(TEXT_132);
    
		}else if("DELETE".equals(method)){
		
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    
		}
		
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    log.info(log.str("Has sent request to rest server."));
    stringBuffer.append(TEXT_139);
    
	List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
	if (conns!=null) {//1
		if (conns.size()>0) {//2
			IConnection conn = conns.get(0); //the first connection
			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {//3
				IMetadataTable metadata = conn.getMetadataTable();
				List<IMetadataColumn> columnList = metadata.getListColumns();
				
    stringBuffer.append(TEXT_140);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_141);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    		
			}//3
		}//2
	}//1
	
    stringBuffer.append(TEXT_2);
    return stringBuffer.toString();
  }
}
