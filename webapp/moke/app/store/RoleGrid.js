Ext.define('Moke.store.RoleGrid', {
	extend: 'Ext.data.Store',
	alias: 'store.role-grid',
	storeId: 'role-grid',
	
	fields:[ 'uuid', 'code', 'name'],
	
	autoLoad: true,
	
	proxy: {
		type: 'rest',
		api : {
			read: 'http://localhost:8080/cms' +　'/role/list'
		},
		reader : {
			type : 'json',
			rootProperty: 'data'
		}
	}
	
});