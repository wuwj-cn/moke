package com.moke.core.service.impl;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.support.ApplicationObjectSupport;

import com.moke.core.dao.Dao;
import com.moke.core.service.Manager;


/**
 * Base class for Business Services - use this class for utility methods and
 * generic CRUD methods.
 */
public class BaseManager extends ApplicationObjectSupport implements Manager {
    protected final transient Log log = LogFactory.getLog(getClass());
    protected Dao dao;
    
    /**
	 * 自动格式化(封装转型为BigDecimal及判断如果为null则设置为0的逻辑)
	 * @author weic
	 * @param obj 被格式化对象
	 * @return 格式化后对象
	 */
	protected BigDecimal format(Object obj){
		return obj == null ? new BigDecimal(0): (BigDecimal)obj;
	}
	
	/**
	 * 对非基本数据类型进行相加，集中null判断逻辑，简化调用层的代码，提高安全性
	 * @author weic
	 * @param a 第一个数据
	 * @param b 第二个数据
	 * @return 两个数据的和
	 */
	protected Object add(Object a, Object b){
		if(a instanceof Integer || b instanceof Integer){ //因为a,b可能为Null,因此用"或"而不是"且"
			a = (null == a)?new Integer(0):(Integer)a;
			b = (null == b)?new Integer(0):(Integer)b;
			return new Integer(((Integer)a).intValue() + ((Integer)b).intValue());
		}else if(a instanceof BigDecimal || b instanceof BigDecimal){
			a = (null == a)?new BigDecimal(0):(BigDecimal)a;
			b = (null == b)?new BigDecimal(0):(BigDecimal)b;
			return ((BigDecimal)a).add((BigDecimal) b);
		}else{
			throw new RuntimeException("无法正常相加");
		}
	}
	
	/**
	 * 对非基本数据类型进行相减，集中null判断逻辑，简化调用层的代码，提高安全性
	 * @author weic
	 * @param a 第一个数据
	 * @param b 第二个数据
	 * @return 两个数据的差
	 */
	protected Object sub(Object a, Object b){
		if(a instanceof Integer || b instanceof Integer){ //因为a,b可能为Null,因此用"或"而不是"且"
			a = (null == a)?new Integer(0):(Integer)a;
			b = (null == b)?new Integer(0):(Integer)b;
			return new Integer(((Integer)a).intValue() - ((Integer)b).intValue());
		}else if(a instanceof BigDecimal || b instanceof BigDecimal){
			a = (null == a)?new BigDecimal(0):(BigDecimal)a;
			b = (null == b)?new BigDecimal(0):(BigDecimal)b;
			return ((BigDecimal)a).subtract((BigDecimal) b);
		}else{
			throw new RuntimeException("无法正常相减");
		}
	}

    
	/**
     * @see com.icsshs.tlbtWeb.transmission.handler.Manager#setDao(com.icsshs.tlbtWeb.dao.Dao)
     */
    public void setDao(Dao dao) {
        this.dao = dao;
    }
    
	/**
     * @see com.icsshs.tlbtWeb.transmission.handler.Manager#getObject(java.lang.Class, java.io.Serializable)
     */
    public Object getObject(Class clazz, Serializable id) {
        return dao.getObject(clazz, id);
    }
    
    /**
     * @see com.icsshs.tlbtWeb.transmission.handler.Manager#getObjects(java.lang.Class)
     */
    public List getObjects(Class clazz) {
        return dao.getObjects(clazz);
    }
    
    /**
     * @see com.icsshs.tlbtWeb.transmission.handler.Manager#removeObject(java.lang.Class, java.io.Serializable)
     */
    public void removeObject(Class clazz, Serializable id) {
        dao.removeObject(clazz, id);
    }
    
    /**
     * @see com.icsshs.tlbtWeb.transmission.handler.Manager#saveObject(java.lang.Object)
     */
    public void saveObject(Object o) {
        dao.saveObject(o);
    }

	public void replicateObject(Object object) {
		dao.replicateObject(object);
	}
	
	public void replicateObjects(Collection objects) {
		dao.replicateObjects(objects);
	}



	


    public String getMessage(String msgKey) {
		String message = null;
		try {
			message = getMessageSourceAccessor().getMessage(msgKey, Locale.getDefault());
		} catch (NoSuchMessageException nsm) {
		    message = "???" + msgKey + "???";
		}
		return message;
    }

    public String getMessage(String msgKey, String arg) {
        return getMessage(msgKey, new Object[] { arg });
    }

    public String getMessage(String msgKey, String arg1, String arg2) {
        return getMessage(msgKey, new Object[] { arg1, arg2 });
    }

	public String getMessage(String msgKey, String arg1, String arg2, String arg3) {
        return getMessage(msgKey, new Object[] { arg1, arg2, arg3 });
	}

	public String getMessage(String msgKey, Object[] args) {
		String message = null;
		try {
			message = getMessageSourceAccessor().getMessage(msgKey, args, Locale.getDefault());
		} catch (NoSuchMessageException nsm) {
		    message = "???" + msgKey + "???";
		}
		return message;
    }
}
