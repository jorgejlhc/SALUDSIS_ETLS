%~d0
cd %~dp0
java -Dtalend.component.manager.m2.repository="%cd%/../lib" -Xms256M -Xmx1024M -cp ${talend.job.bat.classpath} afi_novedades_afiliado.servicenuevasafiliaciones_0_2.ServiceNuevasAfiliaciones --context=Default %*
