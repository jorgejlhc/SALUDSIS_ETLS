package org.talend.designer.codegen.translators.technical;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class THashInputBeginJava
{
  protected static String nl;
  public static synchronized THashInputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THashInputBeginJava result = new THashInputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "globalMap.put(\"";
  protected final String TEXT_3 = "_ERROR_MESSAGE\",e.getMessage());" + NL + "\t\t\t";
  protected final String TEXT_4 = NL + "\t\t";
  protected final String TEXT_5 = NL + NL + "int nb_line_";
  protected final String TEXT_6 = " = 0;" + NL;
  protected final String TEXT_7 = "\t" + NL + "org.talend.designer.components.hashfile.common.MapHashFile mf_";
  protected final String TEXT_8 = "=org.talend.designer.components.hashfile.common.MapHashFile.getMapHashFile();" + NL + "org.talend.designer.components.hashfile.memory.AdvancedMemoryHashFile<";
  protected final String TEXT_9 = "Struct> tHashFile_";
  protected final String TEXT_10 = " = mf_";
  protected final String TEXT_11 = ".getAdvancedMemoryHashFile(\"tHashFile_";
  protected final String TEXT_12 = "_\" + pid +\"_";
  protected final String TEXT_13 = "\");" + NL + "if(tHashFile_";
  protected final String TEXT_14 = "==null) {" + NL + "\tthrow new RuntimeException(\"The hash is not initialized : The hash must exist before you read from it\");" + NL + "}" + NL + "java.util.Iterator<";
  protected final String TEXT_15 = "Struct> iterator_";
  protected final String TEXT_16 = " = tHashFile_";
  protected final String TEXT_17 = ".iterator();" + NL + "while (iterator_";
  protected final String TEXT_18 = ".hasNext()) {";
  protected final String TEXT_19 = NL + "    ";
  protected final String TEXT_20 = "Struct next_";
  protected final String TEXT_21 = " = iterator_";
  protected final String TEXT_22 = ".next();" + NL;
  protected final String TEXT_23 = NL + "\t";
  protected final String TEXT_24 = ".";
  protected final String TEXT_25 = " = next_";
  protected final String TEXT_26 = ";";
  protected final String TEXT_27 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	class Util{
		//keep the tHashOutput Name when on the searching patch, in order to avoid the cycle reference problem.
		Set<String> nodeNames = new HashSet<String>();
		List<? extends INode> nodes = null;
		//the parameter node is tHashInput/tHashOutput
		public INode getOriginaltHashOutputNode(INode node) throws java.lang.Exception{	
			//initial it only once.
			if(nodes == null){
				nodes = node.getProcess().getGeneratingNodes();
			}
			
			String uniqueName = node.getUniqueName();
			if(nodeNames.contains(uniqueName)){
				//happen the cycle problem!!!
				//return null;
				throw new java.lang.Exception("Problem with " + uniqueName + " caused by cross-linking two tHashOutput components to each other.");
			}else{
				nodeNames.add(uniqueName);
				//1. get the tHashOuput node
				boolean isLinked = "true".equals(ElementParameterParser.getValue(node, "__LINK_WITH__"));
				String tHashOutputName = ElementParameterParser.getValue(node, "__LIST__");
				if(isLinked){
				
					//System.out.println("Node:" + uniqueName);
					//System.out.println("__LINK_WITH__:" + isLinked);
					//System.out.println("__LIST__:" + tHashOutputName);
					
					if(tHashOutputName != null && !tHashOutputName.trim().equals("")){
						INode tHashOutput = getNodeFromProcess(tHashOutputName);
						if(tHashOutput != null){
							//recursive call it!!!
							return getOriginaltHashOutputNode(tHashOutput);
						}else{
							//if go here, it means that user delete the original tHashOutput 
							//return null;
							throw new java.lang.Exception("if go here, it means that user delete the original tHashOutput.");
						}
					}else{
						//if go here, it means there should link to a tHashOutput, but user doesn't it.
						//return null;
						throw new java.lang.Exception("if go here, it means there should link to a tHashOutput, but user doesn't it.");
					}
				}else{
					//get it!!! it can be a 1).tHashInput(read file directly), 2). tHashOuput (the original one)  
					return node;
				}				
			}			
		}
		
		private INode getNodeFromProcess(String nodeName){			
	    	for (INode nd : nodes) {
	     	   if (nd.getUniqueName().equals(nodeName)) {
	     	      return nd;
	     	   }
	     	}			
			return null;
		}	
		
	}

    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	String jobName = codeGenArgument.getJobName();
	INode node = (INode)codeGenArgument.getArgument();	
	String cid = node.getUniqueName();
	
	//1. get the tHashOuput node
	boolean isLinked = "true".equals(ElementParameterParser.getValue(node, "__LINK_WITH__"));
	String tHashOutputName = ElementParameterParser.getValue(node, "__LIST__");
	INode tHashOutputNode = null;
	if(isLinked){
		try{
			Util util = new Util();
			tHashOutputNode = util.getOriginaltHashOutputNode(node);	
			//System.out.println(tHashOutputNode.getUniqueName());
		}catch(java.lang.Exception e){
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(e.getMessage() );
    stringBuffer.append(TEXT_4);
    }
	}
	
	//2. get tHashInput medadata
	IMetadataTable metadata = null;
	List<IMetadataTable> metadatas = node.getMetadataList();
	if (metadatas != null && metadatas.size() > 0) {
    	metadata = metadatas.get(0);
    }
    
    //3. get tHashOutput medadata
	IMetadataTable tHashOutput_metadata = null;	
	if(tHashOutputNode != null){
    	List<IMetadataTable> tHashOutput_metadatas = tHashOutputNode.getMetadataList();
    	if (tHashOutput_metadatas != null && tHashOutput_metadatas.size() > 0) {
        	tHashOutput_metadata = tHashOutput_metadatas.get(0);
        }
	}
	
	//5. get tHashInput output connectionName
	IConnection outputDataConn = null;
	String outputDataConnName = null;
	List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
	if (conns != null) {
		for (IConnection conn : conns) {
			if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){
				outputDataConn = conn;
				outputDataConnName = outputDataConn.getName();
				break;
			}
		}
	}
	
	//6. get tHashOutput incomming connectionName
	IConnection tHashOutput_incommingDataConn = null;
	String tHashOutput_incommingDataConnName = null;
	if(tHashOutputNode != null){
    	List< ? extends IConnection> tHashOutput_conns = tHashOutputNode.getIncomingConnections();
    	if (conns != null) {
    		for (IConnection conn : tHashOutput_conns) {
    			if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){
    				tHashOutput_incommingDataConn = conn;
    				tHashOutput_incommingDataConnName = tHashOutput_incommingDataConn.getName();
    				break;
    			}
    		}
    	}
	}

    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    
 if(outputDataConnName != null && tHashOutput_incommingDataConnName != null){
//fix bug 21630,use method getAdvancedMemoryHashFile to get a exist AdvancedMemoryHashFile

    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(tHashOutput_incommingDataConnName );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(jobName );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(tHashOutputName );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(tHashOutput_incommingDataConnName );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(tHashOutput_incommingDataConnName );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    
    List<IMetadataColumn> columns = metadata.getListColumns();
    List<IMetadataColumn>  tHashOutputcolumns = tHashOutput_metadata.getListColumns();
    
    //min
    int size = Math.min(columns.size(), tHashOutputcolumns.size());
    for(int i=0; i<size; i++){

    stringBuffer.append(TEXT_23);
    stringBuffer.append(outputDataConnName );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(columns.get(i).getLabel() );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(tHashOutputcolumns.get(i).getLabel() );
    stringBuffer.append(TEXT_26);
    
	}
}

    stringBuffer.append(TEXT_27);
    return stringBuffer.toString();
  }
}
