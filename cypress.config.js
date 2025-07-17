const { defineConfig } = require("cypress");

module.exports = defineConfig({
  e2e: {
    setupNodeEvents(on, config) {
      config.specPattern = "e2e/**/*.cy.js";
      this.defaultBrowser = "chrome";
      this.video = true;
      // implement node event listeners here
    },
  },
});
