/**
 * This class is the controller for the main view for the application. It is specified as
 * the "controller" of the Main view class.
 *
 * TODO - Replace this content of this view to suite the needs of your application.
 */
Ext.define('Moke.view.main.MainController', {
    extend: 'Ext.app.ViewController',

    alias: 'controller.main',

    onItemSelected: function (sender, record) {
        Ext.Msg.confirm('Confirm', 'Are you sure?', 'onConfirm', this);
    },

    onConfirm: function (choice) {
        if (choice === 'yes') {
            Ext.Msg.alert('Info', 'yes button is click!')
        }
    },
    
    createTab: function (prefix, rec, cfg) {
		if(!rec.data.leaf) return ;
        var tabs = this.lookupReference('contentpanel'),
            id = prefix + '_' + rec.getId(),
            tab = tabs.items.getByKey(id);

        if (!tab) {
            cfg.itemId = id;
            cfg.title = rec.data.text;
            cfg.closable = true;
            cfg.tabTip = rec.data.text;
            tab = tabs.add(cfg);
        }

        tabs.setActiveTab(tab);
    },

	onItemClick : function(view, record, item, index, e, eOpts) {
		//Ext.Msg.alert('提示', record.data.url);
		//console.log('url: ' + record.data.url);
		this.createTab('Moke', record, {
            session: true,
            items: [{
            	xtype: record.data.url
            }]
        });
	}
});
