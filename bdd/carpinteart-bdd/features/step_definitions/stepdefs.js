const { Given, When, Then } = require('cucumber')
const { expect } = require('chai')
const request = require('request-promise')

let name;
let fatherLastname;
let motherLastname; 
let identityCard;
let address;
let project;
let businessName;
let nit;
let phoneNumber;
let type;
let email;

let statusCode;

Given('con los siguientes datos para Registrar Un cliente potencial: nombre: {string}, Apellidos: {string} {string} ci: {string} dirección: {string} proyecto: {string} empresa:{string} nit:{string} teléfono: {string} email: {string} de tipo {string}',
function (name, fatherLastname, motherLastname, identityCard, address, project, businessName, nit, phoneNumber, email, type) {
    this.name = name;
    this.fatherLastname = fatherLastname;
    this.motherLastname = motherLastname;
    this.identityCard = identityCard;
    this.address = address;
    this.project = project;
    this.businessName = businessName;
    this.nit = nit;
    this.phoneNumber = phoneNumber;
    this.email = email; 
    this.type = type;
});

When('envio los datos con POST al servicio para Registar', async function () {
    let options = {
        method: 'POST',
        uri: 'http://localhost:9090/api/potentialClient',
        json: true,
        body: {
            "name": this.name,
            "fatherLastname": this.fatherLastname,
            "motherLastname": this.motherLastname,
            "identityCard": this.identityCard,
            "address": this.address,
            "project": this.project,
            "businessName": this.businessName,
            "nit": this.nit,
            "phoneNumber": this.phoneNumber,
            "type": this.type,
            "email": this.email
          },
        headers: {
          'Content-Type': 'application/json',
          'Authorization': 'Bearer ' + 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ2YXJnYXMiLCJicmFuY2hfb2ZmaWNlIjoxLCJ1c2VyX2lkIjo0MiwiZXhwIjoxNTMwNTI5MDM1fQ.8GwVqrsbT4WHUMAb5_umub8v-EO3OhTW1CnObiEqC-4'
        },
        resolveWithFullResponse: true
      };
    
      await request(options)
        .then(function (response) {
            authResponse = response;
        })
        .catch(function (error) {
            authResponse = error;
        });
  });

  Then('el servidor responde con el estado {int} ok', function (code) {
    expect(authResponse.statusCode).to.eql(code);
    statusCode = code;  
  });

  Then('se deberia mostar un mensaje que diga {string}', function (mensaje) {
    console.log(mensaje);
  });

  