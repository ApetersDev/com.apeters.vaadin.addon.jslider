package com.apeters.vaadin.addon.jslider.demo;

import java.util.Locale;

import javax.servlet.annotation.WebServlet;

import com.apeters.vaadin.addon.jslider.JSlider;
import com.apeters.vaadin.addon.jslider.JSlider.ValueChangeListener;
import com.apeters.vaadin.addon.jslider.shared.Format;
import com.apeters.vaadin.addon.jslider.shared.Heterogeneity;
import com.apeters.vaadin.addon.jslider.shared.Heterogeneity.HeterogeneityItem;
import com.apeters.vaadin.addon.jslider.shared.InputTagConfigurationImpl;
import com.apeters.vaadin.addon.jslider.shared.Range;
import com.apeters.vaadin.addon.jslider.shared.SliderConfigurationImpl;
import com.vaadin.annotations.StyleSheet;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Theme("demo")
@Title("JSlider Add-on Demo")
@SuppressWarnings("serial")
@StyleSheet(value = {"vaadin://addons/jslider/css/jslider.blue.css", "vaadin://addons/jslider/css/jslider.plastic.css",
		"vaadin://addons/jslider/css/jslider.round.plastic.css", "vaadin://addons/jslider/css/jslider.css", "vaadin://addons/jslider/css/jslider.round.css"})
