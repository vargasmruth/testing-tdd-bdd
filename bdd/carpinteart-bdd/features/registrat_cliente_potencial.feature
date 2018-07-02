Feature: Registrar Cliente Potencial
COMO ejecutivo de ventas
REQUIERO registrar futuros clientes (clientes potenciales) en el sistema
PARA poder hacerles un seguimiento.

  Scenario: Registro exitoso de Persona Natural 
   Given con los siguientes datos para Registrar Un cliente potencial: nombre: "Ruth", Apellidos: "Vargas" "Cespedes" ci: "67671111645667" dirección: "Barrio los Jardines" proyecto: "Meson para oficina" empresa:"" nit:"" teléfono: "77655893" email: "vmr@gmail.com" de tipo "NATURAL"
   When envio los datos con POST al servicio para Registar 
   Then el servidor responde con el estado 201 ok
   And se deberia mostar un mensaje que diga " Se guardo correctamente"

