$fileDir = Split-Path -Parent $MyInvocation.MyCommand.Path
cd $fileDir
java '-Dtalend.component.manager.m2.repository=%cd%/../lib' '-Xms256M' '-Xmx1024M' -cp 'null' med_cargar_medicamentos_genericos.servicecarguemedgenericos_0_2.ServiceCargueMedGenericos --context=Default $args
