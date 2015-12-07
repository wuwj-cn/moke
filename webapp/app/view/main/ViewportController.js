Ext.define('moke.view.main.ViewportController', {
	extend: 'Ext.app.ViewController',
	alias: 'controller.viewport',
	
	init: function(view){
		var me = this;
		//view.on('afterrender', me.initLogPanel, view);
	},
	
	onMainViewRender: function(){
		 Ext.Msg.confirm('Confirm', 'Are you sure?', 'onConfirm', this);
	},
	
	onConfirm: function (choice) {
        if (choice === 'yes') {
            //
        	this.getView().fireEvent('afterrender');
        }
    }
});