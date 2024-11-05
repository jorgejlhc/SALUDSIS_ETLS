%~d0
cd %~dp0
java -Dtalend.component.manager.m2.repository="%cd%/../lib" -Xms256M -Xmx1024M -cp ${talend.job.bat.classpath} aut_manual_tarifario.servicemanualtarifario_0_2.ServiceManualTarifario --context=Default %*
