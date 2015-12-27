function mascara(o, f) {
	v_obj = o;
	v_fun = f;
	
	caret = getCaretPosition(v_obj);
	setTimeout("execmascara()", 1);
}

function getCaretPosition(ctrl) {
	var CaretPos = 0;
	if (document.selection) {
		ctrl.focus();
		var Sel = document.selection.createRange();
		Sel.moveStart('character', -ctrl.value.length);
		CaretPos = Sel.text.length;
	} else if (ctrl.selectionStart || ctrl.selectionStart == '0') { // Firefox
		CaretPos = ctrl.selectionStart;
	}
	return (CaretPos);
}

function execmascara() {
	v_obj.value = v_fun(v_obj.value);
}

function sondaComandos(s){
	s = s.replace(/[^lLrRmM-\s]/g,"").toUpperCase();
	return s;
}

function sondaDirecoes(s){
	s = s.replace(/[^nNsSwWeE-\s]/g,"").toUpperCase();
	return s;
}

function somenteNumeros(s){
	s = s.replace(/\D/g,"");
	return s;
}