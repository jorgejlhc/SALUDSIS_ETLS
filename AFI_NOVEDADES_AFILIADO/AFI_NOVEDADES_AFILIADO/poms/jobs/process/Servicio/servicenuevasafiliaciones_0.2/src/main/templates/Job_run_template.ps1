$fileDir = Split-Path -Parent $MyInvocation.MyCommand.Path
cd $fileDir
java '-Dtalend.component.manager.m2.repository=%cd%/../lib' '-Xms256M' '-Xmx1024M' -cp 'null' afi_novedades_afiliado.servicenuevasafiliaciones_0_2.ServiceNuevasAfiliaciones --context=Default $args
