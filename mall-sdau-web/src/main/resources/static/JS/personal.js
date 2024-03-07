
//顶部导航栏  语言切换
document.querySelector('.language-title').onmouseenter=function(){
	document.querySelector('.icon-sanjiaoxing').classList.add('act');
	document.querySelector('.language-list').style.display = 'block';
	
}
document.querySelector('.language-title').onmouseleave=function(){
	document.querySelector('.icon-sanjiaoxing').classList.remove('act');
	document.querySelector('.language-list').style.display = 'none';
	
}






//点击左侧列表    更改右侧内容
document.querySelector('.personal-list').onclick = function(event){
	
	if(event.target.tagName =='LI'){
		//1、删除act
		document.querySelector('.personal-list .act').classList.remove('act');
		//2、添加act
		event.target.classList.add('act');
		
		//内容区
		//1、删除act
		document.querySelector('.personal-content .act').classList.remove('act');
		
		//2、添加act
		var liIdx = event.target.getAttribute('id')
		document.querySelectorAll('.personal-content >li')[liIdx].classList.add('act');
		
	}
}



// 个人信息页

// 编辑按钮
var changeBtn = document.querySelector('.change-btn');//查找编辑保存按钮
var inputN = document.querySelector('#input-name');//查找设置昵称编辑框

var sexChoice = document.querySelector('.sex');//查找性别显示区块

var  sta = true ;

changeBtn.onclick = function(){
	if(sta){
		changeBtn.innerText = '保存';
		inputN.disabled = false;
		
		//昵称输入框的聚焦  失焦事件
		inputN.onfocus=function(){
			inputN.classList.add('input-Active');
		}
		inputN.onblur=function(){
			inputN.classList.remove('input-Active');
		}
		
		sexChoice.innerHTML = '<input type="radio" class="man"><span>男</span><input type="radio" class="women"><span>女</span>'
		document.querySelector('.man').checked=true;
		
	}else{
		changeBtn.innerText = '编辑';
		inputN.disabled = true;
		
		document.querySelector('.infor-name').innerText = inputN.value.trim();
		
		if(document.querySelector('.man').checked==true){
			sexChoice.innerHTML = '男';
		}else{
			sexChoice.innerHTML = '女';
		}
		
		
	}
	sta = ! sta;

	
}

