

//左侧列表，点击事件，然后更换右侧内容区
// console.log(document.querySelectorAll('.profile-left li').length)
var liLen = document.querySelectorAll('.profile-left li').length;

document.querySelector('.profile-left').onclick=function(event){
	
	if(event.target.tagName == 'LI'){
		document.querySelector('.profile-left .act').classList.remove('act');
		
		event.target.classList.add('act');
	}
	
}