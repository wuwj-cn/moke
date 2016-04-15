Ext.define('Moke.store.DeptTree', {
	extend : 'Ext.data.TreeStore',
	alias : 'store.dept-tree',
	
	model: 'Moke.model.DeptTree',
	
	autoLoad: true,
	
	root: {
		id: '0',
		text: '莫克工作室',
		expanded: true,
		leaf: false
	},

	proxy: {
		type: 'rest',
		api : {
			read: 'http://localhost:8080/sys' + '/dept/tree'
		},
		reader : {
			type : 'json',
			rootProperty: 'data'
		}
	}
});
