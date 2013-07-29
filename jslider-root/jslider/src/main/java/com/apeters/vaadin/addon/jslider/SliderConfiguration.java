package com.apeters.vaadin.addon.jslider;

import com.apeters.vaadin.addon.jslider.shared.Format;
import com.apeters.vaadin.addon.jslider.shared.Heterogeneity;
import com.apeters.vaadin.addon.jslider.shared.Range;

public interface SliderConfiguration {
	
	public abstract Range getRange();

	public abstract void setRange(Range range);

	public abstract Number getStep();

	public abstract void setStep(Number step);

	public abstract Number getRound();

	public abstract void setRound(Number round);

	public abstract Format getFormat();

	public abstract void setFormat(Format format);

	public abstract String getDimension();

	public abstract void setDimension(String dimension);

	public abstract Heterogeneity getHeterogeneity();

	public abstract void setHeterogeneity(Heterogeneity heterogeneity);

	public abstract boolean isLimits();

	public abstract void setLimits(boolean limits);

	public abstract Object[] getScale();

	public abstract void setScale(Object[] scale);

	public abstract String getSkin();

	public abstract void setSkin(String skin);

	public abstract String getFormatString();

	public abstract void setCalculate(String calculate);

	public abstract String getCalculate();
	
}