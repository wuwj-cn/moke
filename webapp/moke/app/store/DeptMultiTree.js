Ext.define('Moke.store.DeptMultiTree', {
	extend : 'Ext.data.TreeStore',
	alias : 'store.dept-multitree',
	
//	model: 'Moke.model.DeptTree',
	
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
			read: 'http://localhost:8080/cms' + '/dept/multitree'
		},
		reader : {
			type : 'json',
			rootProperty: 'data'
		}
	}
});
