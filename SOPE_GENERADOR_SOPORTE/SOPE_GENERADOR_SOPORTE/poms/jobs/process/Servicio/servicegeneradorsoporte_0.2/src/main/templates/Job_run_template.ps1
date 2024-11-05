$fileDir = Split-Path -Parent $MyInvocation.MyCommand.Path
cd $fileDir
java '-Dtalend.component.manager.m2.repository=%cd%/../lib' '-Xms256M' '-Xmx1024M' -cp 'null' sope_generador_soporte.servicegeneradorsoporte_0_2.ServiceGeneradorSoporte --context=Default $args
