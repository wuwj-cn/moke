Ext.define('Moke.view.user.UserForm', {
	extend : 'Ext.form.Panel',
	xtype : 'user-form',

	// requires: ['Ext.ux.TreePicker'],

	border : false,
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
			name : "username",
			bind : {
				fieldLabel : '{username}'
			},
			allowBlank : false,
			flex : 1
		}, {
			name : "nickname",
			bind : {
				fieldLabel : "{nickname}"
			},
			allowBlank : false,
			flex : 1
		}, {
			name : 'uuid',
			hidden : true
		} ]
	}, {
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
			xtype : 'treepicker',
			name : "deptCode",
			bind : {
				fieldLabel : "{dept}"
			},
			allowBlank : false,
			flex : 1,
			displayField : 'text',
			value : 'id',
			rootVisible: false,
			store : Ext.create('Moke.store.DeptTree')
		}, {
			xtype : 'tagfield',
			name : "roleCode",
			bind : {
				fieldLabel : "{role}"
			},
			allowBlank : false,
			flex : 1,
			displayField : 'name',
			valueField : 'code',
			queryMode: 'local',
	        filterPickList: true,
			store : Ext.create('Moke.store.RoleGrid')
		} ]
	} ],

	tbar : [ {
		text : '增加',
		iconCls : 'x-fa fa-plus-circle',
		handler : 'onAdd'
	}, {
		text : '保存',
		iconCls : 'x-fa fa-save',
		formBind : true,
		disabled : true,
		handler : 'onSave'
	} ]
});