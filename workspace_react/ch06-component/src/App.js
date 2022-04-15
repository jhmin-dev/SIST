import React from "react";
import MyComponent from "./MyComponent";

/*
function App() {
  return <MyComponent name="Web Service">리액트</MyComponent>;
}
*/

// 숫자를 전달하면 콘솔에 경고 출력하여 propTypes가 잘못되었음을 알림
const App = () => {
  return <MyComponent name={1234}>React</MyComponent>;
}

export default App;