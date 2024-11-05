$fileDir = Split-Path -Parent $MyInvocation.MyCommand.Path
cd $fileDir
java '-Dtalend.component.manager.m2.repository=%cd%/../lib' '-Xms256M' '-Xmx1024M' -cp 'null' afi_cargue_aportes.servicecargaraportes_0_2.ServiceCargarAportes --context=Default $args
