describe('Search with duckduckgo', () => {
    it('Go to home page', () => {
        cy.visit("https://duckduckgo.com/")

        cy.title().should('include', 'DuckDuckGo')

        cy.get('input[name="q"]').type('Cypress{enter}')

    })
 
})