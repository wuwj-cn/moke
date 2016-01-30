Ext.define('Moke.view.company.CompanyController', {
	extend : 'Ext.app.ViewController',
	alias : 'controller.company',
	
	onReset: function(button, event){
		button.up('form').getForm().reset();
	}
});