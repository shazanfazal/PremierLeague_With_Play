const PROXY_CONFIG = {
  "**": {
    "target": "http://localhost:9000",
    "secure": false,
    "bypass": function (request) {
      if (request && request.headers && request.headers.accept && request.headers.accept.indexOf("html") !== -1) {
        //console.log("Skipping proxy for browser request.");
        return "/index.html";
      }
    }
  }
};
module.exports = PROXY_CONFIG;
