%~d0
cd %~dp0
java -Dtalend.component.manager.m2.repository="%cd%/../lib" -Xms256M -Xmx1024M -cp ${talend.job.bat.classpath} sope_descargue_encuesta.servicedescargueencuesta_0_2.ServiceDescargueEncuesta --context=Default %*