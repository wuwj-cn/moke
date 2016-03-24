Ext.define('Moke.view.role.RoleGrid', {
	extend : 'Ext.grid.Panel',
	xtype : 'role-grid',

	requires: ['Moke.store.RoleGrid'],
	
	title : '角色列表',
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
				text : '{code}'
			},
			sortable: true,
			flex: 1,
			dataIndex : "code"
		}, {
			bind : {
				text : '{name}'
			},
			sortable: true,
			flex: 1,
			dataIndex : 'name'
		} ]
	},
	initComponent: function() {
    	this.store = Ext.create('Moke.store.RoleGrid');
//		this.store = Ext.data.StoreManager.lookup('role-grid');
		this.callParent();
    },
    listeners: {
    	rowclick: 'onRowClick'
    }
});