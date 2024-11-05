%~d0
cd %~dp0
java -Dtalend.component.manager.m2.repository="%cd%/../lib" -Xms256M -Xmx1024M -cp ${talend.job.bat.classpath} med_cargar_anexo_tecnico.servicecargaranexotecnico_0_2.ServiceCargarAnexoTecnico --context=Default %*
