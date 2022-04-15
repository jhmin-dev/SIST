import React from 'react'; // 리액트 모듈로부터 리액트 객체 불러오기

function App() {
  const name = '리액트';
  const number = 0;
  const name2 = undefined;
  // JSX 내부에서는 if문 사용 불가; 조건부 연산자로 대체
  /*
  return (
    <div>
      {name === '리액트' ? <h1>리액트입니다</h1> : <h1>리액트가 아닙니다</h1>}
    </div>
  );
  */

  // AND 연산자(&&)를 사용한 조건부 렌더링
  // && 연산자로 조건부 렌더링을 사용하면 false일 때 아무것도 나타나지 않지만, 전건이 숫자 0이면 0은 보여짐
  // return number && <div>내용</div>;

  // undefined를 반환하면 오류가 발생하기 때문에 아래와 같이 오류 방지
  return <div>{name2 || '리액트'}</div>;
}

export default App;