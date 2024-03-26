document.querySelector('.addAddress').onclick=function(){
	document.querySelector('.alert-box').style.display='block';//弹窗
	
}

//把地址弹出框的内容引入JS





//弹出框的确认按钮—————弹出框的隐藏
// document.querySelector('#determine').onclick=function(){
// 	if(!nameElement.value){
// 		alert('请输入姓名');
// 		return;
// 	}else if(numberElement.value.length<11||numberElement.value.length>11){
// 			alert('请输入正确手机号');
// 			return;
// 	}else if(!document.querySelector('.input-lookup').value){
// 		alert('请输入地址');
// 		return;
// 	}else if(!document.querySelector('.input-address').value){
// 		alert('请输入详细地址');
// 		return;
// 	}else if(!document.querySelector('.input-addressLabel').value){
// 		alert('请输入地址标签');
// 		return;
// 	}else{
// 		// alert('1')
// 		document.querySelector('.address-list').style.display = 'inline-block';
// 		document.querySelector('.address-name').innerText = nameElement.value;
// 		document.querySelector('.address-label').innerHTML = addressLabelElement.value;
// 		document.querySelector('.address-number').innerText = numberElement.value;
// 		document.querySelector('.address-address').innerText = lookuplElement.value;
// 		document.querySelector('.address-detailed').innerText = document.querySelector('.input-address').value;
//
// 		//清空弹出框的内容
//
// 	}
//
// 	document.querySelector('.alert-box').style.display='none';
// }



document.querySelector('#cancel').onclick=function(){
	document.querySelector('.alert-box').style.display='none';
}
document.querySelector('.close').onclick=function(){
	document.querySelector('.alert-box').style.display='none';
}


// 页面中地址列表的修改  和 删除
document.querySelector('.address-changeed').onclick=function(){
	
	document.querySelector('.alert-box').style.display = 'block';
	
}
document.querySelector('.address-dele').onclick=function(){
	
	document.querySelector('.address-list').style.display = 'none';
	
}















//姓名输入框聚焦
var nameElement = document.querySelector('#input-name');

nameElement.onfocus = function() {
	document.querySelector('.pla-name').classList.add('focus');
	document.querySelector('#input-name').classList.add('act');
}
nameElement.onblur = function() {
	nameElement.value=nameElement.value.trim()
	if(!nameElement.value.trim()){
		document.querySelector('.pla-name').classList.remove('focus');
	}
	document.querySelector('#input-name').classList.remove('act');
}

//手机号输入框聚焦
var numberElement = document.querySelector('#input-number');

numberElement.onfocus = function() {
	document.querySelector('.pla-number').classList.add('focus');
	document.querySelector('#input-number').classList.add('act');
}
numberElement.onblur = function() {
	numberElement.value=numberElement.value.trim()
	if(!numberElement.value.trim()){
		document.querySelector('.pla-number').classList.remove('focus');
	}
	document.querySelector('#input-number').classList.remove('act');
}


//详细地址输入框聚焦
var addressElement = document.querySelector('#input-address');

addressElement.onfocus = function() {
	document.querySelector('.pla-address').classList.add('focus');
	document.querySelector('#input-address').classList.add('act');
	// if(addressElement.value.trim()==''){
	// 	document.querySelector('#input-address').style.placeholder = '详细地址';
		
	// }
}
addressElement.onblur = function() {
	addressElement.value=addressElement.value.trim()
	if(!addressElement.value.trim()){
		document.querySelector('.pla-address').classList.remove('focus');
	}
	document.querySelector('#input-address').classList.remove('act');
}

//地址标签输入框聚焦
var addressLabelElement = document.querySelector('#input-addressLabel');

addressLabelElement.onfocus = function() {
	document.querySelector('.pla-addressLabel').classList.add('focus');
	document.querySelector('#input-addressLabel').classList.add('act');
}
addressLabelElement.onblur = function() {
	addressLabelElement.value=addressLabelElement.value.trim()
	if(!addressLabelElement.value.trim()){
		document.querySelector('.pla-addressLabel').classList.remove('focus');
	}
	document.querySelector('#input-addressLabel').classList.remove('act');
}



//选择省市按钮弹窗的出现
document.querySelector('#input-choice').onclick=function(){
	document.querySelector('.choice-alert').style.display = 'block';
}

//选择省市按钮弹窗的消失
document.querySelector('.choice-alert .closeAddress').onclick=function(){
	document.querySelector('.choice-alert').style.display = 'none';
}

//地址弹出框中    地址输入框聚焦
var lookuplElement = document.querySelector('#input-lookup');

lookuplElement.onfocus=function(){
	lookuplElement.classList.add('focus');
}

lookuplElement.onblur=function(){
	lookuplElement.classList.remove('focus');
}


