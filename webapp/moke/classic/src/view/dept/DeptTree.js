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
	initComponent: function() {
    	console.log('dept tree panel init...');
    	this.store = Ext.create('Moke.store.DeptTree');
		this.callParent();
    },
	listeners: {
		itemclick: 'onItemClick',
		beforeexpand: 'onBeforeExpand',
		itemexpand: 'onItemExpand'
	}
});