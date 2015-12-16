Ext.define('moke.view.user.UserModel', {
	extend: 'Ext.app.ViewModel',
	alias: 'viewmodel.user',
	
	data: {
		firstName: 'John',  
        lastName: 'Doe'  
	},
	
	formulas: {  
        // We'll explain formulas in more detail soon.  
        name: function (get) {  
            var fn = get('firstName'), ln = get('lastName');  
            return (fn && ln) ? (fn + ' ' + ln) : (fn || ln || '');  
        }  
    }  
});