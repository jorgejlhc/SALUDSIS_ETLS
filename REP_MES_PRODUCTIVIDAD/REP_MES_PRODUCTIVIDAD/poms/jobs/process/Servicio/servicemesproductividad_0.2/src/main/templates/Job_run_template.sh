#!/bin/sh
cd `dirname $0`
ROOT_PATH=`pwd`
java -Dtalend.component.manager.m2.repository=$ROOT_PATH/../lib -Xms256M -Xmx1024M -cp ${talend.job.sh.classpath} rep_mes_productividad.servicemesproductividad_0_2.ServiceMesProductividad --context=Default "$@"