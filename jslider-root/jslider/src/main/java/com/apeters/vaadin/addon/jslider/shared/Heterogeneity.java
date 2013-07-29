package com.apeters.vaadin.addon.jslider.shared;

import java.util.LinkedList;
import java.util.List;

public class Heterogeneity {
	
	private LinkedList<HeterogeneityItem> items = new LinkedList<Heterogeneity.HeterogeneityItem>();
	
	public Heterogeneity() {
		super();
	}
	
	public void addItem(HeterogeneityItem item){
		//TODO add check, if item with the same percentage value exists
		items.add(item);
	}

	public List<HeterogeneityItem> getItems() {
		return this.items;
	}
	
	public List<String> getStringValuesOfItems() {
		LinkedList<String> stringValues = new LinkedList<String>();
		for (HeterogeneityItem item : getItems()) {
			stringValues.add(item.getHeterogeneityString());
		}
		return stringValues;
	}
	
	public static class HeterogeneityItem {
		private Number percentage;
		private Number value;
		
		public HeterogeneityItem(Number percentage, Number value) {
			super();
			this.percentage = percentage;
			this.value = value;
		}

		public Number getPercentage() {
			return this.percentage;
		}
		
		public void setPercentage(Number percentage) {
			this.percentage = percentage;
		}
		
		public Number getValue() {
			return this.value;
		}
		
		public void setValue(Number value) {
			this.value = value;
		}
		
		public String getHeterogeneityString() {
			String retVal = "";
			if(this.percentage != null && this.value != null) {
				retVal = String.format("%s/%s", String.valueOf(this.percentage), String.valueOf(this.value));
			}
			return retVal;
		}
	}
}
