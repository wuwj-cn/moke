Ext.define('Moke.view.role.RoleForm', {
	extend : 'Ext.form.Panel',
	xtype : 'role-form',

//	border : false,
	autoScroll : true, // 自动创建滚动条
	split : true,
	// layout : 'fit',
	defaults : {
		anchor : '95%'
	},

	items : [ {
		xtype : 'fieldcontainer',
		layout : {
			type : 'hbox',
			align : 'stretch'
		},
		defaults : {
			labelWidth : 80,
			labelAlign : 'right'
		},
		defaultType : 'textfield',
		items : [ {
			name : "code",
			bind : {
				fieldLabel : '{code}'
			},
			allowBlank : false,
			flex: 1
		}, {
			name : "name",
			bind : {
				fieldLabel : "{name}"
			},
			allowBlank : false,
			flex: 1
		}, {
			name : 'uuid',
			hidden : true
		} ]
	} ],

	tbar : [ {
		text : '增加',
		iconCls: 'x-fa fa-plus-circle',
		handler : 'onAdd'
	}, {
		text : '保存',
		iconCls: 'x-fa fa-save',
		formBind : true,
		disabled : true,
		handler : 'onSave'
	} ]
});