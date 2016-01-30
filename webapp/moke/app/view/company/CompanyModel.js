Ext.define('Moke.view.company.CompanyModel', {
	extend : 'Ext.app.ViewModel',
	alias : 'viewmodel.company',
	requires : [ 'Moke.model.Company' ],

	stores : {
		company : {
			model : 'Moke.model.Company',
			autoLoad: false
		}
	},

	data : {
		name : '公司名称',
		phone : '电话',
		phome_empty_text : '电话或手机号码'
	}
});