Ext.define('Moke.view.company.CompanyController', {
	extend : 'Ext.app.ViewController',
	alias : 'controller.company',

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
		var me = this, formPanel = button.up('form');

		formPanel.getForm().submit({
			url : 'http://localhost:8080/cms/company/save',
			waitMsg : '正在保存数据...',
			failure : function(form, action) {
				var result = Ext.decode(action.response.responseText);
				Ext.Msg.alert('Failure', result.data);
			},
			success : function(form, action) {
				form.setValues(action.result.data)
				Ext.each(formPanel.items.items, function(item) {
					item.setReadOnly(true);
				});
				Ext.Msg.alert('Sucess', '操作成功');
			}
		});
		/*
		 * if(record) { record.set(values); } else { record =
		 * Ext.create('Moke.model.Company', values); } record.save({ failure :
		 * function(record, operation) { // do something if the save failed },
		 * success : function(record, operation) { form.loadRecord(record);
		 * Ext.Msg.alert('操作成功'); }, callback : function(record, operation,
		 * success) { // do something whether the save succeeded or failed } });
		 */
	},

	onLoad : function(button, event) {
		var me = this, formPanel = button.up('form');
		formPanel.getForm().load({
			url : 'http://localhost:8080/cms/company/get',
			waitMsg : '拼命加载中...',
			success : function(form, action) {
				// Ext.Msg.alert('Sucess', '操作成功');
				Ext.each(formPanel.items.items, function(item) {
					item.setReadOnly(true);
				});
			},
			failure : function(form, action) {
				var result = Ext.decode(action.response.responseText);
				Ext.Msg.alert('Failure', result.data);
			}
		});
		/*
		 * if(company) { company.set(values); form.loadRecord(company); } else {
		 * company = Ext.create('Moke.model.Company'); company.load({ params:
		 * {name: '11'}, scope: this, failure: function(record, operation) { //
		 * do something if the load failed }, success: function(record,
		 * operation) { form.loadRecord(record); }, callback: function(record,
		 * operation, success) { // do something whether the load succeeded or
		 * failed } }); }
		 */
	}
});