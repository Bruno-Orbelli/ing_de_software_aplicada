<reference types="cypress" />

import React from 'react';
import ReactDOM from 'react-dom';

describe('poll filling', () => {
    const username = 'b.orbelli'
    const password = '1ml0v1ng1t'
    
    beforeEach(() => {
        cy.visit('https://virtual.um.edu.ar/')
        // Log in
        cy.get('#username').type(`${username}`)
        cy.get('#password').type(`${password}`)
        cy.get('#loginbtn').click()
    })

    it('fill and send', () => {
        cy.get('.list-group li').contains('Ingeniería de Software Aplicada (2080)').click()
        cy.get('.instancename').contains('Resolví el test en Cypress').click()
        cy.get('.btn.btn-primary').contains('Responda a las preguntas...').click()
        cy.get('.qn-answer input[type="radio"]')
            .should('have.length', 2)
            .first()
            .click()
        cy.get('#dropSelecciòn').select(3)
        cy.get('.btn.btn-primary').contains('Enviar encuesta').click()
        cy.get('.btn.btn-secondary').contains('Continuar').click()
    })
})