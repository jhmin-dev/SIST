import React, {Component} from "react";

class EventPractice extends Component {
    state = {
        username: '',
        message:''
    }

    // 이벤트 핸들러 정의
    handleChange = (e) => {
        this.setState({
            // 객체 안에서 key를 []로 감싸면 그 안에 넣은 레퍼런스의 실제 값이 key 값으로 사용됨
            [e.target.name]:e.target.value
        });
    }

    handleClick = () => {
        alert(this.state.username + ':' + this.state.message);
        this.setState({
            username:'',
            message:''
        });
    }

    // enter 키 입력시 동작
    handleKeyPress = (e) => {
        if(e.key === 'Enter') {
            this.handleClick();
        }
    }

    render() {
        const {username, message} = this.state;

        return (
            <div>
                <h1>이벤트 연습</h1>
                <input
                    type="text"
                    name="username"
                    placeholder="사용자명"
                    value={username}
                    onChange={this.handleChange}
                />
                <input
                    type="text"
                    name="message"
                    placeholder="메시지"
                    value={message}
                    onChange={this.handleChange}
                    onKeyDown={this.handleKeyPress}
                />
                <button onClick={this.handleClick}>확인</button>
            </div>
        );
    }
}

export default EventPractice;