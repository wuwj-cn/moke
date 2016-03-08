Ext.define('Moke.view.dept.DeptTree', {
	extend : 'Ext.tree.Panel',
	xtype : 'dept-tree',

	requires : [ 'Moke.store.Menu' ],

	border : false,
	hrefTarget : 'contentpanel',
	rootVisible : true,
	store : {
		type: 'menu',
		proxy: {
			type: 'ajax',
			url : 'data/menus.json',
			reader : {
				type : 'json'
			}
		}
	},
	listeners: {
		itemclick: 'onItemClick'
	}
});