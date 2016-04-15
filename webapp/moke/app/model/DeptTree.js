Ext.define('Moke.model.DeptTree', {
	extend: 'Ext.data.TreeModel',
	alias: 'model.dept-tree',
    fields: [
        { name: 'id', type: 'string' },
        { name: 'text', type: 'string' },
        { name: 'qtip', type: 'string' },
        { name: 'iconCls', type: 'string' },
        { name: 'href', type: 'string' },
        { name: 'hrefTarget', type: 'string' },
        { name: 'expanded',  type: 'boolean', defaultValue: true },
        { name: 'leaf', type: 'boolean', defaultValue: true }
    ]
});