public class DemoUI extends UI implements ValueChangeListener {
	
	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = DemoUI.class, widgetset = "com.apeters.vaadin.addon.jslider.demo.DemoWidgetSet")
	public static class Servlet extends VaadinServlet {
		
	}
	
	private enum Slider {
		SLIDER1,
		SLIDER2,
		SLIDER3,
		SLIDER4,
		SLIDER5,
		SLIDER6;
	}
	
	private Slider currentSlider6;
	
	@Override
	protected void init(VaadinRequest request) {
		
		// Initialize our new UI component
		final JSlider slider1 = new JSlider(getInputTagConfig(Slider.SLIDER1), getSliderConfig(Slider.SLIDER1));
		slider1.setWidth(100, Unit.PERCENTAGE);
		slider1.setValue(20);
		slider1.addListener(this);
		
		final JSlider slider2 = new JSlider(getInputTagConfig(Slider.SLIDER2), getSliderConfig(Slider.SLIDER2));
		slider2.addListener(this);
		slider2.setWidth(100, Unit.PERCENTAGE);
		slider2.setValue(0, 50000);
		
		final JSlider slider3 = new JSlider(getInputTagConfig(Slider.SLIDER3), getSliderConfig(Slider.SLIDER3));
		slider3.setWidth(100, Unit.PERCENTAGE);
		slider3.setValue(25, 75);
		slider3.addListener(this);
		
		final JSlider slider4 = new JSlider(getInputTagConfig(Slider.SLIDER4), getSliderConfig(Slider.SLIDER4));
		slider4.setWidth(100, Unit.PERCENTAGE);
		slider4.setValue(5, 10);
		slider4.addListener(this);
		
		final JSlider slider5 = new JSlider(getInputTagConfig(Slider.SLIDER5), getSliderConfig(Slider.SLIDER5));
		slider5.setWidth(100, Unit.PERCENTAGE);
		slider5.setValue(600, 720);
		slider5.addListener(this);
		
		final JSlider slider6 = new JSlider(getInputTagConfig(Slider.SLIDER6), getSliderConfig(Slider.SLIDER6));
		slider6.setWidth(100, Unit.PERCENTAGE);
		slider6.setValue(7);
		slider6.addListener(this);
		
		final Button slider6UpdateBtn = new Button("update slider configuration");
		slider6UpdateBtn.addClickListener(new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				DemoUI.this.currentSlider6 = DemoUI.this.currentSlider6 == Slider.SLIDER1 ? Slider.SLIDER2 : Slider.SLIDER1;
				slider6.setSliderConfiguration(getSliderConfig(DemoUI.this.currentSlider6));
				slider6.initStateFields();
				// set new value based on the range of the new configuration
				slider6.setValue(slider6.getSliderConfiguration().getRange().getFrom());
			}
		});
		
		// Show it in the middle of the screen
		final VerticalLayout layout = new VerticalLayout();
		layout.setStyleName("demoContentLayout");
		layout.setSizeFull();
		layout.setMargin(true);
		layout.addComponent(slider1);
		layout.setComponentAlignment(slider1, Alignment.MIDDLE_CENTER);
		layout.addComponent(slider2);
		layout.setComponentAlignment(slider2, Alignment.MIDDLE_CENTER);
		layout.addComponent(slider3);
		layout.setComponentAlignment(slider3, Alignment.MIDDLE_CENTER);
		layout.addComponent(slider4);
		layout.setComponentAlignment(slider4, Alignment.MIDDLE_CENTER);
		layout.addComponent(slider5);
		layout.setComponentAlignment(slider5, Alignment.MIDDLE_CENTER);
		
		VerticalLayout slider6Layout = new VerticalLayout(slider6, slider6UpdateBtn);
		slider6Layout.setWidth(100, Unit.PERCENTAGE);
		slider6Layout.setComponentAlignment(slider6, Alignment.MIDDLE_CENTER);
		slider6Layout.setCaption("Update configuration example");
		slider6Layout.setSpacing(true);
		layout.addComponent(slider6Layout);
		setContent(layout);
		
	}
	
	private InputTagConfigurationImpl getInputTagConfig(Slider slider) {
		return new InputTagConfigurationImpl(slider.name().toLowerCase(), slider.name().toLowerCase());
	}
	
	private SliderConfigurationImpl getSliderConfig(Slider slider) {
		SliderConfigurationImpl config = new SliderConfigurationImpl();
		switch(slider) {
			case SLIDER1:
				config.setRange(new Range(5, 50));
				config.setStep(2.5);
				config.setRound(1);
				config.setFormat(new Format("##.0", Locale.GERMAN));
				config.setDimension("&nbsp;€");
				break;
			case SLIDER2:
				config.setRange(new Range(5000, 150000));
				Heterogeneity heterogeneity2 = new Heterogeneity();
				heterogeneity2.addItem(new HeterogeneityItem(50, 50000));
				config.setHeterogeneity(heterogeneity2);
				config.setStep(1000);
				config.setDimension("&nbsp;$");
				break;
			case SLIDER3:
				config.setRange(new Range(0, 500));
				Heterogeneity heterogeneity3 = new Heterogeneity();
				heterogeneity3.addItem(new HeterogeneityItem(50, 100));
				heterogeneity3.addItem(new HeterogeneityItem(75, 250));
				config.setHeterogeneity(heterogeneity3);
				config.setLimits(false);
				config.setStep(1);
				config.setDimension("&nbsp;m<small>2</small>");
				config.setScale(new Object[] {0, '|', 50, '|', 100, '|', 250, '|', 500});
				break;
			case SLIDER4:
				config.setRange(new Range(1, 30));
				Heterogeneity heterogeneity4 = new Heterogeneity();
				heterogeneity4.addItem(new HeterogeneityItem(50, 5));
				heterogeneity4.addItem(new HeterogeneityItem(75, 15));
				config.setHeterogeneity(heterogeneity4);
				config.setScale(new Object[] {1, '|', 3, '|', '5', '|', 15, '|', 30});
				config.setLimits(false);
				config.setStep(1);
				config.setSkin("round");
				break;
			case SLIDER5:
				config.setRange(new Range(480, 1020));
				config.setStep(15);
				config.setScale(new Object[] {"8:00", "9:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00"});
				config.setLimits(false);
				// @formatter:off
				config.setCalculate(
						"var hours = Math.floor( value / 60 );"+
						"var mins = ( value - hours*60 );"+
						"return (hours < 10 ? \"0\"+hours : hours) + \":\" + ( mins == 0 ? \"00\" : mins );");
				// @formatter:on
				break;
			case SLIDER6:
				config.setRange(new Range(0, 100));
				config.setStep(1);
				config.setRound(1);
				break;
			
			default:
				break;
		}
		return config;
	}
	
	@Override
	public void valueChange(Number value1, Number value2) {
		StringBuilder displayString = new StringBuilder();
		displayString.append("value1= ");
		displayString.append(String.valueOf(value1));
		if(value2 != null) {
			displayString.append(" value2= ");
			displayString.append(String.valueOf(value2));
		}
		Notification.show(displayString.toString());
	}
}
