module.exports = {
  default: {
    requireModule: ["ts-node/register"],

    require: [
      "src/hooks/**/*.ts",
      "src/steps/**/*.ts"
    ],

    paths: ["src/features/**/*.feature"],

    publishQuiet: true,

    format: [
      "progress",
      "json:reports/cucumber-report.json",
      "html:reports/cucumber-report.html"
    ],

    parallel: 1
  }

};