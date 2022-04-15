import React, {Component} from "react";

class EventPractice extends Component {
    // state 추가
    state = {
        message: ''
    }

    render() {
        return (
            <div>
                <h1>이벤트 연습</h1>
                {/* JSX에서는 input, br처럼 원래 단독 태그인 HTML 태그들도 시작과 끝을 명시해야 함 */}
                {/* input 태그에서 입력된 값이 변화하면 state의 값에 반영 */}
                <input
                    type="text"
                    name="message"
                    placeholder="아무거나 입력해보세요"
                    value={this.state.message}
                    onChange={(e) => {
                        this.setState({message:e.target.value});
                    }}
                />
                {/* 현재 state 값을 alert으로 보여준 후 초기화 */}
                <button
                    onClick={() => {
                        alert(this.state.message);
                        this.setState({message:''});
                    }}
                >확인</button>
            </div>
        );
    }
}

export default EventPractice;