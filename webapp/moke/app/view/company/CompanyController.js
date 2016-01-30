Ext.define('Moke.view.company.CompanyController', {
	extend : 'Ext.app.ViewController',
	alias : 'controller.company',
	
	onReset: function(button, event){
		button.up('form').getForm().reset();
	},
	
	onSave : function(button, event) {
		var me = this,
			form = button.up('form').getForm(),
			record = form.getRecord(),
			values = form.getValues(),
			store = me.getStore('company');
//		if(record) {
//			console.log("=====1=====" + Ext.JSON.encode(record));
//			record.set(values);
//		} else {
//			record = Ext.create('Moke.model.Company', values);
//		}
//		console.log("=====2=====" + Ext.JSON.encode(record));
//		record.save({
//			failure : function(record, operation) {
//				// do something if the save failed
//			},
//			success : function(record, operation) {
//				form.loadRecord(record);
//			},
//			callback : function(record, operation, success) {
//				// do something whether the save succeeded or failed
//			}
//		});
		
		if (form.isValid()) {
            form.submit({
            	url : 'http://localhost:8080/cms/company/add',
                success: function(form, action) {
                   Ext.Msg.alert('Success', action.result.msg);
                },
                failure: function(form, action) {
                    Ext.Msg.alert('Failed', action.result.msg);
                }
            });
        }
//		store.add(record);
//		store.sync({
//			success : function(a, b,c,d,e, operation) {
//				record.set('phone', '123456790');
//				console.log(record.data);
//				form.loadRecord(record);
//			}
//		});
	},

	onLoad : function(button, event) {
		// Ext.Msg.alert('info', 1);
		var me = this,
			form = button.up('form').getForm();
		var company = me.getCompanyModel().load();
		form.loadRecord(company);
	}
});