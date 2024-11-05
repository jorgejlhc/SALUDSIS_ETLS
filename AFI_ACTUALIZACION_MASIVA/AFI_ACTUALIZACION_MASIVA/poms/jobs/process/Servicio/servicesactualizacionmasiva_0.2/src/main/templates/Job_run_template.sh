#!/bin/sh
cd `dirname $0`
ROOT_PATH=`pwd`
java -Dtalend.component.manager.m2.repository=$ROOT_PATH/../lib -Xms256M -Xmx1024M -cp ${talend.job.sh.classpath} afi_actualizacion_masiva.servicesactualizacionmasiva_0_2.ServicesActualizacionMasiva --context=Default "$@"
