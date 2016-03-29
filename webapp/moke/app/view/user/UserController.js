Ext.define('Moke.view.user.UserController', {
	extend : 'Ext.app.ViewController',
	alias : 'controller.user',

	onAdd : function(button, event) {
		var form = button.up('form').getForm();
		form.reset();
	},

	onSave : function(button, event) {
		var me = this, 
			formPanel = button.up('form'),
			gridPanel = me.lookupReference('role-grid');
		
		formPanel.getForm().submit({
			url : Moke.getApplication().baseURL + '/role/save',
			waitMsg : '正在保存数据...',
			failure : function(form, action) {
				var result = Ext.decode(action.response.responseText);
				Ext.Msg.alert('Failure', result.data);
			},
			success : function(form, action) {
				var result = action.result.data;
				form.setValues(result);
				gridPanel.getStore().reload();
				Ext.Msg.alert('Sucess', '操作成功');
			}
		});
	},
	
	onRowClick: function(view, record, tr, rowIndex, e, eOpts){
		var me = this, 
		formPanel = me.lookupReference('role-form');
		formPanel.getForm().setValues(record.data);
	}
});