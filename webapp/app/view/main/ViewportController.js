Ext.define('moke.view.main.ViewportController', {
	extend : 'Ext.app.ViewController',
	alias : 'controller.viewport',

	init : function(view) {
		var me = this;
		// view.on('afterrender', me.initLogPanel, view);
	},

	onMainViewRender : function() {
		Ext.Msg.confirm('Confirm', 'Are you sure?', 'onConfirm', this);
	},

	onConfirm : function(choice) {
		if (choice === 'yes') {
			this.getView().fireEvent('afterrender');
		}
	},
	
	createTab: function (prefix, rec, cfg) {
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
		console.log('url: ' + record.data.url);
		this.createTab('moke', record, {
            session: true,
            items: [{
            	xtype: record.data.url
            }]
        });
	}
});