/**
 * This example shows how to use basic data binding. The panel title, the content and the
 * button text are all pulled from the view model.
 */
Ext.define('Moke.view.main.Hello', {
    extend: 'Ext.panel.Panel',
    xtype: 'binding-hello-world',
    width: '100%',
    height: 400,
    //bodyPadding: 10,
    layout: 'border',
    
    items: [{
		region: 'north',
		xtype: 'panel',
		height: '30%',
		border: true,
		html: 'this is hello head'
	}, {
		region: 'center',
		xtype: 'panel',
		titleAlign: 'center',
		title: 'panel',
		border:true,
		html: 'this is hello center'
	}]
});