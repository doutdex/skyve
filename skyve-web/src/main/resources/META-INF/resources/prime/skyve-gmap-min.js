SKYVE.BizMap=function(){var a={};var b=function(d,c){$.get(d.url,function(e){SKYVE.Util.scatterGMap(d,e,true,false)})};return{create:function(e){var d={zoom:4,center:new google.maps.LatLng(-26,133.5),mapTypeId:google.maps.MapTypeId.ROADMAP};var f=a[e.elementId];if(f){if(f.gmap){d.zoom=f.gmap.getZoom();d.center=f.gmap.getCenter();d.mapTypeId=f.gmap.getMapTypeId()}}else{f={_objects:{},click:function(g,h){SKYVE.BizMap.click(this,g,h)}};a[e.elementId]=f}f.infoWindow=new google.maps.InfoWindow({content:""});f.gmap=new google.maps.Map(document.getElementById(e.elementId),d);var c=SKYVE.Util.CONTEXT_URL+"map?";if(e.modelName){c+="_c="+e._c+"&_m="+e.modelName}else{if(e.queryName){c+="_mod="+e.moduleName+"&_q="+e.queryName+"&_geo="+e.geometryBinding}}f.url=c;b(f,true);return f},get:function(c){return a[c]},click:function(j,i,d){var f=i.infoMarkup;f+='<br/><br/><input type="button" value="Zoom" onclick="window.location=\''+SKYVE.Util.CONTEXT_URL;f+="?m="+i.mod+"&d="+i.doc+"&i="+i.bizId+"'\"/>";if(i.getPosition){j.infoWindow.open(this.gmap,i);j.infoWindow.setContent(f)}else{if(i.getPath){var c=new google.maps.LatLngBounds();var m=i.getPath();for(var h=0,e=m.getLength();h<e;h++){c.extend(m.getAt(h))}var g=c.getNorthEast();var l=c.getSouthWest();j.infoWindow.setPosition(d.latLng);j.infoWindow.open(j.gmap);j.infoWindow.setContent(f)}}}}}();