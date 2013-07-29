package com.apeters.vaadin.addon.jslider.shared;

public class Range {
	private Number from;
	private Number to;
	
	public Range(Number from, Number to) {
		super();
		this.from = from;
		this.to = to;
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
	
}
