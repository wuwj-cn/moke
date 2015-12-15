Ext.define('moke.view.main.Viewport', {
	extend: 'Ext.container.Viewport',
	xtype: 'app-main',
	
	requires: [
	    //'Ext.window.MessageBox',
		'moke.view.main.ViewportController',
        'moke.view.main.ViewportModel',
        'moke.view.main.MenuTree'
	],
	
	controller: 'viewport',
	viewModel: 'viewport',
	
	//cls: 'sencha-dash-viewport',
	
	layout: 'border',
	
	listeners: {
		//afterrender: 'onMainViewRender'
	},
	
	items: [{
		region: 'north',
		xtype: 'panel',
		height: 60,
		bind: {
			html: '{name}'
		}
	}, {
		region: 'west',
		reference: 'menu',
		title: '快捷菜单',
		xtype: 'menutree',
		//store: 'menuStore',
		autoScroll: true,
		split:true,
		animCollapse:false,
		width: 250,
		border:true,
		frame:false,
		minSize: 100,
		collapseMode:'mini',
		collapsible: true,
		margin:'0 0 0 0'
	}, {
		region: 'center',
		xtype: 'tabpanel',
		titleAlign: 'center',
		reference: 'contentpanel',
		//itemId: 'contentpanel',
		width: 200,
		minSize: 100,
		border:true
	}]
});