Ext.define('Moke.store.Company', {
	extend: 'Ext.data.Store',
	alias: 'store.company',
	autoLoad: true,
	autoSync: true,
	model: 'model.company',
	
	proxy : {
		type : 'rest',
		//url : 'http://localhost:8080/cms/company',
		reader: {
            type: 'json',
            rootProperty: 'data'
        },
        writer: {
            type: 'json'
        },
		api : {
			create : 'http://localhost:8080/cms/company/add',
			read : 'http://localhost:8080/cms/company/get', // 在调用Model的静态方法load时，会默认去这里查数据
			update : 'http://localhost:8080/cms/company/update',
			destroy : 'http://localhost:8080/cms/company/delete' // 在调用Model的erase方法（Ext5.0以前的版本是destroy方法，意思就是根据ID删除Model）
		},
		listeners : {
			exception : function(proxy, response, options) {
				try {
					var responseData = proxy.reader.getResponseData(response);
					if (responseData.meta.message) {
						var messageDescription = 'Information'; // title of the
																// alert box
						var messageIcon = Ext.MessageBox.INFO;
						if (!responseData.meta.success) {
							var messageDescription = 'Error';
							var messageIcon = Ext.MessageBox.ERROR;
						}

						Ext.MessageBox.show({
							title : messageDescription,
							msg : responseData.meta.message,
							buttons : Ext.MessageBox.OK,
							icon : messageIcon
						});
					}
				} catch (err) {
					console.log(err);
				}
			}
		}
	}
});