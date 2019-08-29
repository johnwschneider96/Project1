/**
 * 
 */

let openTicketsTable = document.getElementById('openTickets');
let openTicketsTableBody = openTicketsTable.getElementsByTagName("tbody");
let openTicketsRows = openTicketsTableBody[0].getElementsByTagName('tr');

let actedTicketsTable = document.getElementById('actedTickets');
let actedTicketsTableBody = actedTicketsTable.getElementsByTagName("tbody");
let actedTicketsRows = actedTicketsTableBody[0].getElementsByTagName('tr');

window.onload = function(){
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
	
	xhttp.open("GET", 'http://LocalHost:8080/ProjectOneV1/html/Manager.go', true);
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
	//colStatus.appendChild(document.createTextNode(ticket.status));
	
	
	if(ticket.status==1){
	//********************************************
	//let colStatus = document.createElement('td');
	
	let p = document.createElement('p');
	
	let button = document.createElement('button');
	button.setAttribute('class','btn btn-primary');
	button.setAttribute('type','button');
	button.setAttribute('data-toggle','collapse');
	button.setAttribute('data-target','#collapseExample'+ticket.ticket_ID);
	button.setAttribute('aria-expanded','false');
	button.setAttribute('aria-controls','collapseExample');
	button.appendChild(document.createTextNode("Active"));
	
	p.appendChild(button);
	
	let div1 = document.createElement('div');
	div1.setAttribute('class','collapse');
	div1.setAttribute('id','collapseExample'+ticket.ticket_ID);
	
	let div2 = document.createElement('div');
	div2.setAttribute('class','card card-body');
	
	let form = document.createElement('form');
	form.setAttribute('action','Ticket.go');
	form.setAttribute('method','POST');
	
	let div3 = document.createElement('div');
	div3.setAttribute('class','form-group');
	
	let select = document.createElement('select');
	select.setAttribute('name','action');
	select.setAttribute('class','form-control');
	select.setAttribute('id','exampleFormControlSelect1');
	
	let option1 = document.createElement('option');
	option1.appendChild(document.createTextNode('Approve-'+ticket.ticket_ID));
	
	let option2 = document.createElement('option');
	option2.appendChild(document.createTextNode('Deny-'+ticket.ticket_ID));
	
	let button2 = document.createElement('button');
	button2.setAttribute('type','submit');
	button2.setAttribute('class','btn btn-primary');
	button2.appendChild(document.createTextNode('Submit'));
	
	select.appendChild(option1);
	select.appendChild(option2);
	
	div3.appendChild(select);
	div3.appendChild(button2);
	
	form.appendChild(div3);
	
	div2.appendChild(form);
	
	div1.appendChild(div2);
	
	colStatus.appendChild(p);
	colStatus.appendChild(div1);
	} else {
		if(ticket.status==2)
			colStatus.appendChild(document.createTextNode("Approved"));
		else
			colStatus.appendChild(document.createTextNode("Denied"));
	}
	
	//********************************************
	
	row.appendChild(colUser);
	row.appendChild(colAmnt);
	row.appendChild(colType);
	row.appendChild(colStatus);
	
	if(ticket.status == 1)
		openTicketsTableBody[0].appendChild(row);
	else
		actedTicketsTableBody[0].appendChild(row);
}

function addDropDown() {
	let colStatus = document.createElement('td');
	colStatus.appendChild(document.createTextNode(ticket.status));
	
	let p = document.createElement('p');
	
	let button = document.createElement('button');
	button.setAttribute('class','btn btn-primary');
	button.setAttribute('type','button');
	button.setAttribute('data-togle','collapse');
	button.setAttribute('data-target','#collapseExample');
	button.setAttribute('aria-expanded','false');
	button.setAttribute('aria-controls','collapseExample');
	button.appendChild(document.createTextNode("Active"));
	
	p.appendChild(button);
	
	let div1 = document.createElement('div');
	div1.setAttribute('class','collapse');
	div1.setAttribute('id','collapseExample');
	
	let div2 = document.createElement('div');
	div2.setAttribute('class','card card-body');
	
	let form = document.createElement('form');
	form.setAttribute('action','Ticket.go');
	form.setAttribute('method','POST');
	
	let div3 = document.createElement('div');
	div3.setAttribute('class','form-group');
	
	let select = document.createElement('select');
	select.setAttribute('name','action');
	select.setAttribute('class','form-control');
	select.setAttribute('id','exampleFormControlSelect1');
	
	let option1 = document.createElement('option');
	option1.appendChild(document.createTextNode('Approve'));
	
	let option2 = document.createElement('option');
	option2.appendChild(document.createTextNode('Deny'));
	
	let button2 = document.createElement('button');
	button2.setAttribute('type','submit');
	button2.setAttribute('class','btn btn-primary');
	button2.appendChild(document.createTextNode('Submit'));
	
	select.appendChild(option1);
	select.appendChild(option2);
	
	div3.appendChild(select);
	div3.appendChild(button2);
	
	form.appendChild(div3);
	
	div2.appendChild(form);
	
	div1.appendChild(div2);
	
	colStatus.appendChild(div1);
	colStatus.appendChild(p);
}














