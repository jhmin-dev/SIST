import React from 'react';
import './App.css'; // 외부 CSS 파일 불러오기

function App() {
  const name = '리액트';

  // 인라인 스타일링
  const style = {
    // CSS 속성명을 카멜 표기법으로 변경
    backgroundColor:'black',
    color:'aqua',
    fontSize:'48px',
    fontWeight:'bold',
    padding:16, // 단위 생략시 px로 지정; 마지막에 , 있어도 무관
  };
  // return <div style={style}>{name}</div>;
  
  return ( // 태그에 스타일을 직접 명시할 때는 중괄호 2개 사용
    <div
      style={{
        backgroundColor:'black',
        color:'orange',
        fontSize:'48px',
        fontWeight:'bold',
        padding:16
      }}
    >
      {name}
    </div>
  );

  // 외부 CSS 파일에 정의한 스타일 적용
  /*
  return(
    <div>
      <div className='react'>{name}</div>
    </div>
  );
  */
}

export default App;