import React, {Component} from "react";
import PropTypes from 'prop-types';

// 클래스형 컴포넌트
class MyComponent extends Component {
    // 객체를 여러 번 생성해도 공유하기 위해 static으로 선언
    static defaultProps = {
        name:'기본 이름'
    };
    static propTypes = {
        name:PropTypes.string
    };

    render() {
        // 구조 분해 할당
        const {name, children} = this.props;

        return (
            <div>
                안녕하세요, 제 이름은 {name}입니다.<br/>
                children 값은 {children}입니다.
            </div>
        );
    }
}

export default MyComponent;