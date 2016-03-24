/**
 * The main application class. An instance of this class is created by app.js when it
 * calls Ext.application(). This is the ideal place to handle application launch and
 * initialization details.
 */
Ext.define('Moke.Application', {
    extend: 'Ext.app.Application',
    
    name: 'Moke',
    baseURL: 'http://localhost:8080/cms',

    requires : [ 
                'Ext.app.*', 
//                'Ext.state.CookieProvider',
//     			'Ext.window.MessageBox', 
     			'Moke.*' ],
     			
    stores: [
        // TODO: add global / shared stores here
    ],
    
    init : function() {
//		if ('nocss3' in Ext.Object.fromQueryString(location.search)) {
//			Ext.supports.CSS3BorderRadius = false;
//			Ext.getBody().addCls('x-nbr x-nlg');
//		}
//
//		// Set the default route to start the application.
//		this.setDefaultToken('all');
//
////		Ext.setGlyphFontFamily('Pictos');
////		Ext.setGlyphFontFamily('FontAwesome');
//
//		if (!Ext.platformTags.test) {
////			Ext.state.Manager.setProvider(Ext.create('Ext.state.CookieProvider'));
//		}
	},
    
    launch: function () {
        // TODO - Launch the application
    },

    onAppUpdate: function () {
        Ext.Msg.confirm('Application Update', 'This application has an update, reload?',
            function (choice) {
                if (choice === 'yes') {
                    window.location.reload();
                }
            }
        );
    }
});
