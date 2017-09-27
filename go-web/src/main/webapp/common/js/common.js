/**
 * 创建日期：2017/4/5 21：16
 * 创建人：周潮
 * 描述：对一些公共部分进行封装
 */


/**
 * 根据ID获取对象
 */
function domId(id) {
	return document.getElementById(id);
}

/**
 * 根据ID获取对象处输入的值
 */
function domIdValue(id) {
	return document.getElementById(id).value;
}

/**
 * 根据 name 获取对象集合
 */
function domName(name) {
	return document.getElementsByName(name); // 返回一个name属性为name的一个数组集合
}

/**
 * 获取当前时间
 */
function showTime() {
	var today = new Date();
	var year = today.getYear() - 100 + 2000;
	var month = today.getMonth() + 1;
	var date = today.getDate();
	var hour = today.getHours();
	var minute = today.getMinutes();
	var second = today.getSeconds();
	var strDate;
	var n_day = today.getDay();
	switch(n_day) {
		case 0:
			{
				strDate = "星期日"
			}
			break;
		case 1:
			{
				strDate = "星期一"
			}
			break;
		case 2:
			{
				strDate = "星期二"
			}
			break;
		case 3:
			{
				strDate = "星期三"
			}
			break;
		case 4:
			{
				strDate = "星期四"
			}
			break;
		case 5:
			{
				strDate = "星期五"
			}
			break;
		case 6:
			{
				strDate = "星期六"
			}
			break;
		case 7:
			{
				strDate = "星期日"
			}
			break;
	}
	if(month < 10)
		month = "0" + month;
	if(date < 10)
		date = "0" + date;
	if(hour < 10)
		hour = "0" + hour;
	if(minute < 10)
		minute = "0" + minute;
	if(second < 10)
		second = "0" + second;
	return year + "年" + month + "月" + date + "日 " + strDate + " " + hour + ":" +
		minute + ":" + second;
	// setTimeout("showtime();", 1000);
}