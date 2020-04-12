'use strict';

import sockjs from 'sockjs-client';
require('stompjs');

const register = registrations => {
	const socket = sockjs('/payroll');
	const stompClient = Stomp.over(socket);
	stompClient.connect({}, frame => {
		registrations.forEach(registration => {
			stompClient.subscribe(registration.destination, registration.callback);
		});
	});
}

export default register;
