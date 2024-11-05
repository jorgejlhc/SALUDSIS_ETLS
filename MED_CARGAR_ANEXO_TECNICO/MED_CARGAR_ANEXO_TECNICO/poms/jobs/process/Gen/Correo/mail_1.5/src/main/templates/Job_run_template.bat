%~d0
cd %~dp0
java -Dtalend.component.manager.m2.repository="%cd%/../lib" -Xms256M -Xmx1024M -cp .;../lib/routines.jar;../lib/log4j-slf4j-impl-2.17.1.jar;../lib/log4j-api-2.17.1.jar;../lib/log4j-core-2.17.1.jar;../lib/activation-1.1.jar;../lib/jakarta.mail-1.6.7.jar;../lib/xpathutil-1.0.0.jar;../lib/slf4j-api-1.7.34.jar;../lib/crypto-utils-7.1.16.jar;../lib/jboss-marshalling-2.0.12.Final.jar;../lib/dom4j-2.1.3.jar;../lib/jaxen-1.1.6.jar;mail_1_5.jar; med_cargar_anexo_tecnico.mail_1_5.Mail --context=Default %*
