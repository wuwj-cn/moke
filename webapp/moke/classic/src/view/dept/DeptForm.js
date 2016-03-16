Ext.define('Moke.view.dept.DeptForm', {
	extend : 'Ext.form.Panel',
	xtype : 'dept-form',

	border : true,
//	title: '部门信息',
//	width : 400,
//	height : 300,

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
		name : "code",
		bind : {
			fieldLabel : '{code}'
		},
		allowBlank : false
	}, {
		name : "name",
		bind : {
			fieldLabel : "{name}"
		},
		allowBlank : false
	}, {
		name : "parentCode",
		fieldLabel : "上级节点",
		allowBlank : false
	}, {
		name : 'uuid',
		hidden : true
	} ],

	tbar : [{
		text : '增加',
		glyph : 0xf067,
		handler : 'onAdd'
	}, {
		text : '保存',
		glyph : 0xf0c7,
		formBind : true,
		disabled : true,
		handler : 'onSave'
	} ]
});