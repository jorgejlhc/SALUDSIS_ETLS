#!/bin/sh
cd `dirname $0`
ROOT_PATH=`pwd`
java -Dtalend.component.manager.m2.repository=$ROOT_PATH/../lib -XX:+DisableExplicitGC -Xms4096m -Xmx4096m -XX:MetaspaceSize=512M -XX:MaxMetaspaceSize=2048m -XX:+UseG1GC -XX:MaxGCPauseMillis=200 -cp .:$ROOT_PATH:$ROOT_PATH/../lib/routines.jar:$ROOT_PATH/../lib/log4j-slf4j-impl-2.17.1.jar:$ROOT_PATH/../lib/log4j-api-2.17.1.jar:$ROOT_PATH/../lib/log4j-core-2.17.1.jar:$ROOT_PATH/../lib/jsr311-api-1.1.1.jar:$ROOT_PATH/../lib/ojdbc8-19.19.0.0.jar:$ROOT_PATH/../lib/xercesImpl-2.12.2.jar:$ROOT_PATH/../lib/xml-apis-1.4.01.jar:$ROOT_PATH/../lib/crypto-utils-7.1.16.jar:$ROOT_PATH/../lib/json-20230618.jar:$ROOT_PATH/../lib/TalendSAX.jar:$ROOT_PATH/../lib/jboss-marshalling-2.0.12.Final.jar:$ROOT_PATH/../lib/jersey-client-1.19.jar:$ROOT_PATH/../lib/thashfile-3.1-20190910.jar:$ROOT_PATH/../lib/commons-codec-1.15.jar:$ROOT_PATH/../lib/activation.jar:$ROOT_PATH/../lib/javax.mail-1.6.2.jar:$ROOT_PATH/../lib/jersey-core-1.19.jar:$ROOT_PATH/../lib/slf4j-api-1.7.34.jar:$ROOT_PATH/../lib/talendcsv-1.1.0.jar:$ROOT_PATH/../lib/talend_file_enhanced-1.3.jar:$ROOT_PATH/../lib/dom4j-2.1.3.jar:$ROOT_PATH/../lib/talend-oracle-timestamptz.jar:$ROOT_PATH/recordarcitasmedicas_0_1.jar: age_recordar_citas_medicas.recordarcitasmedicas_0_1.RecordarCitasMedicas --context=Default "$@"