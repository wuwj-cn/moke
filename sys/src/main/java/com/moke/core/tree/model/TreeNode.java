package com.moke.core.tree.model;


public class TreeNode {
	protected String id;
	protected String text;
	protected String qtip;
	protected String iconCls;
	protected String href;	//	id, cd, text, level...
	protected String hrefTarget;
	protected boolean expanded;
	protected boolean leaf;

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

}
