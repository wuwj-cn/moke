/**
 * Copyright 2007 ICSSHS.
 */
package com.moke.core.tree.model;


/**
 * General tree node structure.
 * 
 * @author yanxz
 */
public class TreeNode {
	protected String id;
	protected String text;
	protected String qtip;
	protected String iconCls;
	protected String href;	//	id, cd, text, level...
	protected String hrefTarget;
	protected boolean expanded;
	protected boolean leaf;
	protected Integer orgLevel;
	protected String orgType;
	protected String tableId;
	protected String columnId;
	protected String taskSingle;
	protected String valueType;
	protected String statType;
	protected String numberFormat;
	protected Integer columnWidth;
	

	public TreeNode() {
	}

	public TreeNode(String id, String text, String qtip, String iconCls, String href, String hrefTarget,
			boolean expanded, boolean leaf) {
		super();
		this.id = id;
		this.text = text;
		this.qtip = qtip;
		this.iconCls = iconCls;
		this.href = href;
		this.hrefTarget = hrefTarget;
		this.expanded = expanded;
		this.leaf = leaf;
	}
	
	public TreeNode(String id, String text, String qtip, String iconCls, String href, String hrefTarget,
			boolean expanded, boolean leaf, Integer orgLevel) {
		super();
		this.id = id;
		this.text = text;
		this.qtip = qtip;
		this.iconCls = iconCls;
		this.href = href;
		this.hrefTarget = hrefTarget;
		this.expanded = expanded;
		this.leaf = leaf;
		this.orgLevel = orgLevel;
	}

	public TreeNode(String id, String text, String qtip, String iconCls, String href, String hrefTarget,
			boolean expanded, boolean leaf, Integer orgLevel, String orgType) {
		super();
		this.id = id;
		this.text = text;
		this.qtip = qtip;
		this.iconCls = iconCls;
		this.href = href;
		this.hrefTarget = hrefTarget;
		this.expanded = expanded;
		this.leaf = leaf;
		this.orgLevel = orgLevel;
		this.orgType = orgType;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getQtip() {
		return qtip;
	}

	public void setQtip(String qtip) {
		this.qtip = qtip;
	}

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getHrefTarget() {
		return hrefTarget;
	}

	public void setHrefTarget(String hrefTarget) {
		this.hrefTarget = hrefTarget;
	}

	public boolean isExpanded() {
		return expanded;
	}

	public void setExpanded(boolean expanded) {
		this.expanded = expanded;
	}

	public boolean isLeaf() {
		return leaf;
	}

	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}

	public Integer getOrgLevel() {
		return orgLevel;
	}

	public void setOrgLevel(Integer orgLevel) {
		this.orgLevel = orgLevel;
	}

	public String getOrgType() {
		return orgType;
	}

	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}

	public String getColumnId() {
		return columnId;
	}

	public void setColumnId(String columnId) {
		this.columnId = columnId;
	}

	public String getTableId() {
		return tableId;
	}

	public void setTableId(String tableId) {
		this.tableId = tableId;
	}

	public String getValueType() {
		return valueType;
	}

	public void setValueType(String valueType) {
		this.valueType = valueType;
	}

	public String getStatType() {
		return statType;
	}

	public void setStatType(String statType) {
		this.statType = statType;
	}

	public String getNumberFormat() {
		return numberFormat;
	}

	public void setNumberFormat(String numberFormat) {
		this.numberFormat = numberFormat;
	}

	public Integer getColumnWidth() {
		return columnWidth;
	}

	public void setColumnWidth(Integer columnWidth) {
		this.columnWidth = columnWidth;
	}

	public String getTaskSingle() {
		return taskSingle;
	}

	public void setTaskSingle(String taskSingle) {
		this.taskSingle = taskSingle;
	}

}
