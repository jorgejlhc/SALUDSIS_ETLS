$fileDir = Split-Path -Parent $MyInvocation.MyCommand.Path
cd $fileDir
java '-Dtalend.component.manager.m2.repository=%cd%/../lib' '-Xms256M' '-Xmx1024M' -cp 'null' afi_cargue_masivo.servicecarguemasivo_0_2.ServiceCargueMasivo --context=Default $args
