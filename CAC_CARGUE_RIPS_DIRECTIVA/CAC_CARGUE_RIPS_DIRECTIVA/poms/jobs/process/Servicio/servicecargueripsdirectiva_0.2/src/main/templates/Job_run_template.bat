%~d0
cd %~dp0
java -Dtalend.component.manager.m2.repository="%cd%/../lib" -Xms256M -Xmx1024M -cp ${talend.job.bat.classpath} cac_cargue_rips_directiva.servicecargueripsdirectiva_0_2.ServiceCargueRipsDirectiva --context=Default %*
