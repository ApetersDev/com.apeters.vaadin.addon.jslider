package com.apeters.vaadin.addon.jslider.shared;

import java.util.Locale;

import org.apache.commons.lang.StringUtils;

public class Format {
	public Format() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	private String numberFormat;
	private Locale locale;
	
	public Format(String numberFormat, Locale locale) {
		super();
		this.numberFormat = numberFormat;
		this.locale = locale;
	}
	
	public String getNumberFormat() {
		return this.numberFormat;
	}
	
	public void setNumberFormat(String numberFormat) {
		this.numberFormat = numberFormat;
	}
	
	public Locale getLocale() {
		return this.locale;
	}
	
	public void setLocale(Locale locale) {
		this.locale = locale;
	}
	
	public String getFormatString() {
		// format: '##.0', locale: 'de'
		StringBuilder formatBuilder = new StringBuilder();
		if(StringUtils.isNotBlank(getNumberFormat())) {
			formatBuilder.append(String.format("format: '%s',", getNumberFormat()));
		}
		if(getLocale() != null) {
			formatBuilder.append(String.format("locale: '%s'", getLocale().getLanguage()));
		}
		
		return formatBuilder.toString();
	}
	
}
