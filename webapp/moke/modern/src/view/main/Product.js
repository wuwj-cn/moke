Ext.define('Moke.view.main.Product', {
	extend: 'Ext.Container',
	xtype: 'product',
	requires: [],
	
	controller: 'product',
	
	items: [{
		xtype: 'button',
		text: '查看产品',
		centered: true
	}]
});