// 리액트 객체를 불러와서 사용.
// 리액트 앱을 만들 때 node_modules라는 디렉토리도 함께 생성되며, 해당 디렉토리에 react 모듈이 설치됨
import React, {Fragment} from 'react';

// App이라는 컴포넌트를 만들어 줌
// 함수형 컴포넌트
// 함수에서 반환하는 내용이 HTML처럼 보이지만, JSX로 작성된 것
// 이런 형식으로 작성된 코드는 브라우저에서 실행되기 위해 최종적으로 JavaScript 형태의 코드로 변환됨
function App() {
  const name = 'React'; // 변경이 없으면 const를 기본적으로 사용
  return( // 복수의 태그를 반환하는 경우에는 소괄호 필수
  /*
  <div>
    <h1>Hello {name}!</h1>
    <h2>잘 동작하나요?</h2>
  </div>
  */
  /*
  <Fragment>
    <h1>{name} 안녕!</h1>
    <h2>Fragment로 감싸기</h2>
  </Fragment>
  */
  <>
    <h1>{name} 안녕,</h1>
    <h2>빈 태그로 감싸기</h2>
  </>
  );
}

export default App;