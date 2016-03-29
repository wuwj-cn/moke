Ext.define('Moke.view.user.UserGrid', {
	extend : 'Ext.grid.Panel',
	xtype : 'user-grid',

	requires: ['Moke.store.RoleGrid'],
	
	title : '用户列表',
	loadMask : {
		msg : '拼命加载中...'
	},
	autoLoad : true,
	stripeRows : true,
	animCollapse : false,
	collapsible : false,
	border : false,
	split : true,
	viewConfig : {
		forceFit : true
	},
	columns : {
		items : [ {
			xtype : 'rownumberer'
		}, {
			bind : {
				text : '{username}'
			},
			sortable: true,
			flex: 1,
			dataIndex : "username"
		}, {
			bind : {
				text : '{nickname}'
			},
			sortable: true,
			flex: 1,
			dataIndex : 'nickname'
		} ]
	},
	initComponent: function() {
    	this.store = Ext.create('Moke.store.RoleGrid');
		this.callParent();
    },
    listeners: {
    	rowclick: 'onRowClick'
    }
});