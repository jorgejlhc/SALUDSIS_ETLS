$fileDir = Split-Path -Parent $MyInvocation.MyCommand.Path
cd $fileDir
java '-Dtalend.component.manager.m2.repository=%cd%/../lib' '-Xms256M' '-Xmx1024M' -cp 'null' sope_descargue_encuesta.servicedescargueencuesta_0_2.ServiceDescargueEncuesta --context=Default $args
