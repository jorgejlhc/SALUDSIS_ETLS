%~d0
cd %~dp0
java -Dtalend.component.manager.m2.repository="%cd%/../lib" -Xms256M -Xmx1024M -cp ${talend.job.bat.classpath} med_cargue_inventario.servicecargueinventario_0_2.ServiceCargueInventario --context=Default %*