$fileDir = Split-Path -Parent $MyInvocation.MyCommand.Path
cd $fileDir
java '-Dtalend.component.manager.m2.repository=%cd%/../lib' '-Xms256M' '-Xmx1024M' -cp 'null' cac_cargue_rips_directiva.servicecargueripsdirectiva_0_2.ServiceCargueRipsDirectiva --context=Default $args
