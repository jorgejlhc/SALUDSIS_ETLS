package org.talend.designer.codegen.translators.technical;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.utils.NodeUtil;

public class TJobStructureCatcherBeginJava
{
  protected static String nl;
  public static synchronized TJobStructureCatcherBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TJobStructureCatcherBeginJava result = new TJobStructureCatcherBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\tfor (JobStructureCatcherUtils.JobStructureCatcherMessage jcm : ";
  protected final String TEXT_3 = ".getMessages()) {" + NL + "\t\torg.talend.job.audit.JobContextBuilder builder_";
  protected final String TEXT_4 = " = org.talend.job.audit.JobContextBuilder.create().jobName(jcm.job_name).jobId(jcm.job_id).jobVersion(jcm.job_version)" + NL + "\t\t\t.custom(\"process_id\", jcm.pid).custom(\"thread_id\", jcm.tid).custom(\"pid\", pid).custom(\"father_pid\", fatherPid).custom(\"root_pid\", rootPid);" + NL + "\t\torg.talend.logging.audit.Context log_context_";
  protected final String TEXT_5 = " = null;" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_6 = NL + "\t\tif(jcm.log_type == JobStructureCatcherUtils.LogType.PERFORMANCE){" + NL + "\t\t\tlong timeMS = jcm.end_time - jcm.start_time;" + NL + "\t\t\tString duration = String.valueOf(timeMS);" + NL + "\t\t\t" + NL + "\t\t\tlog_context_";
  protected final String TEXT_7 = " = builder_";
  protected final String TEXT_8 = NL + "\t\t\t\t.sourceId(jcm.sourceId).sourceLabel(jcm.sourceLabel).sourceConnectorType(jcm.sourceComponentName)" + NL + "\t\t\t\t.targetId(jcm.targetId).targetLabel(jcm.targetLabel).targetConnectorType(jcm.targetComponentName)" + NL + "\t\t\t\t.connectionName(jcm.current_connector).rows(jcm.row_count).duration(duration).build();" + NL + "\t\t\tauditLogger_";
  protected final String TEXT_9 = ".flowExecution(log_context_";
  protected final String TEXT_10 = ");" + NL + "\t\t} else if(jcm.log_type == JobStructureCatcherUtils.LogType.JOBSTART) {" + NL + "\t\t\tlog_context_";
  protected final String TEXT_11 = ".timestamp(jcm.moment).build();" + NL + "\t\t\tauditLogger_";
  protected final String TEXT_12 = ".jobstart(log_context_";
  protected final String TEXT_13 = ");" + NL + "\t\t} else if(jcm.log_type == JobStructureCatcherUtils.LogType.JOBEND) {" + NL + "\t\t\tlong timeMS = jcm.end_time - jcm.start_time;" + NL + "\t\t\tString duration = String.valueOf(timeMS);" + NL + "\t\t" + NL + "\t\t\tlog_context_";
  protected final String TEXT_14 = NL + "\t\t\t\t.timestamp(jcm.moment).duration(duration).status(jcm.status).build();" + NL + "\t\t\tauditLogger_";
  protected final String TEXT_15 = ".jobstop(log_context_";
  protected final String TEXT_16 = ");" + NL + "\t\t} else if(jcm.log_type == JobStructureCatcherUtils.LogType.RUNCOMPONENT) {" + NL + "\t\t\tlog_context_";
  protected final String TEXT_17 = ".timestamp(jcm.moment)" + NL + "\t\t\t\t.connectorType(jcm.component_name).connectorId(jcm.component_id).connectorLabel(jcm.component_label).build();" + NL + "\t\t\tauditLogger_";
  protected final String TEXT_18 = ".runcomponent(log_context_";
  protected final String TEXT_19 = ");" + NL + "\t\t} else if(jcm.log_type == JobStructureCatcherUtils.LogType.FLOWINPUT) {//log current component input line" + NL + "\t\t\tlong timeMS = jcm.end_time - jcm.start_time;" + NL + "\t\t\tString duration = String.valueOf(timeMS);" + NL + "\t\t\t" + NL + "\t\t\tlog_context_";
  protected final String TEXT_20 = NL + "\t\t\t\t.connectorType(jcm.component_name).connectorId(jcm.component_id).connectorLabel(jcm.component_label)" + NL + "\t\t\t\t.connectionName(jcm.current_connector).connectionType(jcm.current_connector_type)" + NL + "\t\t\t\t.rows(jcm.total_row_number).duration(duration).build();" + NL + "\t\t\tauditLogger_";
  protected final String TEXT_21 = ".flowInput(log_context_";
  protected final String TEXT_22 = ");" + NL + "\t\t} else if(jcm.log_type == JobStructureCatcherUtils.LogType.FLOWOUTPUT) {//log current component output/reject line" + NL + "\t\t\tlong timeMS = jcm.end_time - jcm.start_time;" + NL + "\t\t\tString duration = String.valueOf(timeMS);" + NL + "\t\t\t" + NL + "\t\t\tlog_context_";
  protected final String TEXT_23 = ".flowOutput(log_context_";
  protected final String TEXT_24 = ");" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_25 = NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_26 = NL + "\t\tif(jcm.log_type == JobStructureCatcherUtils.LogType.RUNTIMEPARAMETER) {" + NL + "\t\t\tbuilder_";
  protected final String TEXT_27 = ".connectorType(jcm.component_name).connectorId(jcm.component_id);" + NL + "\t\t\t" + NL + "\t\t\tfor(java.util.Map.Entry<String,String> entry : jcm.component_parameters.entrySet()) {" + NL + "\t\t\t\tbuilder_";
  protected final String TEXT_28 = ".custom(\"P_\" + entry.getKey(), entry.getValue());" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tlog_context_";
  protected final String TEXT_29 = ".build();" + NL + "\t\t\t" + NL + "\t\t\truntime_lineage_logger_";
  protected final String TEXT_30 = ".componentParameters(log_context_";
  protected final String TEXT_31 = ");" + NL + "\t\t} else if(jcm.log_type == JobStructureCatcherUtils.LogType.RUNTIMESCHEMA) {" + NL + "\t\t\tlog_context_";
  protected final String TEXT_32 = NL + "\t\t\t\t.sourceConnectorType(jcm.sourceComponentName).sourceId(jcm.sourceId)" + NL + "\t\t\t\t.connectionName(jcm.current_connector).schema(jcm.component_schema.toString())" + NL + "\t\t\t\t.targetConnectorType(jcm.targetComponentName).targetId(jcm.targetId).build();" + NL + "\t\t\truntime_lineage_logger_";
  protected final String TEXT_33 = ".schema(log_context_";
  protected final String TEXT_34 = NL + "\t}";
  protected final String TEXT_35 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	boolean enable_runtime_lineage_log = NodeUtil.isJobUsingRuntimeLineage(node.getProcess());
	boolean enableLogStash = !Boolean.getBoolean("deactivate_extended_component_log");


    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    if(enableLogStash) {
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    }
    stringBuffer.append(TEXT_25);
    if(enable_runtime_lineage_log) {
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    }
    stringBuffer.append(TEXT_34);
    stringBuffer.append(TEXT_35);
    return stringBuffer.toString();
  }
}
