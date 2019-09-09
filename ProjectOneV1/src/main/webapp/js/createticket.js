/**
 * 
 */

let pastTicketsTable = document.getElementById('pastTickets');
let pastTicketsTableBody = pastTicketsTable.getElementsByTagName("tbody");
let pastTicketsRows = pastTicketsTableBody[0].getElementsByTagName('tr');

window.onload = function(){
	let username = localStorage.getItem('username')
	
	document.getElementById("welcome").innerHTML = 'Welcome Employee: ' + username;
	
	getTickets();
}

function getTickets(){
	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if(xhttp.readyState == 4 && xhttp.status == 200) {
			let tickets = JSON.parse(xhttp.responseText);
			setValues(tickets);
		}
	}
	
	xhttp.open("GET", 'http://LocalHost:8080/ProjectOneV1/html/PastTickets.go', true);
	xhttp.send();
};

function setValues(tickets) {
	for(i=0;i<tickets.length;i++){
		populate(tickets[i]);
	}
}

function populate(ticket) {
	let row = document.createElement('tr');
	
	let header = document.createElement('th');
	header.setAttribute('scope','row');
	header.appendChild(document.createTextNode(ticket.ticket_ID));
	
	row.appendChild(header);
	
	let colUser = document.createElement('td');
	colUser.appendChild(document.createTextNode(ticket.employee_username));
	
	let colAmnt = document.createElement('td');
	colAmnt.appendChild(document.createTextNode(ticket.amount));
	
	let colType = document.createElement('td');
	colType.appendChild(document.createTextNode(ticket.type));
	
	let colStatus = document.createElement('td');
	
	let status = '';
	
	switch(ticket.status)
	{
	case 1:
		status = 'Active';
		break;
	case 2:
		status = 'Approved';
		break;
	default:
		status = 'Denied';
		break;
	}
	
	colStatus.appendChild(document.createTextNode(status));
	
	let colDescription = document.createElement('td');
	
	let d_p = document.createElement('p');
	
	let d_button = document.createElement('button');
	d_button.setAttribute('class','btn btn-primary');
	d_button.setAttribute('type','button');
	d_button.setAttribute('data-toggle','collapse');
	d_button.setAttribute('data-target','#d_collapse'+ticket.ticket_ID);
	d_button.setAttribute('aria-expanded','false');
	d_button.setAttribute('aria-controls','collapseExample');
	d_button.appendChild(document.createTextNode("View Description"));
	
	d_p.appendChild(d_button);
	
	let d_div1 = document.createElement('div');
	d_div1.setAttribute('class','collapse');
	d_div1.setAttribute('id','d_collapse'+ticket.ticket_ID);
	
	let d_div2 = document.createElement('div');
	d_div2.setAttribute('class','card card-body');
	
	d_div2.appendChild(document.createTextNode(ticket.description));
	
	d_div1.appendChild(d_div2);
	
	colDescription.appendChild(d_div1);
	colDescription.appendChild(d_p);
	
	row.appendChild(colUser);
	row.appendChild(colAmnt);
	row.appendChild(colType);
	
	row.appendChild(colDescription);
	
	row.appendChild(colStatus);
	
	pastTicketsTableBody[0].appendChild(row);
}














