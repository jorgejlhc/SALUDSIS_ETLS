$fileDir = Split-Path -Parent $MyInvocation.MyCommand.Path
cd $fileDir
java '-Dtalend.component.manager.m2.repository=%cd%/../lib' '-Xms256M' '-Xmx1024M' -cp 'null' med_cargue_moleculas_acuerdo.servicecarguemoleculasacuerdo_0_2.ServiceCargueMoleculasAcuerdo --context=Default $args
