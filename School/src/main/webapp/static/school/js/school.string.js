var school;
if(!school) school = {};
if(!school.string){
	school.string = {};
	
	school.string.formatBirthDate = function(str){
		
		return "";
	}
	school.string.formatDatetime = function(str){
		if(str=="" || str==null){
			return "";
		}
		if(moment(str, "YYYYMMDDHHmmss").isValid()) {
			str = moment(str,"YYYYMMDDHHmmss").format("YYYY-MM-DD HH:mm:ss");
		}
		return str;
	}
	school.string.formatBirthDate = function(str){
		if(str=="" || str==null){
			return "";
		}
		if(moment(str, "YYYYMMDD").isValid()) {
			str = moment(str,"YYYYMMDD").format("YYYY-MM-DD");
		}
		return str;
	}
	
	
	
}