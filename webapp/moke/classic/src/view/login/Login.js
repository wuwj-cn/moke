Ext.define('Moke.view.login.Login', {
	extend: 'Ext.form.Panel',
	xtype: 'login-form',
	
	controller: 'login',
	
	frame:true,  
    title: '用户登陆',  
	border : true,
//	width : 400,
	
	defaults : {
		anchor : '95%'
	},
	fieldDefaults : {
		labelWidth : 80,
		labelAlign : 'left',
		flex : 1,
		margin : 5
	},
	
	items: [{
		xtype: 'textfield',
		name: 'username',
		fieldLabel : '用户名',
		allowBlank : false
	}, {
		xtype: 'textfield',
		inputType: 'password',
		name: 'password',
		fieldLabel : '密码',
		allowBlank : false
	}],
	
	buttons : [{
		text : '登录',
		formBind: true,
		disabled: true
	}]
});