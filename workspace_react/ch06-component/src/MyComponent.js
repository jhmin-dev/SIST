import React from 'react';
import PropTypes from 'prop-types';

// 구조 분해 할당 문법(=객체에서 값을 추출하는 문법)을 통해 props 내부 값 추출하기
/*
const MyComponent = (props) => {
    // 구조 분해 할당
    const {name, children} = props;

    // const name = props.name;
    // const children = props.children;

    return (
        <div>
            안녕하세요, 제 이름은 {name}입니다.
            <br/>
            children 값은 {children}입니다.
        </div>
    );
}
*/

// 함수 파라미터가 객체라면 그 값을 바로 구조 분해 할당할 수 있음
const MyComponent = ({name, children}) => {
    return (
        <div>
            안녕하세요, 제 이름은 {name}입니다.
            <br/>
            children 값은 {children}입니다.
        </div>
    );
}

// PropTypes를 통한 props 검증
// name값은 문자열(string)로 전달
// 숫자로 전달시 화면상 오류는 없지만 콘솔에 경고 출력
MyComponent.propTypes = {
    name: PropTypes.string
}

export default MyComponent;