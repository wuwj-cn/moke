Ext.define('Moke.view.user.UserModel', {
	extend : 'Ext.app.ViewModel',
	alias : 'viewmodel.user',

	data : {
		username : '用户名',
		password : '密码',
		dept: '所属部门',
		role: '角色分组',
		nickname: '姓名'
	}
});