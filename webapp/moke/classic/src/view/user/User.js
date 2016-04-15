Ext.define('Moke.view.user.User', {
	extend : 'Ext.panel.Panel',
	alias : 'widget.user',
	
	controller : {
		type : 'user'
	},
	viewModel : {
		type : 'user'
	},
	
	layout : 'border',
	height : 600,

	items : [ {
		region : 'north',
		xtype : 'user-form',
		reference: 'user-form',
		height : '25%',
		border : true
	}, {
		region : 'center',
		xtype : 'user-list',
		reference: 'user-list',
		height : '75%',
		border : true
	} ]
});