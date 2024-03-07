//右上角购物车
document.querySelector('.menu-cart').onmouseenter=function(){
	this.classList.add('act');
	document.querySelector('.menu-cart a').classList.add('act');
	this.lastElementChild.style.display='block';
}
document.querySelector('.menu-cart').onmouseleave=function(){
	this.classList.remove('act');
	document.querySelector('.menu-cart a').classList.remove('act');
	this.lastElementChild.style.display='none';
}

//下载
document.querySelector('.download').onmouseenter=function(){
	this.lastElementChild.style.display='block';
}
document.querySelector('.download').onmouseleave=function(){
	this.lastElementChild.style.display='none';
}

//查找
document.querySelector('#search-input').onfocus=function(){
	document.querySelector('#search-input').style.border='1px solid orange';
	document.querySelector('#search-btn').style.border='1px solid orange';
}
document.querySelector('#search-input').onblur=function(){
	document.querySelector('#search-input').style.border='1px solid #e0e0e0';
	document.querySelector('#search-btn').style.border='1px solid #e0e0e0';
}
document.querySelector('#search-btn').onmouseenter=function(){
	document.querySelector('#search-btn').style.backgroundColor='#ff6700';
	document.querySelector('#search-btn').style.color='#ffffff';
}
document.querySelector('#search-btn').onmouseleave=function(){
	document.querySelector('#search-btn').style.backgroundColor='#ffffff';
	document.querySelector('#search-btn').style.color='#616161';
}


//右侧固定显示
document.querySelector('.icon-shouji').onmouseenter=function(){
	document.querySelector('.number-qrode').style.display='block';
}
document.querySelector('.icon-shouji').onmouseleave=function(){
	document.querySelector('.number-qrode').style.display='none';
}














	var clickRight = setInterval(function(){
		if (document.querySelector('.switch-icons .select').classList.contains('last')) {
			//删除select
			document.querySelector('.switch-icons .select').classList.remove('select');
			document.querySelector('.switch-icons .first').classList.add('select');
		
			//选中第一个
			document.querySelector('.banner-bg').classList.remove('banner' + bannerIdx);
			bannerIdx = 0;
		} else {
			//删除当前圆点
			var nex = document.querySelector('.switch-icons .select').nextElementSibling; //先找！再删
			document.querySelector('.switch-icons .select').classList.remove('select');
			nex.classList.add('select');
		
			document.querySelector('.banner-bg').classList.remove('banner' + bannerIdx);
			bannerIdx++;
			document.querySelector('.banner-bg').classList.add('banner' + bannerIdx);
		}
	},2000)




//左边箭头变化
document.querySelector('.left').onclick = function() {
	//当前选中的是第一个
	if (document.querySelector('.switch-icons .select').classList.contains('first')) {
		//删除select
		document.querySelector('.switch-icons .select').classList.remove('select');
		document.querySelector('.switch-icons .last').classList.add('select');
		//选中最后一个
		//
		bannerIdx = document.querySelectorAll('.switch-icons li').length - 1;
		document.querySelector('.banner-bg').classList.add('banner' + bannerIdx);
	} else {
		//找到前边的一个节点
		var pre = document.querySelector('.switch-icons .select').previousElementSibling;
		document.querySelector('.switch-icons .select').classList.remove('select');
		pre.classList.add('select')
		//选中最后一个
		document.querySelector('.banner-bg').classList.remove('banner' + bannerIdx);
		bannerIdx--;
		document.querySelector('.banner-bg').classList.add('banner' + bannerIdx);
		document.querySelector('.banner-bg').classList.remove('banner' + 0); //删除多余的  banner0
	}

}

//右边箭头变化
var bannerIdx = 0;
document.querySelector('.right').onclick = function() {
	if (document.querySelector('.switch-icons .select').classList.contains('last')) {
		//删除select
		document.querySelector('.switch-icons .select').classList.remove('select');
		document.querySelector('.switch-icons .first').classList.add('select');

		//选中第一个
		document.querySelector('.banner-bg').classList.remove('banner' + bannerIdx);
		bannerIdx = 0;
	} else {
		//删除当前圆点
		var nex = document.querySelector('.switch-icons .select').nextElementSibling; //先找！再删
		document.querySelector('.switch-icons .select').classList.remove('select');
		nex.classList.add('select');

		document.querySelector('.banner-bg').classList.remove('banner' + bannerIdx);
		bannerIdx++;
		document.querySelector('.banner-bg').classList.add('banner' + bannerIdx);
	}

}

// 箭头原点联动

for (var i = 0; i < document.querySelectorAll('.switch-icons li').length; i++) {
	document.querySelectorAll('.switch-icons li')[i].onclick = function() {
		document.querySelector('.switch-icons .select').classList.remove('select'); //去除原点状态所在的    状态
		this.classList.add('select'); //谁点击谁加
		if (document.querySelector('.switch-icons .select').classList.contains('first')) {
			document.querySelector('.banner-bg').classList.remove('banner' + bannerIdx);
			bannerIdx = 0;
		} else if (document.querySelector('.switch-icons .select').classList.contains('last')) {
			document.querySelector('.banner-bg').classList.remove('banner' + bannerIdx)
			bannerIdx = document.querySelectorAll('.switch-icons li').length - 1;
			document.querySelector('.banner-bg').classList.add('banner' + bannerIdx)
		} else {
			for (var j = 0; j < document.querySelectorAll('.switch-icons li').length; j++) {
				if (!(document.querySelectorAll('.switch-icons li')[j].classList.contains('select'))) {
					continue;
				} else {
					document.querySelector('.banner-bg').classList.remove('banner' + bannerIdx)
					bannerIdx = j;
					document.querySelector('.banner-bg').classList.add('banner' + bannerIdx)
				}
				break;
			}
		}
	}

}


//手机专栏，左侧第一个聚焦变化
var lef = document.querySelector('.phone-lef');
document.querySelector('.phone-lef').onmouseenter=function(){
	var lefTop = parseInt(getComputedStyle(lef).marginTop);
	lef.style.marginTop = lefTop - 2 +'px';
	lef.style.boxShadow = '0 0 10px #aaa'
}
document.querySelector('.phone-lef').onmouseleave=function(){
	var lefTop = parseInt(getComputedStyle(lef).marginTop);
	lef.style.marginTop = lefTop + 2 +'px';
	lef.style.boxShadow = 'none';
}

//家电右侧内容区  聚焦切换内容


document.querySelector('#app-one').onmouseenter=function(){
	document.querySelector('#app-two').classList.remove('act');
	this.classList.add('act');
	document.querySelector('.dianshi').style.display = 'none';
	document.querySelector('.remen').style.display = 'inline-block';
}


document.querySelector('#app-two').onmouseenter=function(){
	document.querySelector('#app-one').classList.remove('act');
	this.classList.add('act');
	document.querySelector('.remen').style.display = 'none';	
	document.querySelector('.dianshi').style.display = 'inline-block';
}

// //电视影音  查看更多
document.querySelector('#movie').onclick=function(){
	document.querySelector('.two-2').href = 'Tv.html';
}