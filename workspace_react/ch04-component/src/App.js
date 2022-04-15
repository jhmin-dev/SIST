import React, { Component } from 'react';
import './App.css';
import './MyComponent';
import MyComponent from './MyComponent';

// 함수형 컴포넌트
/*
function App() {
  const name = '리액트';
  return <div className='react'>{name}</div>;
}
*/

// 클래스형 컴포넌트
/*
class App extends Component {
  render() {
    const name = 'react';
    return <div className='react'>{name}</div>
  }
}
*/

// 익명 함수로 외부 파일 컴포넌트 불러오기
/*
const App = function() {
  return <MyComponent />;
};
*/

// 화살표 함수로 외부 파일 컴포넌트 불러오기
const App = () => {
  return <MyComponent />;
}

export default App;