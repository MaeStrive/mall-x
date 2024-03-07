// 获取产品总数
var list=document.querySelectorAll('.list-body'),
	totalGoods=0; 
for(var i=0;i<list.length;i++){
		totalGoods+=parseFloat(list[i].querySelector('.num').value)
	}
document.querySelector('#product-num').innerText=totalGoods.toFixed(0)


// 购物车标题全选按钮
document.querySelector('.allChec').onclick=function(){
	var list=document.querySelectorAll('.list-body');
	var totalCost=0;
	var totalGoods=0;
	for(var i=0;i<list.length;i++){
		list[i].querySelector('.chec1').checked=this.checked
		totalGoods+=parseFloat(list[i].querySelector('.num').value)
		if(this.checked){
			totalCost+=parseFloat(list[i].querySelector('.cost1').innerText)
		}
	}
	document.querySelector('.cart-bottom button').classList.toggle('act')
	document.querySelector('#product-num').innerText=totalGoods.toFixed(0)
	document.querySelector('#choice-num').innerText=this.checked?totalGoods.toFixed(0):0;
	document.querySelector('#total-num').innerText=totalCost.toFixed(2)
}


// 购物车商品信息委托事件
document.querySelector('.cart-list').onclick=function(e){
	if(!e.target){
		console.log(e,e.target)
		return;
	}
	switch(e.target.classList[0]){
		case 'chec1':
			checkGood(e.target)
			break;
		case 'num-reduce':
			reduce(e.target)
			break;
		case 'num-add':
			add(e.target)
			break;
		case 'del':
			del(e.target)
			break;
		default:
			break;
	}
	
}


var minNum=1;
var maxNum=10;	
// 选择商品行
function checkGood(dom){
	var goodsCost=dom.parentNode.parentNode.querySelector('.cost1').innerText,
		goodsNum=dom.parentNode.parentNode.querySelector('.num').value;
	if(dom.checked){
		document.querySelector('#choice-num').innerText=
			(parseFloat(document.querySelector('#choice-num').innerText)+parseFloat(goodsNum)).toFixed(0)
		document.querySelector('#total-num').innerText=
			(parseFloat(document.querySelector('#total-num').innerText)+parseFloat(goodsCost)).toFixed(2)
		
		//去结算按钮背景
		document.querySelector('.cart-bottom button').classList.add('act')
	}else{
		document.querySelector('#choice-num').innerText=
			(parseFloat(document.querySelector('#choice-num').innerText)-parseFloat(goodsNum)).toFixed(0)
		document.querySelector('#total-num').innerText=
			(parseFloat(document.querySelector('#total-num').innerText)-parseFloat(goodsCost)).toFixed(2)
			

		//去结算按钮背景
		document.querySelector('.cart-bottom button').classList.remove('act')

	}
	// 改变全选按钮状态
	var checkNum=parseFloat(document.querySelector('#choice-num').innerText),
	    totalNum=parseFloat(document.querySelector('#product-num').innerText)
	if(checkNum==totalNum){
		document.querySelector('.allChec').checked=true

	}else{
		document.querySelector('.allChec').checked=false

	}
}

// 减数量
function reduce(dom){
	dom.nextElementSibling.value--;
	totalGoods--;
	if(!(dom.nextElementSibling.value>minNum)){
		document.querySelector('.alert-box').style.display='block';//弹窗
		dom.disabled=true;
	}
	if(dom.nextElementSibling.nextElementSibling.disabled){
		dom.nextElementSibling.nextElementSibling.disabled=false;
	}
	
	var price=dom.parentNode.previousElementSibling.innerText
	var num=dom.nextElementSibling.value
	dom.parentNode.nextElementSibling.innerText=(parseFloat(price)*num).toFixed(2)
	// 改变购物车数量和金额统计
	var totalNum=parseFloat(document.querySelector('#product-num').innerText)
	if(dom.parentNode.parentNode.querySelector('.chec1').checked){
		// var checkNum=parseFloat(document.querySelector('#choice-num').innerText)
		// document.querySelector('#choice-num').innerText=--checkNum
		// var totalCost=parseFloat(document.querySelector('#total-num').innerText)
		// document.querySelector('#total-num').innerText=
		// 	(totalCost-dom.parentNode.parentNode.querySelector('.cost1').innerText).toFixed(2);

			
			//2、改变当前商品  小计   金额
			var price = dom.parentNode.previousElementSibling.innerText,//单价
				pNum = dom.nextElementSibling.value;
			
			dom.parentNode.nextElementSibling.innerText = price * pNum;
			
			//3、改变合计金额
			document.querySelector('#total-num').innerText -= price; 
			
			
			
	}
	document.querySelector('#product-num').innerText=--totalNum
	document.querySelector('#choice-num').innerText=--document.querySelector('#choice-num').innerText
	
	
	

}



