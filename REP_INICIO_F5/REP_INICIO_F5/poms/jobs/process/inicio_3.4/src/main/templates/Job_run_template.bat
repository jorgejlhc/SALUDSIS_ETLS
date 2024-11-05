%~d0
cd %~dp0
java -Dtalend.component.manager.m2.repository="%cd%/../lib" -Xms256M -Xmx1024M -Xmx2048M -Xmx4096M -Xmx6144M -cp .;../lib/routines.jar;../lib/log4j-slf4j-impl-2.17.1.jar;../lib/log4j-api-2.17.1.jar;../lib/log4j-core-2.17.1.jar;../lib/slf4j-api-1.7.34.jar;../lib/crypto-utils-7.1.16.jar;../lib/talendcsv-1.1.0.jar;../lib/jboss-marshalling-2.0.12.Final.jar;../lib/talend_file_enhanced-1.3.jar;../lib/dom4j-2.1.3.jar;inicio_3_4.jar;mail_1_3.jar;hospitalizacion_0_1.jar;acm_0_1.jar;cantidadesebas_0_1.jar;vac_f5_1_2.jar; rep_inicio_f5.inicio_3_4.Inicio --context=Default %*
