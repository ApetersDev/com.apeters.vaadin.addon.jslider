package com.apeters.vaadin.addon.jslider;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.json.JSONArray;
import org.json.JSONException;

import com.apeters.vaadin.addon.jslider.client.JSliderState;
import com.apeters.vaadin.addon.jslider.shared.Heterogeneity;
import com.apeters.vaadin.addon.jslider.shared.InputTagConfiguration;
import com.apeters.vaadin.addon.jslider.shared.SliderConfiguration;
import com.vaadin.annotations.JavaScript;
import com.vaadin.ui.AbstractJavaScriptComponent;
import com.vaadin.ui.JavaScriptFunction;

// This is the server-side UI component that provides public API
// for JSlider
@JavaScript(value = {"vaadin://addons/jslider/js/jquery-1.10.2.js", "vaadin://addons/jslider/js/jshashtable-3.0.js",
		"vaadin://addons/jslider/js/jquery.numberformatter-1.2.3.js", "vaadin://addons/jslider/js/tmpl.js",
		"vaadin://addons/jslider/js/jquery.dependClass-0.1.js", "vaadin://addons/jslider/js/draggable-0.1.js", "vaadin://addons/jslider/js/jquery.slider.js",
		"JSlider.js"})
public class JSlider extends AbstractJavaScriptComponent {
	private static final long serialVersionUID = 6018826093083410384L;
	
	private InputTagConfiguration inputTagConfiguration;
	private SliderConfiguration sliderConfiguration;
	
	public JSlider(InputTagConfiguration inputTagConfiguration, SliderConfiguration sliderConfiguration) {
		super();
		this.inputTagConfiguration = inputTagConfiguration;
		this.sliderConfiguration = sliderConfiguration;
	}
	
	@Override
	public void attach() {
		super.attach();
		registerFunctions();
		initStateFields();
	}
	
	private void registerFunctions() {
		addFunction("callback", new JavaScriptFunction() {
			private static final long serialVersionUID = -286554526404269688L;

			@Override
			public void call(JSONArray arguments) throws JSONException {
				setValue(arguments.getString(0));
			}
		});
	}
	
	public void initStateFields() {
		getState().setTagId(this.inputTagConfiguration.getTagId());
		getState().setTagClass(this.inputTagConfiguration.getTagClass());
		getState().setFrom(this.sliderConfiguration.getRange().getFrom());
		getState().setTo(this.sliderConfiguration.getRange().getTo());
		getState().setStep(this.sliderConfiguration.getStep());
		getState().setRound(this.sliderConfiguration.getRound());
		getState().setDimension(this.sliderConfiguration.getDimension());
		// the format string
		getState().setFormat(this.sliderConfiguration.getFormatString());
		getState().setScale(this.sliderConfiguration.getScale());
		getState().setSkin(this.sliderConfiguration.getSkin());
		getState().setCalculate(this.sliderConfiguration.getCalculate());
		// heterogeneity list
		Heterogeneity heterogeneity = this.sliderConfiguration.getHeterogeneity();
		if(heterogeneity != null && !heterogeneity.getItems().isEmpty()) {
			List<String> heterogeneityStringValues = heterogeneity.getStringValuesOfItems();
			// cast collection to array
			getState().setHeterogeneity(heterogeneityStringValues.toArray(new String[heterogeneityStringValues.size()]));
		}
	}
	
	public Number getFirstValue() {
		return getValueForIndex(0);
	}
	
	public Number getSecondValue() {
		return getValueForIndex(1);
	}
	
	private Number getValueForIndex(int index) {
		Number retVal = null;
		String[] values = StringUtils.split(getState().getValue(), ";");
		if(index == 0) {
			retVal = NumberUtils.createNumber(values[index]);
		} else if(index == 1 && values.length == 2) {
			retVal = NumberUtils.createNumber(values[index]);
		}
		return retVal;
	}
	
	public void setValue(Number value) {
		setValue(String.valueOf(value));
	}
	
	public void setValue(Number value1, Number value2) {
		if(value1 == null || value2 == null) {
			throw new IllegalArgumentException("Values are not allowed to be null.");
		}
		setValue(String.format("%s;%s", String.valueOf(value1), String.valueOf(value2)));
	}
	
	public void setValue(final String value) {
		getState().setValue(value);
		for(ValueChangeListener listener : listeners) {
			listener.valueChange(getFirstValue(), getSecondValue());
		}
	}
	
	// We must override getState() to cast the state to JSliderState
	@Override
	protected JSliderState getState() {
		return (JSliderState) super.getState();
	}
	
	public interface ValueChangeListener extends Serializable {
		void valueChange(Number value1, Number value2);
	}
	
	ArrayList<ValueChangeListener> listeners = new ArrayList<ValueChangeListener>();
	
	public void addListener(ValueChangeListener listener) {
		this.listeners.add(listener);
	}
	
	public InputTagConfiguration getInputTagConfiguration() {
		return this.inputTagConfiguration;
	}
	
	public void setInputTagConfiguration(InputTagConfiguration inputTagConfiguration) {
		this.inputTagConfiguration = inputTagConfiguration;
	}
	
	public SliderConfiguration getSliderConfiguration() {
		return this.sliderConfiguration;
	}
	
	public void setSliderConfiguration(SliderConfiguration sliderConfiguration) {
		this.sliderConfiguration = sliderConfiguration;
	}
}
