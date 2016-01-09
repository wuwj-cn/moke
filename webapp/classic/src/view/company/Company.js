Ext.define('Moke.view.company.Company', {
	extend: 'Ext.form.Panel',
	xtype: 'view.company',
	
	/*
	 * viewModel: { type: 'user' },
	 */
	
	bodyPadding: 20,
	border: true,
	width: 400,
	height: 300,
    url: 'save-form.php',
    // layout: 'column',
    
    // collapsible: true, //可折叠
    autoScroll: true,   // 自动创建滚动条
    
    defaults: {
        anchor: '95%'
    },
    fieldDefaults: {
        labelWidth: 80,
        labelAlign: "left",
        flex: 1,
        margin: 5
    },
    
    defaultType: 'textfield',
    items: [
    	{ name: "name", fieldLabel: "公司名称", allowBlank: false },
    	{ name: "phone", fieldLabel: "电话", allowBlank: false, emptyText: "电话或手机号码" },
        { name: "email", fieldLabel: "邮箱", allowBlank: false, emptyText: "Email地址", vtype: "email" }
    ],
    
    buttons: [{
    	text: '重置',
        handler: function() {
            this.up('form').getForm().reset();
        }
    }, {
    	text: '保存',
        handler: function() {
        	Ext.Msg.alert('提示', '123');
        }
    }]
});