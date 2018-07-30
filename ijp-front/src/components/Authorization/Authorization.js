import React, { Component } from 'react';
import axios from 'axios';

import Input from '../Input/Input';

class Authorization extends Component {
	domain = 'http://ijp.northeurope.cloudapp.azure.com';
	loginEndpoint = this.domain + '/login';
	signupEndpoint = this.domain + '/signup';
	authGetRequest () {
		console.log(this);
		axios.get(this.loginEndpoint).then(res => {
			console.log(res);
		})
	}

	authPostRequest () {
		const data = {
			'login': 'ololo',
			'password': 'olololo'
		};

		axios.post(this.loginEndpoint, data).then(res => {
			console.log(res);
		})
	}

	singUpPostRequest () {
		const data = {
			"email": "asdf",
			"firstName": "striasdfng",
			"lastName": "strasdfing",
			"login": "asdf",
			"password": "strinaag"
		};

		axios.post(this.signupEndpoint, data).then(res => {
			console.log(res);
		})
	}

	render () {
		const style = {
			display: 'flex',
			flexDirection: 'column',
			maxWidth: '500px',
			width: '100%',
			margin: 'auto'
		};

		return (
			<div>
				<form style={style}>
					<Input inputType="email" />
					<Input inputType={"password"}/>
				</form>

				<div onClick={() => this.authGetRequest()}>Send Login get request</div>
				<div onClick={() => this.authPostRequest()}>Send Login post request</div>
				<div onClick={() => this.singUpPostRequest()}>Send Sing Up request</div>
			</div>
		)
	}
}

export default Authorization;