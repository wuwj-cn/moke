Ext.define('Moke.view.dept.Dept', {
//	extend : 'Ext.container.Viewport',
	extend: 'Ext.panel.Panel',
	alias: 'widget.dept',
	
	layout: 'border',
	height: 600,
	
	items: [{
		region: 'west',
		xtype: 'treepanel',
		width: 250,
		height: '100%',
		border: true
	}, {
		region: 'center',
		xtype: 'panel',
		height: '60%',
		border:true
	}]
});