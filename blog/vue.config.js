module.exports = {
    outputDir: 'dist',
    devServer: {
        open: process.platform === 'vue',
        host: '127.0.0.1',
        port: 80,
        https: false,
        hotOnly: false,
        proxy: { // 设置代理
            '/api': {
                target: 'http://localhost:8080',
                secure:false,
                changeOrigin: true,
                pathRewrite: {
                    '^/api': '/blog-web'
                }
            }
        },
        disableHostCheck: true
    },
}
