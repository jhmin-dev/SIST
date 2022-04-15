import React from "react";

// props 값은 컴포넌트 함수의 파라미터로 받아와서 사용할 수 있음
/*
const MyComponent = (props) => {
    return <div>안녕하세요, {props.name}를 배우고 있습니다.</div>
}
*/

// 태그 사이의 내용을 보여주는 children
// JSX에서는 단독 태그라도 /로 닫아야 함
const MyComponent = (props) => {
    return (
        <div>
            안녕하세요, 제 이름은 {props.name}입니다.
            <br/>
            children 값은 {props.children}입니다.
        </div>
    );
}

// props 값을 따로 지정하지 않았을 때 보여줄 기본값을 설정하는 defaultProps
MyComponent.defaultProps = {
    name:'Spring Boot'
}

export default MyComponent;