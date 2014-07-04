(function(window){
	window.$.extend($, {
		getScript: function(url, callback, charset){
			var head = document.getElementsByTagName("head")[0] || document.documentElement;
			var script = document.createElement("script");
			if ( charset ) {
				script.charset = charset;
			}
			script.src = url;

			// Handle Script loading
			var done = false;

			// Attach handlers for all browsers
			script.onload = script.onreadystatechange = function() {
				if ( !this.readyState ||
						this.readyState === "loaded" || this.readyState === "complete" ) {
					callback();

					// Handle memory leak in IE
					script.onload = script.onreadystatechange = null;
					
					//remove the script tag
					if ( head && script.parentNode ) {
						//head.removeChild( script );
					}
				}
			};
			
			// Use insertBefore instead of appendChild  to circumvent an IE6 bug.
			head.insertBefore( script, head.firstChild );
		}
	});
})(window);

