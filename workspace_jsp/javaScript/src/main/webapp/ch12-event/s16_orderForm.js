window.onload = function() {
	// 동적으로 <label> 태그를 생성하여 <input> 태그 및 텍스트 감싸기
	let tds = document.querySelector('tr + tr').getElementsByTagName('td'); // <input> 태그가 포함된 <td> 태그를 선택
	for(let i=0;i<tds.length;i++) {
		tds[i].appendChild(document.createElement('label')); // <td> 태그마다 <label> 태그를 생성; <label>은 <td>의 마지막 자식 노드가 됨
	}
	let labels = document.querySelector('tr + tr').getElementsByTagName('label');
	for(let i=0;i<labels.length;i++) {
		let length = tds[i].childNodes.length - 1; // <label>의 형제 노드들의 수를 구함
		for(let j=0;j<length;j++) {
			labels[i].appendChild(tds[i].firstChild); // <label>의 형제 노드를 <label>의 자식 노드로 이동
		}
	}

	// 동적으로 <label> 태그를 생성하여 <img> 태그에 <input> 태그 연결하기
	let imgs = document.querySelector('tr').getElementsByTagName('td');
	for(let i=0;i<imgs.length;i++) {
		imgs[i].appendChild(document.createElement('label')); // <img> 태그가 포함된 <td> 태그에 자식 태그로 <label> 태그 추가
		imgs[i].querySelector('label').appendChild(imgs[i].querySelector('img')); // <img> 태그를 <label>의 자식 태그로 이동
		imgs[i].querySelector('label').htmlFor = 'c' + i; // <label> 태그의 for 속성에 대응하는 <input> 태그의 id 속성값 대입
	}

	// id가 price인 <tr> 태그의 자식 <td> 태그로부터 상품 가격 값을 추출
	let prices = document.querySelectorAll('#price > td');
	let prices_int = [];
	for(let i=0;i<prices.length;i++) {
		prices_int[i] = parseInt(prices[i].innerHTML.substring(1)) * 10000; // 첫 번째 (를 무시하기 위해 substring()를, 숫자 이후의 문자를 무시하기 위해 parseInt()를 사용
	}

	let prices_total = 0;
	let shipping = 0;

	let goods = document.getElementsByName('goods');
	let spans = document.getElementsByTagName('span');

	for(let i=0;i<goods.length;i++) {
		// 이벤트 연결
		goods[i].onclick = function() {
			if(this.checked) { // 체크박스가 선택되면
				prices_total += prices_int[i]; // 총 상품 가격에 선택된 상품의 가격만큼 누적
			}
			else { // 체크박스가 해제되면
				prices_total -= prices_int[i]; // 총 상품 가격에서 선택 해제된 상품의 가격만큼 차감
			}
			if(prices_total==0 || prices_total>=300000) { // 총 상품 가격이 0이거나 30만원 이상인 경우
				shipping = 0; // 배송비를 0으로 설정
			}
			else { // 총 상품 가격이 0을 초과하고 30만원 미만인 경우
				shipping = 5000; // 배송비를 5000으로 설정
			}
			// 화면에 총 상품 가격, 배송비, 총 주문 금액을 출력
			spans[0].innerHTML = prices_total;
			spans[1].innerHTML = shipping;
			spans[2].innerHTML = prices_total + shipping;
		};
	}
};