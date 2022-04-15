import React, {Component} from "react";

// 클래스형 컴포넌트
class Counter extends Component {
    // 컴포넌트 내부에서 읽고 또 업데이트할 수 있는 값을 사용하려면 state를 사용
    // 기본값을 미리 설정해야 사용 가능하며, this.setState() 메서드로만 업데이트 수행
    state = {
        number:0,
        countNumber:0,
        fixedNumber:10
    };

    render() {
        // state를 조회할 때는 this.state로 조회
        const {number, countNumber, fixedNumber} = this.state;
        
        // 이벤트 연결시 태그의 이벤트 속성을 이용하며, 중괄호 안에서 함수 형태(=이벤트 핸들러)로 이벤트를 명시
        return (
            <div>
                <h1>{number}, {countNumber}</h1>
                <h4>바뀌지 않는 값: {fixedNumber}</h4>
                <button
                    onClick={() => {
                        this.setState({number:number+1,countNumber:countNumber+2});
                    }}
                >숫자 증가시키기</button>
            </div>
        );
    }
}

export default Counter;