// 加数量
function add(dom){
	dom.previousElementSibling.value++
	totalGoods++;
	// 改变自己的按钮disabled属性
	if(!(dom.previousElementSibling.value<maxNum)){
		dom.disabled=true;
	}
	// 改变减号按钮disabled属性
	if(dom.previousElementSibling.previousElementSibling.disabled){
		dom.previousElementSibling.previousElementSibling.disabled=false;
	}
	// 改变产品小计的内容
	var price=dom.parentNode.previousElementSibling.innerText
	var num=dom.previousElementSibling.value
	dom.parentNode.nextElementSibling.innerText=(parseInt(price)*num).toFixed(2)
	// 改变购物车数量和金额统计
	var totalNum=parseFloat(document.querySelector('#product-num').innerText)
	
	if(dom.parentNode.parentNode.querySelector('.chec1').checked){
			
		//2、改变当前商品  小计   金额
		var price = dom.parentNode.previousElementSibling.innerText,//单价
			pNum = dom.previousElementSibling.value;
		
		dom.parentNode.nextElementSibling.innerText = price * pNum;
		var totalCost=parseFloat(document.querySelector('#total-num').innerText)
		document.querySelector('#total-num').innerText=(parseFloat(totalCost)+parseFloat(price))
	}
	document.querySelector('#product-num').innerText=++totalNum
	document.querySelector('#choice-num').innerText=++document.querySelector('#choice-num').innerText
	
	
		if(dom.previousElementSibling.value>=10){
			alert('已达商品购买上限');
			return;
		}
}

// 删除
function del(dom){
	var msg='确认删除吗'
	var nn = document.querySelectorAll('.list-body').length;
	if(confirm(msg)){
		if(nn == 1){
			document.querySelector('.cart-list').style.display = 'none';
			document.querySelector('.cart-bottom').style.display = 'none';
			document.querySelector('.zero').style.display = 'block';
		}
		var node=dom.parentNode.parentNode
		document.querySelector('#result').removeChild(node)
		
		totalGoods-=node.querySelector('.num').value
		// 改变购物车数量和金额统计
		var totalNum=parseFloat(document.querySelector('#product-num').innerText)
		if(node.querySelector('.chec1').checked){
			var checkNum=parseFloat(document.querySelector('#choice-num').innerText)
			var totalCost=parseFloat(document.querySelector('#total-num').innerText)
			document.querySelector('#choice-num').innerText=
				(checkNum-node.querySelector('.num').value).toFixed(0)
			document.querySelector('#total-num').innerText=
				(totalCost-node.querySelector('.cost1').innerText).toFixed(2)
		}
		document.querySelector('#product-num').innerText=
			(totalNum-node.querySelector('.num').value).toFixed(0)
			
			// 改变全选按钮状态
			var checkNum=parseFloat(document.querySelector('#choice-num').innerText),
			    totalNum=parseFloat(document.querySelector('#product-num').innerText)
			if(checkNum==totalNum){
				document.querySelector('.allChec').checked=true
			}else{
				document.querySelector('.allChec').checked=false
			}
			
			
	}
}

//弹出框的确认按钮—————弹出框的隐藏
document.querySelector('#determine').onclick=function(){
	document.querySelector('.alert-box').style.display='none';
}


