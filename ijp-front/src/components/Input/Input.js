import React from 'react';

const input = (props) => {
	const style = {
		padding: '5px 10px',
		display: 'inline-block',
		marginBottom: '25px',
		fontSize: '16px'
	};

	return (
		<input style={style} type={props.inputType} />
	)
};

export default input;