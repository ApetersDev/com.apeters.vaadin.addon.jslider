package com.apeters.vaadin.addon.jslider.shared;

public class InputTagConfigurationImpl implements InputTagConfiguration {
	
	private String tagId = "jSlider";
	private String tagClass = "jSlider";
	
	public InputTagConfigurationImpl(String tagId) {
		super();
		this.tagId = tagId;
	}
	
	public InputTagConfigurationImpl(String tagId, String tagClass) {
		super();
		this.tagId = tagId;
		this.tagClass = tagClass;
	}
	
	@Override
	public String getTagId() {
		return this.tagId;
	}
	
	public void setTagId(String tagId) {
		this.tagId = tagId;
	}
	
	@Override
	public String getTagClass() {
		return this.tagClass;
	}
	
	public void setTagClass(String tagClass) {
		this.tagClass = tagClass;
	}
}
