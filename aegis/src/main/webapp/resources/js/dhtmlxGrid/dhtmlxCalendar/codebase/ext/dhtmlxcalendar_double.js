//v.3.6 build 131023

/*
Copyright DHTMLX LTD. http://www.dhtmlx.com
You allowed to use this component or parts of it under GPL terms
To use it on other terms or get Professional edition of the component please contact us at sales@dhtmlx.com
*/
window.dhtmlxDblCalendarObject=window.dhtmlXDoubleCalendarObject=window.dhtmlXDoubleCalendar=function(c){var b=this;this.leftCalendar=new dhtmlXCalendarObject(c);this.leftCalendar.hideTime();this.rightCalendar=new dhtmlXCalendarObject(c);this.rightCalendar.hideTime();this.leftCalendar.attachEvent("onClick",function(a){b._updateRange("rightCalendar",a,null);b.callEvent("onClick",["left",a])});this.rightCalendar.attachEvent("onClick",function(a){b._updateRange("leftCalendar",null,a);b.callEvent("onClick",
["right",a])});this.leftCalendar.attachEvent("onBeforeChange",function(a){return b.callEvent("onBeforeChange",["left",a])});this.rightCalendar.attachEvent("onBeforeChange",function(a){return b.callEvent("onBeforeChange",["right",a])});this.show=function(){this.leftCalendar.show();this.rightCalendar.base.style.marginLeft=this.leftCalendar.base.offsetWidth-1+"px";this.rightCalendar.show()};this.hide=function(){this.leftCalendar.hide();this.rightCalendar.hide()};this.setDateFormat=function(a){this.leftCalendar.setDateFormat(a);
this.rightCalendar.setDateFormat(a)};this.setDates=function(a,b){a!=null&&this.leftCalendar.setDate(a);b!=null&&this.rightCalendar.setDate(b);this._updateRange()};this._updateRange=function(a,b,c){arguments.length==3?this[a].setSensitiveRange(b,c):(this.leftCalendar.setSensitiveRange(null,this.rightCalendar.getDate()),this.rightCalendar.setSensitiveRange(this.leftCalendar.getDate(),null))};this.getFormatedDate=function(){return this.leftCalendar.getFormatedDate.apply(this.leftCalendar,arguments)};
dhtmlxEventable(this);return this};

//v.3.6 build 131023

/*
Copyright DHTMLX LTD. http://www.dhtmlx.com
You allowed to use this component or parts of it under GPL terms
To use it on other terms or get Professional edition of the component please contact us at sales@dhtmlx.com
*/