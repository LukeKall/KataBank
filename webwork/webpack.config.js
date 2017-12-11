var path = require("path");

module.exports = {
    entry: [
        path.resolve(__dirname, "src/index.js")
    ],
    output: {
        path : path.resolve(__dirname,'out'),
        filename: "bundle.js"
    },
    devServer: {
        contentBase: "/",
        hot: true
    },
};