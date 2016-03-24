Ext.define('Moke.view.dept.DeptController', {
	extend : 'Ext.app.ViewController',
	alias : 'controller.dept',

	onAdd : function(button, event) {
		var form = button.up('form').getForm();
//		form.findField('uuid').reset();
//		form.findField('code').reset();
//		form.findField('name').reset();
		form.reset();
	},

	onReset : function(button, event) {
		button.up('form').getForm().reset();
	},

	onSave : function(button, event) {
		var me = this, 
			formPanel = button.up('form'),
			tree = me.lookupReference('dept-tree');
		
		formPanel.getForm().submit({
			url : Moke.getApplication().baseURL + '/dept/save',
			waitMsg : '正在保存数据...',
			failure : function(form, action) {
				var result = Ext.decode(action.response.responseText);
				Ext.Msg.alert('Failure', result.data);
			},
			success : function(form, action) {
				var result = action.result.data;
				form.setValues(result);
				var items = tree.getSelection();
				tree.getStore().load({node: items[0]});
				Ext.Msg.alert('Sucess', '操作成功');
			}
		});
	},
	
	onItemClick : function(view, record, item, index, e, eOpts) {
		var me = this, 
		formPanel = me.lookupReference('dept-form'),
		form = formPanel.getForm();
		var deptCode = record.data.id;
		formPanel.getForm().load({
			url: Moke.getApplication().baseURL + '/dept/' + deptCode,
			waitMsg : '正在加载数据...',
			failure : function(form, action) {
				var result = Ext.decode(action.response.responseText);
				Ext.Msg.alert('Failure', result.data);
			},
			success : function(form, action) {
//				form.setValues(action.result.data);
			}
		});
	},
	onBeforeExpand: function(node, eOpts) {
		//this.proxy.url = this.proxy.url + node.raw.id;
	},
	onItemExpand: function(node, eOpts) {
//		console.log(node);
//		if(!node.hasChildNodes()) node.raw.laef = true;
	}

});