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
			read: 'http://localhost:8080/cms/dept/tree'
		},
		reader : {
			type : 'json',
			rootProperty: 'data'
		}
	},
	initComponent : function() {
//		Ext.Ajax.request({
//			url: 'http://localhost:8080/cms/dept/tree/company',
//			success: function(response, opts) {
//				var result = Ext.decode(response.data);
//		        var root = {
//		    		id: result.id,
//		    		text : result.text,
//		    		leaf : false,
//		    		expanded : false
//		    	}
//				this.setRoot(root);
//		     },
//		     failure: function(response, opts) {
//		    	 
//		     }
//		});
		console.log('dept tree store init...');
		this.callParent();
	}
});