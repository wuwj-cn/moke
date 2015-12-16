Ext.define('moke.view.user.User', {
    extend: 'Ext.panel.Panel',
    xtype: 'view.main.user',
    
    requires: [
   		'moke.view.user.UserForm'
   	],
    
    width: '100%',
    layout: 'fit',
    
    items: [{
    	xtype: 'panel',
    	layout: 'border',
    	height: 600,
    	items: [{
    		region: 'north',
    		xtype: 'userform',
    		height: '50%'
    	}, {
    		region: 'center',
    		xtype: 'panel',
    		titleAlign: 'center',
    		title: 'panel',
    		border:true,
    		html: 'this is user center'
    	}]
    }]
});