Ext.define('moke.model.Menu', {
    extend: 'Ext.data.TreeModel',
    
    fields: [
        { name: 'id', type: 'string' },
        { name: 'text', type: 'string' },
        //{ name: 'url', type: 'string' },
        { name: 'leaf', type: 'boolean', defaultValue: true }
    ]
});
