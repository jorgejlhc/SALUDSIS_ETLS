package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.utils.NodeUtil;
import java.util.List;
import java.util.Map;
import org.talend.core.model.process.AbstractNode;

public class TFileOutputPositionalMainJava
{
  protected static String nl;
  public static synchronized TFileOutputPositionalMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileOutputPositionalMainJava result = new TFileOutputPositionalMainJava();
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
  protected final String TEXT_22 = NL + NL + "\t\t\t\tString tempStringM";
  protected final String TEXT_23 = "= null;" + NL + "\t\t\t\t" + NL + "\t\t\t\tint tempLengthM";
  protected final String TEXT_24 = "= 0;" + NL + "\t\t\t\t";
  protected final String TEXT_25 = NL + "\t\t\t\tStringBuilder sb_";
  protected final String TEXT_26 = " = new StringBuilder();";
  protected final String TEXT_27 = NL + "    \t\t\t\tpositionUtil_";
  protected final String TEXT_28 = ".setValue_";
  protected final String TEXT_29 = "(";
  protected final String TEXT_30 = ",sb_";
  protected final String TEXT_31 = ",tempStringM";
  protected final String TEXT_32 = ",tempLengthM";
  protected final String TEXT_33 = ",byteArray_";
  protected final String TEXT_34 = ",arrays_";
  protected final String TEXT_35 = NL + "\t\t\tsb_";
  protected final String TEXT_36 = ".append(";
  protected final String TEXT_37 = ");" + NL + "\t\t\t";
  protected final String TEXT_38 = NL + "\t\t\tsynchronized (multiThreadLockWrite) {" + NL + "\t\t\t";
  protected final String TEXT_39 = NL + "\t\t\tsynchronized (fileNewName_";
  protected final String TEXT_40 = ".intern()) {" + NL + "\t\t\t";
  protected final String TEXT_41 = NL + "\t\t\tObject[] pLockWrite = (Object[])globalMap.get(\"PARALLEL_LOCK_WRITE\");" + NL + "\t\t\tsynchronized (pLockWrite) {" + NL + "\t\t\t";
  protected final String TEXT_42 = NL + "\t\t\tout";
  protected final String TEXT_43 = ".write(sb_";
  protected final String TEXT_44 = ".toString());" + NL + "    \t\t";
  protected final String TEXT_45 = NL + "        \t\tif(nb_line_";
  protected final String TEXT_46 = "%";
  protected final String TEXT_47 = " == 0) {" + NL + "        \t\tout";
  protected final String TEXT_48 = ".flush();" + NL + "        \t\t}" + NL + "    \t\t";
  protected final String TEXT_49 = NL + "    \t\t";
  protected final String TEXT_50 = NL + "    \t\t\t} " + NL + "\t\t\t";
  protected final String TEXT_51 = NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_52 = NL + "    \t\t\t}" + NL + "    \t\t";
  protected final String TEXT_53 = " \t\t\t\t\t\t" + NL + "\t\t\tnb_line_";
  protected final String TEXT_54 = "++;" + NL + "\t\t\tresourceMap.put(\"nb_line_";
  protected final String TEXT_55 = "\", nb_line_";
  protected final String TEXT_56 = NL;

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

List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {
        
        String cid = node.getUniqueName();
        
        String separator = ElementParameterParser.getValue(
            node,
            "__ROWSEPARATOR__"
        );

        List<Map<String, String>> formats =
            (List<Map<String,String>>)ElementParameterParser.getObjectValue(
                node,
                "__FORMATS__"
            );            
            
        boolean useByte = ("true").equals(ElementParameterParser.getValue(node, "__USE_BYTE__"));
        
        boolean flushOnRow = ("true").equals(ElementParameterParser.getValue(node, "__FLUSHONROW__")); 
        String flushMod = ElementParameterParser.getValue(node, "__FLUSHONROW_NUM__");
     
		String parallelize = ElementParameterParser.getValue(node,"__PARALLELIZE__");
		boolean isParallelize = (parallelize!=null&&!("").equals(parallelize))?("true").equals(parallelize):false;

    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    
	List< ? extends IConnection> conns = node.getIncomingConnections();
	for (IConnection conn : conns) {
		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    
			List<IMetadataColumn> columns = metadata.getListColumns();
			int sizeColumns = columns.size();
			for (int i = 0; i < sizeColumns; i++) {
				if(i%100==0){

    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(i/100);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
     if(useByte){ 
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
     }
    stringBuffer.append(TEXT_19);
    
				}
			}

    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(separator);
    stringBuffer.append(TEXT_37);
     
				if(codeGenArgument.getIsRunInMultiThread()){
			
    stringBuffer.append(TEXT_38);
    
				}
				if (((AbstractNode)node).getParallelIterator() != null) {
			
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
     
				}
				if (isParallelize) {
			
    stringBuffer.append(TEXT_41);
     
				}
			
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
     if(flushOnRow) { 
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(flushMod );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    
    			}
    		
    stringBuffer.append(TEXT_49);
    
    			if ( isParallelize) {
			
    stringBuffer.append(TEXT_50);
    
    		    }
				if (((AbstractNode)node).getParallelIterator() != null) {
			
    stringBuffer.append(TEXT_51);
     
				}
				if(codeGenArgument.getIsRunInMultiThread()){
    		
    stringBuffer.append(TEXT_52);
    
    			}
			
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    
			log4jFileUtil.debugWriteData(node);
		}
	}
    }
}

    stringBuffer.append(TEXT_56);
    return stringBuffer.toString();
  }
}
