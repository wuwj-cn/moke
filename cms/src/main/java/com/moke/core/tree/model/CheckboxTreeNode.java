package com.moke.core.tree.model;


public class CheckboxTreeNode extends TreeNode {
	protected boolean checked;
	protected boolean disabled;

	public CheckboxTreeNode() {
	}

	public CheckboxTreeNode(String id, String text, String qtip, String iconCls, String href, String hrefTarget,
			boolean expanded, boolean leaf, boolean checked) {
		this.id = id;
		this.text = text;
		this.qtip = qtip;
		this.iconCls = iconCls;
		this.href = href;
		this.hrefTarget = hrefTarget;
		this.expanded = expanded;
		this.leaf = leaf;
		this.checked = checked;
	}
    
	public CheckboxTreeNode(String id, String text, String qtip, String iconCls, String href, String hrefTarget,
			boolean expanded, boolean leaf, boolean checked, boolean disabled) {
		this.id = id;
		this.text = text;
		this.qtip = qtip;
		this.iconCls = iconCls;
		this.href = href;
		this.hrefTarget = hrefTarget;
		this.expanded = expanded;
		this.leaf = leaf;
		this.checked = checked;
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

}
