Ext.define('Moke.view.dept.DeptTree', {
	extend : 'Ext.tree.Panel',
	xtype : 'dept-tree',

	requires: [
	    'Moke.store.DeptTree'
	],
	hrefTarget : '',
	collapsible: true,
    useArrows: true,
    rootVisible: true,
    multiSelect: true,
    store: Ext.create('Moke.store.DeptTree'),
	listeners: {
		itemclick: 'onItemClick',
		beforeexpand: 'onBeforeExpand',
		itemexpand: 'onItemExpand'
	}
});