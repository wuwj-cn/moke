/**
 * This class is the main view for the application. It is specified in app.js as the
 * "mainView" property. That setting automatically applies the "viewport"
 * plugin causing this view to become the body element (i.e., the viewport).
 *
 * TODO - Replace this content of this view to suite the needs of your application.
 */
Ext.define('Moke.view.main.Main', {
    extend: 'Ext.container.Viewport',
    xtype: 'app-main',

    requires: [
        'Ext.plugin.Viewport',
        'Ext.window.MessageBox',

        'Moke.view.main.MainController',
        'Moke.view.main.MainModel',
        'Moke.view.main.MenuTree'
    ],

    controller: 'main',
    viewModel: 'main',

    ui: 'navigation',
    layout: 'border',
    
//    tabBarHeaderPosition: 1,
//    titleRotation: 0,
//    tabRotation: 0,

    header: {
        layout: {
            align: 'stretchmax'
        },
        title: {
            bind: {
                text: '{name}'
            },
            flex: 0
        },
        iconCls: 'fa-th-list'
    },

//    tabBar: {
//        flex: 1,
//        layout: {
//            align: 'stretch',
//            overflowHandler: 'none'
//        }
//    },

//    responsiveConfig: {
//        tall: {
//            headerPosition: 'top'
//        },
//        wide: {
//            headerPosition: 'left'
//        }
//    },
//
//    defaults: {
//        bodyPadding: 20,
//        tabConfig: {
//            plugins: 'responsive',
//            responsiveConfig: {
//                wide: {
//                    iconAlign: 'left',
//                    textAlign: 'left'
//                },
//                tall: {
//                    iconAlign: 'top',
//                    textAlign: 'center',
//                    width: 120
//                }
//            }
//        }
//    },

    items: [{
		region: 'north',
		xtype: 'panel',
		height: 60,
		bind: {
			html: '{name}'
		}
	}, {
		region: 'west',
		reference: 'menu',
		title: '快捷菜单',
		xtype: 'menutree',
		//store: 'menuStore',
		autoScroll: true,
		split:true,
		animCollapse:false,
		width: 250,
		border:true,
		frame:false,
		minSize: 100,
		collapseMode:'mini',
		collapsible: true,
		margin:'0 0 0 0'
	}, {
		region: 'center',
		xtype: 'tabpanel',
		titleAlign: 'center',
		reference: 'contentpanel',
		//itemId: 'contentpanel',
		width: 200,
		minSize: 100,
		border:true
	}]
});
