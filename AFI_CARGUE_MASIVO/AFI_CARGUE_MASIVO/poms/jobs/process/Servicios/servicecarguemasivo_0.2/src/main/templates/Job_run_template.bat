%~d0
cd %~dp0
java -Dtalend.component.manager.m2.repository="%cd%/../lib" -Xms256M -Xmx1024M -cp ${talend.job.bat.classpath} afi_cargue_masivo.servicecarguemasivo_0_2.ServiceCargueMasivo --context=Default %*
