$fileDir = Split-Path -Parent $MyInvocation.MyCommand.Path
cd $fileDir
java '-Dtalend.component.manager.m2.repository=%cd%/../lib' '-Xms256M' '-Xmx1024M' -cp 'null' afi_actualizacion_masiva.servicesactualizacionmasiva_0_2.ServicesActualizacionMasiva --context=Default $args
