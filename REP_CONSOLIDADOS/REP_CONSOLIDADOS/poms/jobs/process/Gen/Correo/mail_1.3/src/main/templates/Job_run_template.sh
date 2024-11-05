#!/bin/sh
cd `dirname $0`
ROOT_PATH=`pwd`
java -Dtalend.component.manager.m2.repository=$ROOT_PATH/../lib -Xms256M -Xmx1024M -cp .:$ROOT_PATH:$ROOT_PATH/../lib/routines.jar:$ROOT_PATH/../lib/log4j-slf4j-impl-2.17.1.jar:$ROOT_PATH/../lib/log4j-api-2.17.1.jar:$ROOT_PATH/../lib/log4j-core-2.17.1.jar:$ROOT_PATH/../lib/activation-1.1.jar:$ROOT_PATH/../lib/jakarta.mail-1.6.7.jar:$ROOT_PATH/../lib/xercesImpl-2.12.2.jar:$ROOT_PATH/../lib/xml-apis-1.4.01.jar:$ROOT_PATH/../lib/slf4j-api-1.7.34.jar:$ROOT_PATH/../lib/crypto-utils-7.1.16.jar:$ROOT_PATH/../lib/TalendSAX.jar:$ROOT_PATH/../lib/jboss-marshalling-2.0.12.Final.jar:$ROOT_PATH/../lib/dom4j-2.1.3.jar:$ROOT_PATH/mail_1_3.jar: rep_consolidados.mail_1_3.Mail --context=Default "$@"
