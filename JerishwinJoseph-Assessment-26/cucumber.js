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
      "json:report/cucumber-report.json",
      "html:report/cucumber-report.html"
    ],

    parallel: 1
  }

};