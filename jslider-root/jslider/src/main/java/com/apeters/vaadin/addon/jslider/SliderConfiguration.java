package com.apeters.vaadin.addon.jslider;

import com.apeters.vaadin.addon.jslider.shared.Format;
import com.apeters.vaadin.addon.jslider.shared.Heterogeneity;
import com.apeters.vaadin.addon.jslider.shared.Range;

public interface SliderConfiguration {
	
	public abstract Range getRange();
	
	public abstract Number getStep();
	
	public abstract Number getRound();
	
	public abstract Format getFormat();
	
	public abstract String getDimension();
	
	public abstract Heterogeneity getHeterogeneity();
	
	public abstract boolean isLimits();
	
	public abstract Object[] getScale();
	
	public abstract String getSkin();
	
	public abstract String getFormatString();
	
	public abstract String getCalculate();
	
}