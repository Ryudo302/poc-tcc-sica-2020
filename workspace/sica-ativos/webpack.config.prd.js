var path = require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin');
const { CleanWebpackPlugin } = require('clean-webpack-plugin');
const LodashModuleReplacementPlugin = require('lodash-webpack-plugin');

module.exports = {
	entry: './src/main/js/index.js',
	mode: 'production',
	output: {
		path: path.join(__dirname, 'src', 'main', 'resources', 'static', 'built'),
		filename: 'bundle.[hash].js',
		publicPath: './built/'
	},
	module: {
		rules: [{
			test: /\.jsx?$/, // path.join(__dirname, '.'),
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
		},
		{
	        test: /\.(woff(2)?|ttf|eot|svg)(\?v=\d+\.\d+\.\d+)?$/,
	        use: [
	          {
	            loader: 'file-loader',
	            options: {
	              name: '[name].[ext]',
	              outputPath: 'fonts/'
	            }
	          }
	        ]
		}]
	},
	resolve: {
		extensions: ['.js', '.jsx']
	},
	plugins: [
		new CleanWebpackPlugin(),
		new HtmlWebpackPlugin({
			hash: true,
			filename: '../../templates/index.html',
			template: 'src/main/resources/templates/index.template.html'
		}),
		new LodashModuleReplacementPlugin()
	]
};
