%~d0
cd %~dp0
java -Dtalend.component.manager.m2.repository="%cd%/../lib" -Xms256M -Xmx1024M -cp .;../lib/routines.jar;../lib/log4j-slf4j-impl-2.17.1.jar;../lib/log4j-api-2.17.1.jar;../lib/log4j-core-2.17.1.jar;../lib/ojdbc8-19.19.0.0.jar;../lib/slf4j-api-1.7.34.jar;../lib/crypto-utils-7.1.16.jar;../lib/jboss-marshalling-2.0.12.Final.jar;../lib/talend_file_enhanced-1.3.jar;../lib/dom4j-2.1.3.jar;../lib/talend-oracle-timestamptz.jar;manager_log_0_2.jar; sope_generador_soporte.manager_log_0_2.MANAGER_LOG --context=Default %*
