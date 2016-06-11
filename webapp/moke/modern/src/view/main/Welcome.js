Ext.define('Moke.view.main.Welcome', {
	extend: 'Ext.carousel.Carousel',
	
	items: [{
		html: 'welcome',
		style: 'background-color:#5ab5f5'
	}, {
		html: 'show',
		style: 'background-color:#5ab5f5'
	}, {
		layout: 'vbox',
		xtyle: 'backgound-color:#5ab5f5;padding-bottom:10px;',
		items: [{
			html: '应用程序的特性',
			flex: 1
		}, {
			xtype: 'button',
			text: '进入应用程序',
			height: 30,
			ui: 'action',
			handler: function(){
				console.log('123....');
			}
		}]
	}]
});