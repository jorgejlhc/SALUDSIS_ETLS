$fileDir = Split-Path -Parent $MyInvocation.MyCommand.Path
cd $fileDir
java '-Dtalend.component.manager.m2.repository=%cd%/../lib' '-Xms256M' '-Xmx1024M' -cp 'null' rep_mes_productividad.servicemesproductividad_0_2.ServiceMesProductividad --context=Default $args
