function comandosSonda(s){
	s = s.replace(/[^lLrRmM-\s]/g,"").toUpperCase();
	return s;
}