if(typeof JRJ=="undefined"||!JRJ){var JRJ={}}if(typeof JRJ.ui=="undefined"||!JRJ.ui){JRJ.ui={}}(function(a){JRJ.ui.TabSwitch=function(b){this.args={menuPre:"",conPre:"",total:null,eventType:"mouseover",currTab:1,onClass:"",offClass:"",hoverClass:"",onSwitch:null};for(property in b){this.args[property]=b[property]}this.menuIdPre=this.args.menuPre;this.conIdPre=this.args.conPre;this.eventType=this.args.eventType;this.onClass=this.args.onClass;this.offClass=this.args.offClass;this.hoverClass=this.args.hoverClass;this.currTab=this.args.currTab;this.total=this.args.total;this.onSwitch=this.args.onSwitch;for(var c=1;c<=this.total;c++){this.addTab(c,this.onSwitch)}};JRJ.ui.TabSwitch.prototype={addTab:function(b,e){var c=this;var d=a("#"+c.menuIdPre+b);c.installEvent(d[0],c.eventType,c.bind(c,c.show,[b,e]));if(c.eventType=="click"&&c.hoverClass!=""){d.mouseenter(function(){a(this).addClass(c.hoverClass)});d.mouseleave(function(){a(this).removeClass(c.hoverClass)})}},show:function(c,e){if(this.currTab==c){return}var d=a("#"+this.menuIdPre+this.currTab);d.removeClass(this.onClass);d.addClass(this.offClass);var b=a("#"+this.menuIdPre+c);b.removeClass(this.offClass);b.addClass(this.onClass);a("#"+this.conIdPre+this.currTab).hide();a("#"+this.conIdPre+c).show();this.currTab=c;if(e&&e.fcn){e.fcn.apply(e.fcn,e.args)}},bind:function(b,d,c){return function(){d.apply(b,c)}},installEvent:function(c,b,d){if(c.attachEvent){c.attachEvent("on"+b,function(e){d(e)})}else{if(c.addEventListener){c.addEventListener(b,d,false)}}}}})(jQuery);