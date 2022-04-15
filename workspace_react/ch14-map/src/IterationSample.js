import React, { useState } from "react";

// 함수형 컴포넌트
const IterationSample = () => {
    // 기본 데이터 사용
    const [names, setNames] = useState([
        {id:1, text:'눈사람'},
        {id:2, text:'얼음'},
        {id:3, text:'눈'},
        {id:4, text:'바람'}
    ]);
    const [inputText, setInputText] = useState('');
    // 새로운 항목을 추가할 때 사용할 id
    const [nextId, setNextId] = useState(5);

    // 이벤트 핸들러
    const onChange = (e) => setInputText(e.target.value);
    // 데이터 저장
    const onClick = () => {
        // concat(): 기존 배열(array)과 파라미터로 받은 값을 합쳐 새로운 배열을 생성
        const nextNames = names.concat({
            id:nextId,
            text:inputText
        });
        setNextId(nextId + 1);
        // names 값을 업데이트
        setNames(nextNames);
        setInputText('');
    };
    // 데이터 삭제
    const onRemove = (id) => {
        // filter(): 주어진 함수의 테스트를 통과하는 모든 요소를 모아 새로운 배열로 반환
        const nextNames = names.filter((name) => (name.id!==id));
        setNames(nextNames);
    };

    // 목록 만들기
    // map(): 배열 내의 모든 요소 각각에 대해 주어진 함수를 호출한 결과를 모아 새로운 배열을 반환
    const namesList = names.map((name) => (
        <li key={name.id} onDoubleClick={() => onRemove(name.id)}>
            {name.text}
        </li>
    ));

    return (
        <>
            <input value={inputText} onChange={onChange} />
            <button onClick={onClick}>추가</button>
            <ul>{namesList}</ul>
        </>
    );
}

export default IterationSample;