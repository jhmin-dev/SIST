import React, { useState } from "react";

const Say = () => {
    // 배열 구조 분해 할당
    // 예) const array = [1,2];
    // const [one, two] = array;

    // useState 함수 인자에는 상태의 초기 값을 전달
    const [message, setMessage] = useState('');
    // 이벤트 핸들러; 화살표 함수에서 한 줄일 때는 {} 생략 가능
    const onClickEnter = () => setMessage('안녕하세요!');
    const onClickLeave = () => setMessage('안녕히 가세요!');

    const [color, setColor] = useState('black');

    return(
        <div>
            <button onClick={onClickEnter}>입장</button>
            <button onClick={onClickLeave}>퇴장</button>
            {/* JSX 주석은 중괄호로 감싸야 주석으로 인식됨 */}
            {/* color:color와 동일; 변수명 color가 속성명으로, 변수값이 속성값으로 인식됨 */}
            <h1 style={{color}}>{message}</h1>
            <button style={{backgroundColor:'pink'}} onClick={() => setColor('pink')}>
                분홍색
            </button>
            <button style={{backgroundColor:'aqua'}} onClick={() => setColor('aqua')}>
                하늘색
            </button>
            <button style={{backgroundColor:'gold'}} onClick={() => setColor('gold')}>
                금색
            </button>
        </div>
    );
}

export default Say;