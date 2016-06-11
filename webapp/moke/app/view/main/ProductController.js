Ext.define('Moke.view.main.ProductController', {
	extend: 'Ext.app.ViewController',
	alias: 'controller.product',
	
	control: {
		'button[text=查看产品]': {
			tap: 'onButtonTap'
		}
	},
	
	onButtonTap: function(cm, e, opts) {
		Ext.Msg.alert('查看产品');
	}
});