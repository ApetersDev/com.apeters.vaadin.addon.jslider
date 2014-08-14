package com.apeters.vaadin.addon.jslider.client;

import com.vaadin.shared.ui.JavaScriptComponentState;

public class JSliderState extends JavaScriptComponentState {
	
	// inputtype configurations
	private String tagId;
	private String tagClass;
	
	// slider configurations
	private Number from;
	private Number to;
	private Number step;
	private Number round;
	private String dimension;
	private boolean limits;
	private boolean smooth;
	private Object[] scale;
	private String skin;
	private String calculate;
	
	private String value = "0";
	private String format;
	private String[] heterogeneity;
	
	public String getTagId() {
		return this.tagId;
	}
	
	public void setTagId(String tagId) {
		this.tagId = tagId;
	}
	
	public String getTagClass() {
		return this.tagClass;
	}
	
	public void setTagClass(String tagClass) {
		this.tagClass = tagClass;
	}
	
	public Number getFrom() {
		return this.from;
	}
	
	public void setFrom(Number from) {
		this.from = from;
	}
	
	public Number getTo() {
		return this.to;
	}
	
	public void setTo(Number to) {
		this.to = to;
	}
	
	public Number getStep() {
		return this.step;
	}
	
	public void setStep(Number step) {
		this.step = step;
	}
	
	public Number getRound() {
		return this.round;
	}
	
	public void setRound(Number round) {
		this.round = round;
	}
	
	public String getDimension() {
		return this.dimension;
	}
	
	public void setDimension(String dimension) {
		this.dimension = dimension;
	}
	
	public boolean isLimits() {
		return this.limits;
	}
	
	public void setLimits(boolean limits) {
		this.limits = limits;
	}
	
	public boolean isSmooth() {
		return smooth;
	}
	
	public void setSmooth(final boolean smooth) {
		this.smooth = smooth;
	}
	
	public Object[] getScale() {
		return this.scale;
	}
	
	public void setScale(Object[] scale) {
		this.scale = scale;
	}
	
	public String getSkin() {
		return this.skin;
	}
	
	public void setSkin(String skin) {
		this.skin = skin;
	}
	
	public String getValue() {
		return this.value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public String getFormat() {
		return this.format;
	}
	
	public void setFormat(String format) {
		this.format = format;
	}
	
	public String[] getHeterogeneity() {
		return this.heterogeneity;
	}
	
	public void setHeterogeneity(String[] heterogeneity) {
		this.heterogeneity = heterogeneity;
	}
	
	public String getCalculate() {
		return this.calculate;
	}
	
	public void setCalculate(String calculate) {
		this.calculate = calculate;
	}
	
}