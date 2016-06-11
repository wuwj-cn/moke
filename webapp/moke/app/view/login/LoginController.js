Ext.define('Moke.view.login.LoginController', {
	extend: 'Ext.app.ViewController',
	alias: 'controller.login',
	
	control: {
		'button[text=登录]': {
			click: 'onLoginBtnClick'
		}
	},
	
	onLoginBtnClick: function(button, event) {
		var me = this, 
			formPanel = button.up('form');
	
		formPanel.getForm().submit({
			url : Moke.getApplication().baseURL + '/login',
			waitMsg : '正在登录...',
			failure : function(form, action) {
				var result = Ext.decode(action.response.responseText);
				Ext.Msg.alert('Failure', result.data);
			},
			success : function(form, action) {
				var result = action.result.data;
				Ext.Msg.alert('Sucess', '操作成功');
			}
		});
	}
});