Ext.define('Moke.view.company.Company', {
	extend : 'Ext.form.Panel',
	//xtype : 'view.company',
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
	//url : 'save-form.php',
	// layout: 'column',

	// collapsible: true, //可折叠
	autoScroll : true, // 自动创建滚动条

	defaults : {
		anchor : '95%'
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
	} ],

	buttons : [ {
		text : '查询',
		action: 'search'
	}, {
		text : '重置',
		handler : 'onReset'
	}, {
		text : '保存',
		action : 'save'
	} ],
	
	listeners: {
		//afterrender: 'onLoad'
	}
});