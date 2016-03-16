Ext.define('Moke.view.dept.DeptController', {
	extend : 'Ext.app.ViewController',
	alias : 'controller.dept',

	onEdit : function(button, event) {
		var formPanel = button.up('form');
		Ext.each(formPanel.items.items, function(item) {
			// item.setDisabled(true)
			item.setReadOnly(false);
		});
	},

	onReset : function(button, event) {
		button.up('form').getForm().reset();
	},

	onSave : function(button, event) {
		var me = this, 
			formPanel = button.up('form'),
			tree = this.lookupReference('dept-tree');
		
		formPanel.getForm().submit({
			url : 'http://localhost:8080/cms/dept/save',
			waitMsg : '正在保存数据...',
			failure : function(form, action) {
				var result = Ext.decode(action.response.responseText);
				Ext.Msg.alert('Failure', result.data);
			},
			success : function(form, action) {
				form.setValues(action.result.data);
				var items = tree.getSelection();
				console.log(items[0]);
//				tree.expandNode(items[0]);
				tree.getStore().load({node: items[0]});
				Ext.Msg.alert('Sucess', '操作成功');
			}
		});
	},
	
	onItemClick : function(view, record, item, index, e, eOpts) {
		console.log('onItemClick');
	},
	onBeforeExpand: function(node, eOpts) {
		//this.proxy.url = this.proxy.url + node.raw.id;
	},
	onItemExpand: function(node, eOpts) {
//		console.log(node);
//		if(!node.hasChildNodes()) node.raw.laef = true;
	}

});