//页面加载完成时，清除输入框和密码框的    上浮样式
window.onload=function(){
	document.querySelector('.mobile label').classList.remove('focus');
	document.querySelector('.password label').classList.remove('focus');
	document.querySelector('.message label').classList.remove('focus');
}


//顶部导航栏  语言切换
document.querySelector('.language-title').onmouseenter=function(){
	document.querySelector('.icon-sanjiaoxing').classList.add('act');
	document.querySelector('.language-list').style.display = 'block';
	
}
document.querySelector('.language-title').onmouseleave=function(){
	document.querySelector('.icon-sanjiaoxing').classList.remove('act');
	document.querySelector('.language-list').style.display = 'none';
	
}





//输入框聚焦
var mobileElement = document.querySelector('#login-number');

mobileElement.onfocus = function() {
	document.querySelector('.mobile label').classList.add('focus');
}
mobileElement.onblur = function() {
	mobileElement.value=mobileElement.value.trim()
	if(!mobileElement.value.trim()){
		document.querySelector('.mobile label').classList.remove('focus');
		document.querySelector('.mobile label').style.color='#f15a59';
		mobileElement.style.backgroundColor = '#fcf2f3';
	}else{
		document.querySelector('.mobile label').style.color='#000050';
		mobileElement.style.backgroundColor = '#f9f9f9';
	}
	
	
}

//密码框聚焦
var passwordElement = document.querySelector('#login-password');
passwordElement.onfocus = function() {
	document.querySelector('.password label').classList.add('focus');
}
passwordElement.onblur = function() {
	passwordElement.value=passwordElement.value.trim()
	if(!passwordElement.value.trim()){
		document.querySelector('.password label').classList.remove('focus');
		document.querySelector('.password label').style.color='#f15a59';
		passwordElement.style.backgroundColor = '#fcf2f3';
	}else{
		document.querySelector('.password label').style.color='#000050';
		passwordElement.style.backgroundColor = '#f9f9f9';
	}
	
}


//验证码聚焦
var messageElement = document.querySelector('#register-message');
messageElement.onfocus = function() {
	document.querySelector('.message label').classList.add('focus');
}
messageElement.onblur = function() {
	messageElement.value=messageElement.value.trim()
	if(!messageElement.value.trim()){
		document.querySelector('.message label').classList.remove('focus');
		document.querySelector('.message label').style.color='#f15a59';
		messageElement.style.backgroundColor = '#fcf2f3';
	}else{
		document.querySelector('.message label').style.color='#000050';
		messageElement.style.backgroundColor = '#f9f9f9';
	}
	
}