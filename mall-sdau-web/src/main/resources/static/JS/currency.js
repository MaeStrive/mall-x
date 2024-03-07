
//购物车
document.querySelector('.menu-cart').onmouseenter=function(){
	this.classList.add('act');
	this.lastElementChild.style.display='block';
	document.querySelector('.menu-cart a').classList.add('act');
}
document.querySelector('.menu-cart').onmouseleave=function(){
	this.classList.remove('act')
	this.lastElementChild.style.display='none';
	document.querySelector('.menu-cart a').classList.remove('act');
}

//下载
document.querySelector('.download').onmouseenter=function(){
	this.lastElementChild.style.display='block'
}
document.querySelector('.download').onmouseleave=function(){
	this.lastElementChild.style.display='none'
}

//查找
document.querySelector('#search-input').onfocus=function(){
	document.querySelector('#search-input').style.border='1px solid orange';
	document.querySelector('#search-btn').style.border='1px solid orange'
}
document.querySelector('#search-input').onblur=function(){
	document.querySelector('#search-input').style.border='1px solid #e0e0e0'
	document.querySelector('#search-btn').style.border='1px solid #e0e0e0'
}
document.querySelector('#search-btn').onmouseenter=function(){
	document.querySelector('#search-btn').style.backgroundColor='#ff6700';
	document.querySelector('#search-btn').style.color='#ffffff';
}
document.querySelector('#search-btn').onmouseleave=function(){
	document.querySelector('#search-btn').style.backgroundColor='#ffffff';
	document.querySelector('#search-btn').style.color='#616161';
}
document.querySelector('#search-btn').onclick=function(){
	if(document.querySelector('#search-input').value==''){
		alert('未输入内容');
		return;
	}
	
}



//更改为高度慢慢出现的  顶部导航区
document.querySelector('.over-test1').onmouseenter=function(){
	this.lastElementChild.classList.add('act');
}
document.querySelector('.over-test1').onmouseleave=function(){
	this.lastElementChild.classList.remove('act');
}
document.querySelector('.over-test2').onmouseenter=function(){
	this.lastElementChild.classList.add('act');
}
document.querySelector('.over-test2').onmouseleave=function(){
	this.lastElementChild.classList.remove('act');
}
document.querySelector('.over-test3').onmouseenter=function(){
	this.lastElementChild.classList.add('act');
}
document.querySelector('.over-test3').onmouseleave=function(){
	this.lastElementChild.classList.remove('act');
}
document.querySelector('.over-test4').onmouseenter=function(){
	this.lastElementChild.classList.add('act');
}
document.querySelector('.over-test4').onmouseleave=function(){
	this.lastElementChild.classList.remove('act');
}
document.querySelector('.over-test5').onmouseenter=function(){
	this.lastElementChild.classList.add('act');
}
document.querySelector('.over-test5').onmouseleave=function(){
	this.lastElementChild.classList.remove('act');
}
document.querySelector('.over-test6').onmouseenter=function(){
	this.lastElementChild.classList.add('act');
}
document.querySelector('.over-test6').onmouseleave=function(){
	this.lastElementChild.classList.remove('act');
}
document.querySelector('.over-test7').onmouseenter=function(){
	this.lastElementChild.classList.add('act');
}
document.querySelector('.over-test7').onmouseleave=function(){
	this.lastElementChild.classList.remove('act');
}
document.querySelector('.over-test8').onmouseenter=function(){
	this.lastElementChild.classList.add('act');
}
document.querySelector('.over-test8').onmouseleave=function(){
	this.lastElementChild.classList.remove('act');
}



//顶部导航栏——原来
// document.querySelector('.over-test1').onmouseenter=function(){
// 	this.lastElementChild.style.display='block'
// }
// document.querySelector('.over-test1').onmouseleave=function(){
// 	this.lastElementChild.style.display='none'
// }
// document.querySelector('.over-test2').onmouseenter=function(){
// 	this.lastElementChild.style.display='block'
// }
// document.querySelector('.over-test2').onmouseleave=function(){
// 	this.lastElementChild.style.display='none'
// }
// document.querySelector('.over-test3').onmouseenter=function(){
// 	this.lastElementChild.style.display='block'
// }
// document.querySelector('.over-test3').onmouseleave=function(){
// 	this.lastElementChild.style.display='none'
// }
// document.querySelector('.over-test4').onmouseenter=function(){
// 	this.lastElementChild.style.display='block'
// }
// document.querySelector('.over-test4').onmouseleave=function(){
// 	this.lastElementChild.style.display='none'
// }
// document.querySelector('.over-test5').onmouseenter=function(){
// 	this.lastElementChild.style.display='block'
// }
// document.querySelector('.over-test5').onmouseleave=function(){
// 	this.lastElementChild.style.display='none'
// }
// document.querySelector('.over-test6').onmouseenter=function(){
// 	this.lastElementChild.style.display='block'
// }
// document.querySelector('.over-test6').onmouseleave=function(){
// 	this.lastElementChild.style.display='none'
// }
// document.querySelector('.over-test7').onmouseenter=function(){
// 	this.lastElementChild.style.display='block'
// }
// document.querySelector('.over-test7').onmouseleave=function(){
// 	this.lastElementChild.style.display='none'
// }
// document.querySelector('.over-test8').onmouseenter=function(){
// 	this.lastElementChild.style.display='block'
// }
// document.querySelector('.over-test8').onmouseleave=function(){
// 	this.lastElementChild.style.display='none'
// }



//右侧固定显示
// document.querySelector('.icon-shouji').onmouseenter=function(){
// 	document.querySelector('.number-qrode').style.display='block';
// }
// document.querySelector('.icon-shouji').onmouseleave=function(){
// 	document.querySelector('.number-qrode').style.display='none';
// }