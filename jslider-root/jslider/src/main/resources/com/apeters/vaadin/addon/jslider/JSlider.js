window.com_apeters_vaadin_addon_jslider_JSlider = function() {

  var e = this.getElement();

  this.onStateChange = function() {
	  e.innerHTML="<input id=\""+this.getState().tagId+"\" " +
		"class=\""+this.getState().tagClass+"\" " +
	  	"type=\"slider\" " +
	  	"value=\""+this.getState().value+"\" " +
	  				"/>";
	  var connector = this;
	  var sliderInput = jQuery("#"+this.getState().tagId);
	  sliderInput.slider(
			  {
		  from: this.getState().from,
		  to: this.getState().to,
		  step: this.getState().step,
		  round: this.getState().round,
		  format: this.getState().format,
		  heterogeneity: this.getState().heterogeneity,
		  scale: this.getState().scale,
		  skin: this.getState().skin,
		  dimension: this.getState().dimension,
		  callback:  function(value) {
			  connector.callback(value);
		  },
		  onstatechange: function(value) {

		  },
		  calculate: new Function("value",this.getState().calculate)
	  }
	  );
  }


}