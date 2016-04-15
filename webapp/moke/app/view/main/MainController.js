Ext.define('Moke.view.main.MainController', {
	extend: 'Ext.app.ViewController',
	alias: 'controller.main',
	
	config: {
		
	},
	
	init: function(){
		var me = this,
			items = me.lookupReference('mainContent').items;
		me.cacheContent['首页'] = items.getAt(0);
	},
	
	cacheContent: {},
	
	control: {
		'segmentedbutton': {
			toggle: 'onButtonToggle'
		}
	},
	
	onButtonToggle: function(container, button, pressed) {
		var me = this;
		if(pressed == true){
			var key = button.getText(),
				main = me.lookupReference('mainContent'),
				item = me.cacheContent[key];
			if(item) {
				main.setActiveItem(item);
			} else {
				console.log(key);
			}
		}
	}
});