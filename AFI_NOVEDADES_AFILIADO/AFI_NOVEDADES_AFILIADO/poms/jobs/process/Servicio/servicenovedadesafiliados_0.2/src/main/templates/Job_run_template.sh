#!/bin/sh
cd `dirname $0`
ROOT_PATH=`pwd`
java -Dtalend.component.manager.m2.repository=$ROOT_PATH/../lib -Xms256M -Xmx1024M -cp ${talend.job.sh.classpath} afi_novedades_afiliado.servicenovedadesafiliados_0_2.ServiceNovedadesAfiliados --context=Default "$@"
