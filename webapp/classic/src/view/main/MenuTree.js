Ext.define('moke.view.main.MenuTree', {
	extend : 'Ext.tree.Panel',
	xtype : 'menutree',

	requires : [ 'moke.store.Menu' ],

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