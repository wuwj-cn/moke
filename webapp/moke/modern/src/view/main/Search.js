Ext.define('Moke.view.main.Search', {
	extend: 'Ext.Container',
	xtype: 'search',
	requires: [],
	
	items: [{
		xtype: 'toolbar',
		docked: 'top',
		items: [{
			xtype: 'textfield',
			label: '搜索'
		}, {
			html: '搜索',
			centered: true
		}]
	}]
});