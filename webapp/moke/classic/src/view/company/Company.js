Ext.define('Moke.view.company.Company', {
	extend : 'Ext.form.Panel',
	alias: 'widget.company',

	controller : {
		type : 'company'
	},
	viewModel : {
		type : 'company'
	},

	bodyPadding : 20,
	border : true,
	width : 400,
	height : 300,
	// layout: 'column',

	// collapsible: true, //可折叠
	autoScroll : true, // 自动创建滚动条

	defaults : {
		anchor : '95%',
		readOnly: true
	},
	fieldDefaults : {
		labelWidth : 80,
		labelAlign : "left",
		flex : 1,
		margin : 5
	},

	defaultType : 'textfield',
	items : [ {
		name : "name",
		bind: {
			fieldLabel : '{name}'
		},
		allowBlank : false
	}, {
		name : "phone",
		bind: {
			fieldLabel : "{phone}"
		},
		emptyText : '电话或手机号码',
		allowBlank : false
	}, {
		name : "email",
		fieldLabel : "邮箱",
		allowBlank : false,
		emptyText : "Email地址",
		vtype : "email"
	}, {
		name: 'uuid',
		hidden: true
	} ],

	buttons : [{
		text : '查询',
		handler : 'onLoad'
	}, {
		text : '编辑',
		handler : 'onEdit'
	}, {
		text : '重置',
		handler : 'onReset'
	}, {
		text : '保存',
		formBind: true,
		disabled: true,
		handler: 'onSave'
	} ],
	
	listeners: {
		//afterrender: 'onLoad'
	}
});