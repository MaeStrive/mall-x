document.querySelector('.addAddress').onclick=function(){
	document.querySelector('#determine').innerText= '确定';
	document.querySelector('form').reset();
	document.querySelector('.alert-box').style.display='block';//弹窗
	// document.querySelector('.alert-box').classList.add('active');//弹窗
	
	//添加时   编辑框取消聚焦状态
	document.querySelector('.pla-name').classList.remove('focus');
	document.querySelector('.pla-number').classList.remove('focus');
	document.querySelector('.pla-address').classList.remove('focus');
	document.querySelector('.pla-addressLabel').classList.remove('focus');
}

function close(n){
	n.parentNode.parentNode.parentNode.style.display='none';
}



//添加地址模块
document.querySelector('#determine').onclick=function(){
	//取值
	var name = document.querySelector('#input-name');
	var num = document.querySelector('#input-number');
	var lookup = document.querySelector('#input-lookup');
	var address = document.querySelector('#input-address');
	var addressLabel = document.querySelector('#input-addressLabel');
	
	//创建
	var divEle = document.createElement('div')
	
		divEle.innerHTML = `
			<div class="address-list">
				<div class="addressBox clearfix">
					<div class="address-label">${addressLabel.value}</div>
					<div class="address-name">${name.value}</div>
					<div class="address-number">${num.value}</div>
					<div  class="address-address">${address.value}</div>
					<div class="address-detailed">${lookup.value}</div>
					<div class="address-change">
						<span class="address-changeed">修改</span>
						<span class="address-dele">删除</span>
					</div>
				</div>
			</div>
	`
	// console.log(divEle)
	
	if(!nameElement.value){
		alert('请输入姓名');
		return;
	}else if(numberElement.value.length<11||numberElement.value.length>11){
			alert('请输入正确手机号');
			return;
	}else if(!document.querySelector('.input-lookup').value){
		alert('请输入地址');
		return;
	}else if(!document.querySelector('.input-address').value){
		alert('请输入详细地址');
		return;
	}else if(!document.querySelector('.input-addressLabel').value){
		alert('请输入地址标签');
		return;
	}else if(document.querySelector('#determine').innerText=='确定'){
		document.querySelector('.add-box').appendChild(divEle);
	}
	
	//清空表单
	
	document.querySelector('form').reset();
	document.querySelector('.alert-box').style.display='none';
}

//修改事件  
function addressChange(n){
	document.querySelector('.alert-box').style.display='block';
	
	//修改时取值后   编辑框进入聚焦状态
	document.querySelector('.pla-name').classList.add('focus');
	document.querySelector('.pla-number').classList.add('focus');
	document.querySelector('.pla-address').classList.add('focus');
	document.querySelector('.pla-addressLabel').classList.add('focus');
	
	
	//取值
	document.querySelector('#input-name').value = n.parentNode.parentNode.children[1].innerText;
	document.querySelector('#input-number').value = n.parentNode.parentNode.children[2].innerText;
	document.querySelector('#input-lookup').value = n.parentNode.parentNode.children[3].innerText;
	document.querySelector('#input-address').value = n.parentNode.parentNode.children[4].innerText;
	document.querySelector('#input-addressLabel').value = n.parentNode.parentNode.children[0].innerText;
	
	document.querySelector('#determine').innerText= '保存修改';
	
	document.querySelector('#determine').onclick=function(){
		if(document.querySelector('#determine').innerText=='保存修改'){
			save(n);
		}
	}
	
}

//保存地址事件
function save(n){
	n.parentNode.parentNode.children[1].innerText = document.querySelector('#input-name').value ;
	n.parentNode.parentNode.children[2].innerText = document.querySelector('#input-number').value ;
	n.parentNode.parentNode.children[3].innerText = document.querySelector('#input-lookup').value ;
	n.parentNode.parentNode.children[4].innerText = document.querySelector('#input-address').value ;
	n.parentNode.parentNode.children[0].innerText = document.querySelector('#input-addressLabel').value ;
	
	document.querySelector('.alert-box').style.display='none';
}

//地址模块  删除按钮事件
function addressDele(n){
	document.querySelector('.add-box').removeChild(n.parentNode.parentNode.parentNode.parentNode);
	
}




//发票事件

function invoice(){
	alert(12)
	// $('.invoice').css('display','block')
	
}




$('body').click(function(e){
	switch(e.target.classList[0]){
		case 'address-changeed':
		addressChange(e.target);
			break;
		case 'address-dele':
		addressDele(e.target);
			break;
		case 'invoice':
		invoice(e.target);
			break;
		case 'close':
		close(e.target);
			break;
		case 'cancel':
		close(e.target);
			break;
		default:
			break;
		
	}
	
	
})




