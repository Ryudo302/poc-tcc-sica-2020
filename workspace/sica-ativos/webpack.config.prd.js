var path = require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin');
const { CleanWebpackPlugin } = require('clean-webpack-plugin');

module.exports = {
	entry: './src/main/js/index.js',
	devtool: 'sourcemaps',
	cache: true,
	mode: 'production',
	output: {
		path: path.join(__dirname, 'src', 'main', 'resources', 'static', 'built'),
		filename: 'bundle.[hash].js',
		publicPath: './built'
	},
	devServer: {
		inline: true,
		contentBase: './src/main/resources/static',
		port: 9000
	},
	module: {
		rules: [{
			test: /\.jsx?$/i, // path.join(__dirname, '.'),
			exclude: /(node_modules)/,
			use: [{
				loader: 'babel-loader',
				options: {
					babelrc: false,
					presets: [["@babel/preset-env", {
						modules: false
					}], "@babel/preset-react"]
				}
			}]
		},
		{
			test: /\.css$/i,
			use: ['style-loader', 'css-loader'],
		}]
	},
	plugins: [
		new CleanWebpackPlugin(),
		new HtmlWebpackPlugin({
			hash: true,
			filename: '../../templates/index.html',
			template: 'src/main/resources/templates/index.template.html'
		})
	]
};
