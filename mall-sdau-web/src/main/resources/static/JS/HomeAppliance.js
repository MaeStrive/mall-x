	var topHeiget = $('.nav-bar').offset().top;
	
	$(document).scroll(function(){
		var scrollTop = $(document).scrollTop();
		if(scrollTop>=topHeiget){
			$('.nav-bar').addClass('fix-bar');
		}else{
			$('.nav-bar').removeClass('fix-bar');
		}
	})

// function clickLeft(){
// 	//左边箭头变化
// 	document.querySelector('.left').onclick = function() {
// 		//当前选中的是第一个
// 		if (document.querySelector('.switch-icons .select').classList.contains('first')) {
// 			//删除select
// 			document.querySelector('.switch-icons .select').classList.remove('select');
// 			document.querySelector('.switch-icons .last').classList.add('select');
// 			//选中最后一个
// 			//
// 			bannerIdx = document.querySelectorAll('.switch-icons li').length - 1;
// 			document.querySelector('.product-left').classList.add('banner' + bannerIdx);
// 		} else {
// 			//找到前边的一个节点
// 			var pre = document.querySelector('.switch-icons .select').previousElementSibling;
// 			document.querySelector('.switch-icons .select').classList.remove('select');
// 			pre.classList.add('select')
// 			//选中最后一个
// 			document.querySelector('.product-left').classList.remove('banner' + bannerIdx);
// 			bannerIdx--;
// 			document.querySelector('.product-left').classList.add('banner' + bannerIdx);
// 			document.querySelector('.product-left').classList.remove('banner' + 0); //删除多余的  banner0
// 		}
//
// 	}
//
// }
//
// document.querySelector('.left').onclick = function(){
// 	clickLeft();
//
// }

// 右边轮播
// 	var clickRight = setInterval(function(){
// 		if (document.querySelector('.switch-icons .select').classList.contains('last')) {
// 			//删除select
// 			document.querySelector('.switch-icons .select').classList.remove('select');
// 			document.querySelector('.switch-icons .first').classList.add('select');
//
// 			//选中第一个
// 			document.querySelector('.product-left').classList.remove('banner' + bannerIdx);
// 			bannerIdx = 0;
// 		} else {
// 			//删除当前圆点
// 			var nex = document.querySelector('.switch-icons .select').nextElementSibling; //先找！再删
// 			document.querySelector('.switch-icons .select').classList.remove('select');
// 			nex.classList.add('select');
//
// 			document.querySelector('.product-left').classList.remove('banner' + bannerIdx);
// 			bannerIdx++;
// 			document.querySelector('.product-left').classList.add('banner' + bannerIdx);
// 		}
// 	},2000)



//右边箭头变化
var bannerIdx = 0;
// document.querySelector('.right').onclick = function() {
// 	if (document.querySelector('.switch-icons .select').classList.contains('last')) {
// 		//删除select
// 		document.querySelector('.switch-icons .select').classList.remove('select');
// 		document.querySelector('.switch-icons .first').classList.add('select');
//
// 		//选中第一个
// 		document.querySelector('.product-left').classList.remove('banner' + bannerIdx);
// 		bannerIdx = 0;
// 	} else {
// 		//删除当前圆点
// 		var nex = document.querySelector('.switch-icons .select').nextElementSibling; //先找！再删
// 		document.querySelector('.switch-icons .select').classList.remove('select');
// 		nex.classList.add('select');
//
// 		document.querySelector('.product-left').classList.remove('banner' + bannerIdx);
// 		bannerIdx++;
// 		document.querySelector('.product-left').classList.add('banner' + bannerIdx);
// 	}
//
// }

// 箭头原点联动

// for (var i = 0; i < document.querySelectorAll('.switch-icons li').length; i++) {
// 	document.querySelectorAll('.switch-icons li')[i].onclick = function() {
// 		document.querySelector('.switch-icons .select').classList.remove('select'); //去除原点状态所在的    状态
// 		this.classList.add('select'); //谁点击谁加
// 		if (document.querySelector('.switch-icons .select').classList.contains('first')) {
// 			document.querySelector('.product-left').classList.remove('banner' + bannerIdx);
// 			bannerIdx = 0;
// 		} else if (document.querySelector('.switch-icons .select').classList.contains('last')) {
// 			document.querySelector('.product-left').classList.remove('banner' + bannerIdx)
// 			bannerIdx = document.querySelectorAll('.switch-icons li').length - 1;
// 			document.querySelector('.product-left').classList.add('banner' + bannerIdx)
// 		} else {
// 			for (var j = 0; j < document.querySelectorAll('.switch-icons li').length; j++) {
// 				if (!(document.querySelectorAll('.switch-icons li')[j].classList.contains('select'))) {
// 					continue;
// 				} else {
// 					document.querySelector('.product-left').classList.remove('banner' + bannerIdx)
// 					bannerIdx = j;
// 					document.querySelector('.product-left').classList.add('banner' + bannerIdx)
// 				}
// 				break;
// 			}
// 		}
// 	}
//
// }

//加入购物车
document.querySelector('.addCart').onmouseenter=function(){
	document.querySelector('.addCart').classList.add('act')
}
document.querySelector('.addCart').onmouseleave=function(){
	document.querySelector('.addCart').classList.remove('act')
}


// 喜欢

document.querySelector('.likeCart').onmouseenter=function(){
	document.querySelector('.likeCart').classList.add('act')
}
document.querySelector('.likeCart').onmouseleave=function(){
	document.querySelector('.likeCart').classList.remove('act')
}



// for(var j=0;document.querySelector('.menu-title-list').length;j++){
	
	
// }
// document.querySelectorAll('.menu-title-list').onclick=function(ev){
	
// 	if(ev.target.className=='check1'){
// 		ev.target.parentNode.parentNode.style.borderColor = 'orange';
// 	}
	
	
// }
// document.querySelector('.menu-title-list .check1').onclick=function(){
// 	if(document.querySelector('.menu-title-list .check1').checked==true){
// 		document.querySelector('.menu-title-list .check1').parentNode.parentNode.style.borderColor='#ff6700';
// 	}else{
// 		document.querySelector('.menu-title-list .check1').parentNode.parentNode.style.borderColor='#e0e0e0';
// 	}
//
// }
// document.querySelector('.menu-title-list .check2').onclick=function(){
// 	if(document.querySelector('.menu-title-list .check2').checked==true){
// 		document.querySelector('.menu-title-list .check2').parentNode.parentNode.style.borderColor='#ff6700';
// 	}else{
// 		document.querySelector('.menu-title-list .check2').parentNode.parentNode.style.borderColor='#e0e0e0';
// 	}
//
// }
// document.querySelector('.menu-title-list .check3').onclick=function(){
// 	if(document.querySelector('.menu-title-list .check3').checked==true){
// 		document.querySelector('.menu-title-list .check3').parentNode.parentNode.style.borderColor='#ff6700';
// 	}else{
// 		document.querySelector('.menu-title-list .check3').parentNode.parentNode.style.borderColor='#e0e0e0';
// 	}
//
// }
//
//
//
