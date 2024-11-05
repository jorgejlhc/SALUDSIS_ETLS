#!/bin/sh
cd `dirname $0`
ROOT_PATH=`pwd`
java -Dtalend.component.manager.m2.repository=$ROOT_PATH/../lib -Xms256M -Xmx1024M -cp ${talend.job.sh.classpath} afi_cargue_aportes.servicecargaraportes_0_2.ServiceCargarAportes --context=Default "$@"
