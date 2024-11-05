$fileDir = Split-Path -Parent $MyInvocation.MyCommand.Path
cd $fileDir
java '-Dtalend.component.manager.m2.repository=%cd%/../lib' '-Xms256M' '-Xmx1024M' -cp 'null' aut_manual_tarifario.servicemanualtarifario_0_2.ServiceManualTarifario --context=Default $args
