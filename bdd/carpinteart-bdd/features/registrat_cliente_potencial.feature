Feature: Registrar Cliente Potencial
COMO ejecutivo de ventas
REQUIERO registrar futuros clientes (clientes potenciales) en el sistema
PARA poder hacerles un seguimiento, mostrarles novedades y ofertas con el fin de convertirlos en clientes permanentes de la empresa.
PRE-REQUISITO: El ejecutivo de ventas debe estar con una sesión activa en el sistema (mediante esto se genera un token de seguridad en el sistema).


  Scenario: Registro exitoso de Persona Natural 
   Given con los siguientes datos para Registrar Un cliente potencial: nombre: "Ruth", Apellidos: "Vargas" "Cespedes" ci: "67671111645667" dirección: "Barrio los Jardines" proyecto: "Meson para oficina" empresa:"" nit:"" teléfono: "77655893" email: "vmr@gmail.com" de tipo "NATURAL"
   When envio los datos con POST al servicio para Registar 
   Then el servidor responder con el estado 201 ok
   And se deberia mostar un mensaje que diga " Se guardo correctamente"

   Scenario: Registro fallido de Persona Natural 
   Given con los siguientes datos para Registrar Un cliente potencial: nombre: "Ruth", Apellidos: "Vargas" "Cespedes" ci: "67671111645667" dirección: "Barrio los Jardines" proyecto: "Meson para oficina" empresa:"" nit:"" teléfono: "77655893" email: "vmr@gmail.com" de tipo "NATURAL"
   When envio los datos con POST al servicio para Registar 
   Then el servidor responder con el estado 406 Not Acceptable
   And se deberia mostar un mensaje que diga " Error: Cliente potencial ya existente"

  Scenario: Registro exitoso de Persona Legal 
   Given con los siguientes datos para Registrar Un cliente potencial: nombre: "", Apellidos: "" "" ci: "" dirección: "Barrio los Jardines" proyecto: "Escritorio para sala de reuniones" empresa:"EmpresaTest" nit:"454467768644" teléfono: "3567489" email: "test@empresa.com" de tipo "LEGAL"
   When envio los datos con POST al servicio para Registar 
   Then el servidor responder con el estado 201 ok
   And se deberia mostar un mensaje que diga " Se guardo correctamente"

   Scenario: Registro exitoso de Persona Legal 
   Given con los siguientes datos para Registrar Un cliente potencial: nombre: "", Apellidos: "" "" ci: "" dirección: "Barrio los Jardines" proyecto: "Escritorio para sala de reuniones" empresa:"EmpresaTest" nit:"454467768644" teléfono: "3567489" email: "test@empresa.com" de tipo "LEGAL"
   When envio los datos con POST al servicio para Registar 
   Then el servidor responder con el estado 406 Not Acceptable
   And se deberia mostar un mensaje que diga " Error: Cliente potencial ya existente"
