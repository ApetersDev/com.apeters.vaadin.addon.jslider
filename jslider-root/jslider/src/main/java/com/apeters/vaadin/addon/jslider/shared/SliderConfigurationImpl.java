package com.apeters.vaadin.addon.jslider.shared;


public class SliderConfigurationImpl implements SliderConfiguration {
	private Range range = new Range(0, 100);
	private Number step;
	private Number round;
	private Format format;
	private String dimension = "";
	private Heterogeneity heterogeneity;
	private boolean limits;
	private Object[] scale;
	private String skin;
	private String calculate = "return value;";
	
	@Override
	public Range getRange() {
		return this.range;
	}
	
	public void setRange(Range range) {
		this.range = range;
	}
	
	@Override
	public Number getStep() {
		return this.step;
	}
	
	public void setStep(Number step) {
		this.step = step;
	}
	
	@Override
	public Number getRound() {
		return this.round;
	}
	
	public void setRound(Number round) {
		this.round = round;
	}
	
	@Override
	public Format getFormat() {
		return this.format;
	}
	
	public void setFormat(Format format) {
		this.format = format;
	}
	
	@Override
	public String getDimension() {
		return this.dimension;
	}
	
	public void setDimension(String dimension) {
		this.dimension = dimension;
	}
	
	@Override
	public Heterogeneity getHeterogeneity() {
		return this.heterogeneity;
	}
	
	public void setHeterogeneity(Heterogeneity heterogeneity) {
		this.heterogeneity = heterogeneity;
	}
	
	@Override
	public boolean isLimits() {
		return this.limits;
	}
	
	public void setLimits(boolean limits) {
		this.limits = limits;
	}
	
	@Override
	public Object[] getScale() {
		return this.scale;
	}
	
	public void setScale(Object[] scale) {
		this.scale = scale;
	}
	
	@Override
	public String getSkin() {
		return this.skin;
	}
	
	public void setSkin(String skin) {
		this.skin = skin;
	}
	
	@Override
	public String getFormatString() {
		return getFormat() != null ? getFormat().getFormatString() : "";
	}
	
	public void setCalculate(String calculate) {
		this.calculate = calculate;
	}
	
	@Override
	public String getCalculate() {
		return this.calculate;
	}
}
