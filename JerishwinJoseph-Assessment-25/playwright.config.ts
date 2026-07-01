import { defineConfig, devices } from '@playwright/test';

export default defineConfig({
  testDir: './Task1-3',

  fullyParallel: true,
  reporter: 'html',

  use: {
    browserName:'chromium',
    trace: 'on',
    video:'on',
    screenshot:'on'
  },


});
