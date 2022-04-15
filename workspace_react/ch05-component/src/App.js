import React from "react";
import MyComponent from "./MyComponent";

/*
function App() {
  return <MyComponent name="react" />;
}
*/

// props 값을 따로 지정하지 않았을 때 보여줄 기본값을 설정하는 defaultProps
/*
function App() {
  return <MyComponent />;
}
*/

// 태그 사이의 내용을 보여주는 children
const App = () => {
  return <MyComponent>리액트</MyComponent>;
}

export default App;