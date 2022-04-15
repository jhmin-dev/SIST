import React, {Component} from "react";

// 클래스형 컴포넌트
class ValidationSample extends Component {
    state = {
        username:'',
        password:'',
        clicked:false
    }

    handleChange = (e) => {
        this.setState({
            [e.target.name]:e.target.value
        });
    };

    handleClick = () => {
        this.setState({
            clicked:true
        });
        if(this.state.username === '') {
            this.username.focus();
            return;
        }
        if(this.state.password === '') {
            this.password.focus();
            return;
        }
    };

    render() {
        return (
            <div>
                <h1>ref 연습</h1>
                <div>
                    <input
                        ref={(ref) => {
                            this.username = ref;
                        }}
                        type="text"
                        name="username"
                        placeholder="사용자명"
                        value={this.state.username}
                        onChange={this.handleChange}
                    />
                    <span>
                        {this.state.clicked && this.state.username === '' ? '이름은 필수' : ''}
                    </span>
                </div>
                <div>
                    <input
                        ref={(ref) => {
                            this.password = ref;
                        }}
                        type="password"
                        name="password"
                        placeholder="비밀번호"
                        value={this.state.password}
                        onChange={this.handleChange}
                    />
                    <span>
                        {this.state.clicked && this.state.password === '' ? '비밀번호는 필수' : ''}
                    </span>
                </div>
                <button onClick={this.handleClick}>확인</button>
            </div>
        );
    }
}

export default ValidationSample;