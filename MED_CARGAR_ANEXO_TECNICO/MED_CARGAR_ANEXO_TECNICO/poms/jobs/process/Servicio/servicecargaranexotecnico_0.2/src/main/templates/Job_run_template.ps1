$fileDir = Split-Path -Parent $MyInvocation.MyCommand.Path
cd $fileDir
java '-Dtalend.component.manager.m2.repository=%cd%/../lib' '-Xms256M' '-Xmx1024M' -cp 'null' med_cargar_anexo_tecnico.servicecargaranexotecnico_0_2.ServiceCargarAnexoTecnico --context=Default $args
