Ext.define('Moke.store.Menu', {
	extend : 'Ext.data.TreeStore',
	alias : 'store.menu',

	root : {
		text : '系统菜单',
		leaf : false,
		expanded : false
	}
});
