function validateSubmit() {
	let list = document.getElementsByTagName('li');
	for(let i=0;i<list.length;i++) {
		let input = list[i].querySelector('input,textarea');
		input.value = input.value.trim();
		if(!input.value) {
			let word = list[i].querySelector('label').textContent;
			let post = (word.charCodeAt(word.length-1) - '가'.charCodeAt(0)) % 28 > 0 ? '을' : '를';
			alert(word + post + ' 입력하세요!');
			input.focus();
			return false;
		}
	}
}

function getBytesLength(str) {
    let bytes = 0;
    for(let i=0;i<str.length;i++) {
        let unicode = str.charCodeAt(i);
        bytes += unicode >> 11 ? 3 : (unicode >> 7 ? 2 : 1); // 2^11=2048로 나누었을 때 몫이 있으면 3bytes, 그보다 작은 수이면서 2^7=128로 나누었을 때 몫이 있으면 2bytes, 그 외에는 1byte
    }
    return bytes;
}