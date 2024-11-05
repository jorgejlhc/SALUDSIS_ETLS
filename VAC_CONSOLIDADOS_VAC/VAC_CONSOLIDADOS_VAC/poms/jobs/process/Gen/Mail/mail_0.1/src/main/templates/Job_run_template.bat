%~d0
cd %~dp0
java -Dtalend.component.manager.m2.repository="%cd%/../lib" -Xms256M -Xmx1024M -cp .;../lib/routines.jar;../lib/log4j-slf4j-impl-2.17.1.jar;../lib/log4j-api-2.17.1.jar;../lib/log4j-core-2.17.1.jar;../lib/activation-1.1.jar;../lib/jakarta.mail-1.6.7.jar;../lib/xercesImpl-2.12.2.jar;../lib/xml-apis-1.4.01.jar;../lib/slf4j-api-1.7.34.jar;../lib/crypto-utils-7.1.16.jar;../lib/TalendSAX.jar;../lib/jboss-marshalling-2.0.12.Final.jar;../lib/dom4j-2.1.3.jar;mail_0_1.jar; vac_consolidados_vac.mail_0_1.Mail --context=Default %*
