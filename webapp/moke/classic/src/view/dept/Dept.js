Ext.define('Moke.view.dept.Dept', {
	extend : 'Ext.panel.Panel',
	alias : 'widget.dept',

	requires : ['Moke.view.dept.DeptTree', 'Moke.view.dept.DeptForm' ],

	controller : {
		type : 'dept'
	},
	viewModel : {
		type : 'dept'
	},
	
	layout : 'border',
	height : 400,

	items : [ {
		region : 'west',
		xtype : 'dept-tree',
		reference: 'dept-tree',
		width : 250,
		height : '100%',
		border : true
	}, {
		region : 'center',
		xtype : 'dept-form',
		reference: 'dept-form',
		height : '100%',
		border : true
	} ]
});