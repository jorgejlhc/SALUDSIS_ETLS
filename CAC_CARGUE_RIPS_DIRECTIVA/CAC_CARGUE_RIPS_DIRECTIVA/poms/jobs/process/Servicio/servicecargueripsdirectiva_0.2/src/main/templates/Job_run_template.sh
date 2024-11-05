#!/bin/sh
cd `dirname $0`
ROOT_PATH=`pwd`
java -Dtalend.component.manager.m2.repository=$ROOT_PATH/../lib -Xms256M -Xmx1024M -cp ${talend.job.sh.classpath} cac_cargue_rips_directiva.servicecargueripsdirectiva_0_2.ServiceCargueRipsDirectiva --context=Default "$@"
