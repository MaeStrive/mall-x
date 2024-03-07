document.querySelector('.content-title').onclick = function(event){
	
	if(event.target.tagName =='LI'){
		//1、删除act
		document.querySelector('.content-title .act').classList.remove('act')
		//2、添加act
		event.target.classList.add('act')
		
		//内容区
		//1、删除act
		document.querySelector('.content .act').classList.remove('act')
		
		//2、添加act
		// document.querySelector('.content .act').classList.add('act')
		var liIdx = event.target.getAttribute('id')
		document.querySelectorAll('.content li')[liIdx].classList.add('act')
		
	}
}