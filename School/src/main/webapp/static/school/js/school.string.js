var school;
if(!school) school = {};
if(!school.string){
	school.string = {};
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
	};
	school.string.removeAllString = function(str) {
		if(str == null || str == "") return "";
		return str.replace(/[^0-9\.]/g, '');
	};
	school.string.numberWithComma = function(str){
		if(str == null || str == "") return "";// "0";
		return str.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");			
	};
	school.string.removeComma = function(str){
		if(str == null || str == "") return "0";
		return str.replace(/\,/g,'');
	}
}