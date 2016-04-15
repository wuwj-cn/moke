Ext.define('Moke.store.UserList', {
	extend: 'Ext.data.Store',
	alias: 'store.user-list',
	storeId: 'user-list',
	
	fields:[ 'uuid', 'username', 'nickname', 'deptCode', 'roleCode'],
	
	autoLoad: true,
	
	proxy: {
		type: 'rest',
		api : {
			read: 'http://localhost:8080/sys' +　'/user/list'
		},
		reader : {
			type : 'json',
			rootProperty: 'data'
		}
	}
	
});