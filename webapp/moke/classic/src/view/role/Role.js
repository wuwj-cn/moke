Ext.define('Moke.view.role.Role', {
	extend : 'Ext.panel.Panel',
	alias : 'widget.role',
	
	requires : ['Moke.view.role.RoleForm', 'Moke.view.role.RoleGrid' ],

	controller : {
		type : 'role'
	},
	viewModel : {
		type : 'role'
	},
	
	layout : 'border',
	height : 600,

	items : [ {
		region : 'north',
		xtype : 'role-form',
		reference: 'role-form',
		height : '20%',
		border : true
	}, {
		region : 'center',
		xtype : 'role-grid',
		reference: 'role-grid',
		height : '80%',
		border : true
	} ]
});