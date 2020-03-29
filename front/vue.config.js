module.exports = {
    devServer: {
        // Paths
        // assetsSubDirectory: 'static',
        // assetsPublicPath: '/',
        proxy: {
            '/api': {
                target: 'http://0.0.0.0:8080',
                changeOrigin: true,
                pathRewrite: {
                    '^/api': ''   //重写接口
                }
            }
        },

        // // Various Dev Server settings
        host: '0.0.0.0', // can be overwritten by process.env.HOST
        port: 8071, // can be overwritten by process.env.PORT, if port is in use, a free one will be determined
        // autoOpenBrowser: false,
        // errorOverlay: true,
        // notifyOnErrors: true,
        // poll: false, // https://webpack.js.org/configuration/dev-server/#devserver-watchoptions-
        //
        //
        // /**
        //  * Source Maps
        //  */
        //
        // // https://webpack.js.org/configuration/devtool/#development
        // devtool: 'cheap-module-eval-source-map',
        //
        // // If you have problems debugging vue-files in devtools,
        // // set this to false - it *may* help
        // // https://vue-loader.vuejs.org/en/options.html#cachebusting
        // cacheBusting: true,
        //
        // cssSourceMap: true
    },
}