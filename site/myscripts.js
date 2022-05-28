




function soma() {

	var x1 = document.getElementById('x1').value;
	var x2 = document.getElementById('x2').value;
	var x3 =  parseInt(x1) + parseInt(x2);
return document.getElementById('resultado').innerHTML="[" +x3 +"]";;   // The function returns the product of p1 and p2
}

function time()
{
today=new Date();
h=today.getHours();
m=today.getMinutes();
s=today.getSeconds();
document.getElementById('txt').innerHTML=h+":"+m+":"+s;
setTimeout('time()',500);
}

