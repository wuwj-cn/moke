Ext.define('moke.view.user.UserForm', {
	extend: 'Ext.form.Panel',
	xtype: 'userform',
	
	//controller: 'user',
	viewModel: {
		type: 'user'
	},
    bodyPadding: 5,
    url: 'save-form.php',
    //layout: 'column',
    
    //collapsible: true,  //可折叠
    autoScroll: true,   //自动创建滚动条
    
    defaults: {
        anchor: '100%'
    },
    fieldDefaults: {
        labelWidth: 80,
        labelAlign: "top",
        flex: 1,
        margin: 5
    },
    
    defaultType: 'textfield',
    items: [ {
        xtype: "container",
        layout: "hbox",
        items: [
            { xtype: "textfield", name: "name", fieldLabel: "姓名", allowBlank: false },
            { xtype: "numberfield", name: "age", fieldLabel: "年龄", decimalPrecision: 0}
        ]
    },{
        xtype: "container",
        layout: "hbox",
        items: [
            { xtype: "textfield", name: "phone", fieldLabel: "电话", allowBlank: false, emptyText: "电话或手机号码" },
            { xtype: "textfield", name: "phone", fieldLabel: "邮箱", allowBlank: false, emptyText: "Email地址", vtype: "email" }
        ]
    },{
        xtype: "textareafield",
        name: "remark",
        fieldLabel: "备注",
        height: 50
    }],

    buttons: [{
        text: 'Reset',
        handler: function() {
            this.up('form').getForm().reset();
        }
    }, {
        text: 'Submit',
        formBind: true, //only enabled once the form is valid
        disabled: true,
        handler: function() {
            var form = this.up('form').getForm();
            if (form.isValid()) {
                form.submit({
                    success: function(form, action) {
                       Ext.Msg.alert('Success', action.result.msg);
                    },
                    failure: function(form, action) {
                        Ext.Msg.alert('Failed', action.result.msg);
                    }
                });
            }
        }
    }]
});