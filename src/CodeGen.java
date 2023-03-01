class CodeGen{

	Float geraCodigo (ArvoreSintatica arv)
	{

	if (arv instanceof Mult)
		return (geraCodigo(((Mult) arv).arg1) * geraCodigo(((Mult) arv).arg2));

	if (arv instanceof Soma)
		return (geraCodigo(((Soma) arv).arg1) + geraCodigo(((Soma) arv).arg2));


	if (arv instanceof Sub)
		return (geraCodigo(((Sub) arv).arg1) - geraCodigo(((Sub) arv).arg2));


	if (arv instanceof Div)
		return (geraCodigo(((Div) arv).arg1) / geraCodigo(((Div) arv).arg2));

	if (arv instanceof Num)
		return (float)((Num) arv).num;

	return (float) 0;
	}
}
