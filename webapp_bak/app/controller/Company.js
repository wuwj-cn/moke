Ext.define('Moke.controller.Company', {
	extend : 'Ext.app.Controller',

	models : [ 'Company' ],
	//stores: ['Company'],
	
	// At this point things haven't rendered yet since init gets called on controllers before the launch function
    // is executed on the Application
    init: function() {
    	var me = this;
        me.control({
            'company button[action=save]': {
                click: me.onSave
            },
            'company button[action=search]': {
            	click: me.onLoad
            }
        });
    },

	onSave : function(button, event) {
		var me = this;
		var form = button.up('form').getForm();
		var company = me.getCompanyModel().create(form.getValues());
		var record = form.getRecord();
		//record.set(form.getValues());
		console.log(record);
		//this.getCompanyStore().sync();
		/*company.save({
			failure : function(record, operation) {
				// do something if the save failed
			},
			success : function(record, operation) {
				record.set('phone', '123456790');
				console.log(record.data);
				form.loadRecord(record);
			},
			callback : function(record, operation, success) {
				// do something whether the save succeeded or failed
			}
		});*/
	},

	onLoad : function(button, event) {
		// Ext.Msg.alert('info', 1);
		var me = this,
			form = button.up('form').getForm();
		var company = me.getCompanyModel().load();
		form.loadRecord(company);
	}
});