Ext.define('Moke.store.UserGrid', {
	extend: 'Ext.data.Store',
	alias: 'store.user-grid',
	storeId: 'user-grid',
	
	fields:[ 'uuid', 'username', 'nickname', 'deptCode'],
	
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