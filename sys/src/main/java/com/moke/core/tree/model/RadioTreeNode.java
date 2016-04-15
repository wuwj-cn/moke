package com.moke.core.tree.model;

public class RadioTreeNode extends TreeNode {
	protected boolean checked;
	protected boolean disabled;
	protected boolean radio;



	public RadioTreeNode() {
	}

	public RadioTreeNode(String id, String text, String qtip, String iconCls, String href, String hrefTarget,
			boolean expanded, boolean leaf, boolean radio) {
		this.id = id;
		this.text = text;
		this.qtip = qtip;
		this.iconCls = iconCls;
		this.href = href;
		this.hrefTarget = hrefTarget;
		this.expanded = expanded;
		this.leaf = leaf;
		this.radio = radio;
		this.checked = false;
	}
    
	public RadioTreeNode(String id, String text, String qtip, String iconCls, String href, String hrefTarget,
			boolean expanded, boolean leaf, boolean radio, boolean disabled) {
		this.id = id;
		this.text = text;
		this.qtip = qtip;
		this.iconCls = iconCls;
		this.href = href;
		this.hrefTarget = hrefTarget;
		this.expanded = expanded;
		this.leaf = leaf;
		this.radio = radio;
		this.checked = false;
		this.disabled = disabled;
	}
	
	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}
	
	public boolean isRadio() {
		return radio;
	}

	public void setRadio(boolean radio) {
		this.radio = radio;
	}
}
