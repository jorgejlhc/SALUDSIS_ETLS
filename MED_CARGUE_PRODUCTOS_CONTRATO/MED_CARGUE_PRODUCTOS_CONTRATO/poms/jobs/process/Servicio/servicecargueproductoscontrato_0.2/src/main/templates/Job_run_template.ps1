$fileDir = Split-Path -Parent $MyInvocation.MyCommand.Path
cd $fileDir
java '-Dtalend.component.manager.m2.repository=%cd%/../lib' '-Xms256M' '-Xmx1024M' -cp 'null' med_cargue_productos_contrato.servicecargueproductoscontrato_0_2.ServiceCargueProductosContrato --context=Default $args
